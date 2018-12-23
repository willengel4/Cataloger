import urllib.request
import json
from pymongo import MongoClient
from datetime import datetime

#database init
mongo_client = MongoClient()
mongo_db = mongo_client.cataloger
mongo_db_fb = mongo_db.fb

#fb api init
tokens_json = json.loads(open('../tokens.json', 'r').read())
app_id = tokens_json['fb_app_id']
access_token = tokens_json['fb_access_token']
full_url = "https://graph.facebook.com/v3.2/368404187266545/feed?access_token=" + access_token

#api call
with urllib.request.urlopen(full_url) as response:
    
    #get response as json object
    html = response.read().decode('ASCII')
    parsed = json.loads(html)
    
    #posts traversal
    posts_array = parsed['data']
    for post in posts_array:

        #extract post data
        post_date_time = datetime.strptime(post['created_time'], '%Y-%m-%dT%H:%M:%S%z')
        post_message = post['message']
        post_id = post['id']

        #create post dictionary
        post_dict = { "_id" : post_id, "post_date": post_date_time, "post_message" : post_message }

        #insert post into db
        try:
            mongo_db_fb.insert_one(post_dict)
        
        #duplicate posts, etc
        except:
            continue

#prints the fb posts
posts = mongo_db_fb.find()
for post in posts:
    print('Post: ', post)