import urllib.request
import json
from pymongo import MongoClient
from datetime import datetime

#database init
mongo_client = MongoClient()
mongo_db = mongo_client.cataloger
mongo_db_reddit = mongo_db.reddit

#reddit api init
full_url = "https://www.reddit.com/r/BojackHorseman/hot.json"

#api call
with urllib.request.urlopen(full_url) as response:
    
    #get response as json object
    html = response.read().decode('ASCII')
    parsed = json.loads(html)
    
    #posts traversal
    posts_array = parsed['data']['children']
    for post in posts_array:

        #extract post data
        post_id = post['data']['id']
        post_title = post['data']['title']
        post_text = post['data']['selftext']
        post_upvotes = post['data']['ups']
        post_downvotes = post['data']['downs']
        post_created_date_time = datetime.fromtimestamp(post['data']['created_utc'])

        #create post dictionary
        post_dict = { "_id" : post_id, 
        "post_title": post_title, 
        "post_text" : post_text, 
        "post_upvotes" : int(post_upvotes),
        "post_downvotes" : int(post_downvotes),
        "post_date" : post_created_date_time }

        #insert post into db
        try:
            mongo_db_reddit.insert_one(post_dict)
        
        #duplicate posts, etc
        except:
            continue

#prints the reddit posts
posts = mongo_db_reddit.find()
print(len(posts))