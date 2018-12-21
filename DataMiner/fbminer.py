import urllib.request
import json

tokens_json = json.loads(open('../tokens.json', 'r').read())
app_id = tokens_json['fb_app_id']
access_token = tokens_json['fb_access_token']
full_url = "https://graph.facebook.com/v3.2/368404187266545/feed?access_token=" + access_token
with urllib.request.urlopen(full_url) as response:
   html = response.read().decode('ASCII')
   parsed = json.loads(html)
   posts_array = parsed['data']
   for post in posts_array:
       post_date_time = post['created_time']
       post_message = post['message']
       post_id = post['id']