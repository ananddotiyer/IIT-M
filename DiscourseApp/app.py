# This app has been deployed using GitHub streamlit at
# https://share.streamlit.io/ananddotiyer/iit-m/main/DiscourseApp/app.py
# To run it locally, run the command "streamlit run app.py"
# Access it locally at http://localhost:8501

import streamlit as st
import pandas as pd
import numpy as np
import requests
import json
import re

# df = pd.DataFrame(
#     np.random.randn(10, 5),
#     columns=('col %d' % i for i in range(5)))

# st.table(df)

# In order to construct this header, follow https://stackoverflow.com/a/61140905/2021272
headers = {
    'authority': 'discourse.onlinedegree.iitm.ac.in',
    'sec-ch-ua': '" Not A;Brand";v="99", "Chromium";v="98", "Google Chrome";v="98"',
    'discourse-present': 'true',
    'x-csrf-token': 'lCOG4C6r8dl1L8DqCb3rumSTweMuiRw9Vcg3CSZL0O095WqueLw+l5e1t4W6O9PT45Ka6P7ftpgvC3h8eO7aHA==',
    'sec-ch-ua-mobile': '?0',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36',
    'discourse-logged-in': 'true',
    'accept': 'application/json, text/javascript, */*; q=0.01',
    'x-requested-with': 'XMLHttpRequest',
    'sec-ch-ua-platform': '"Windows"',
    'sec-fetch-site': 'same-origin',
    'sec-fetch-mode': 'cors',
    'sec-fetch-dest': 'empty',
    'referer': 'https://discourse.onlinedegree.iitm.ac.in/search?q=%23courses%3Amlt-kb&page=5',
    'accept-language': 'en-US,en;q=0.9',
    'cookie': '_fbp=fb.2.1637380711212.1076919782; theme_ids=3%7C1; _ga_5HTJMW67XK=GS1.1.1645333521.35.0.1645333541.0; _ga=GA1.1.1908036609.1604299898; _ga_WGM85Z9ZZV=GS1.1.1646198510.331.0.1646198510.0; _t=OHF2WStJZ242VUJNc21icCtGaVZBQ1RwNjZWRDVzRStwN2U1MVU1VFhzcWF1MU0yb1orQVdnUWRCSktZRDZvR3FQdnhVWXRSQjVSOW9YYWN5MmZDNFZERlJQUi9iK0lLRFVZNkVORDYremcvNjU4NTFEOHlZRVRnMnQ0RTB6ckNuTEFYSUxaTCtheU9ab2cvQngyclhycVhkeWhvRGY4UWtWZHFWU1BjWmU0SUdjRDNKR2lmWEUxKy9jZGhuOXV6V21QZ0RIY285Y1lVd3lSaHFOOWdjMDdDNWdlR2ROMkFtQ2RDS3BuSmNSYjIzV0VDSGNhNEJzL2ZRVkdxZzdac204V0ZWMUFkbFF6ZXJtLzFGVllQV3c9PS0tcFhMQnR5WDdZakZoMDRzWVNnclRydz09--1a4c7d2a822e70f7c73b37edcc4e40e7fa891e65; _forum_session=L2FYN0VkQVd2YkJtc3NqZnZhbDF3ajV0elU5WWExb3NVa3d0Sno0aU9rcGMzNzZZZnJmMmNzcitxTGVxSmd6TnRuSTM0enNKVWpoYzNHNTFjY0VhSmFWUzdzb0VVNHUzWTB0TEZWUTRyL052Qm9rQkVBWG0rNm9xOUtxVG9tUWdmNmEvelJ6WWM5Ri95clhmR1V1NnZFMS9zMnRrK0piSlptTXFtWkdsVDNwNVBMM2dNSXVBTUMxRFN6YlNQbzVCLS05Q25oSXpUL3I5bjFSdUhMSjVwd21nPT0%3D--24e550cf03b344244c0251655954eb965aa46dcf',
}

def get_topics(course):
    idx = -1
    topics = []
    all_topics = []
    while True:
        idx += 1
        try:
            params = (
                ('q', f'#courses:{course}-kb'),
                ('page', str(idx)),
            )

            response = requests.get('https://discourse.onlinedegree.iitm.ac.in/search', headers=headers, params=params)
            response = json.loads(response.content)
            
            old_topics = topics
            topics = [(topic['slug'], topic['id'], topic['tags']) for topic in response['topics']]
            if old_topics == topics:
                break
            else:
                all_topics.extend(topics)
        except:
            pass
    return all_topics

def get_topics_from_url(url, activities=False):
    idx = -1
    topics = []
    all_topics = []
    while idx < 25: # first 10 pages
        idx += 1
        try:
            params = (('page', str(idx)),)
            if not activities:
                response = requests.get(url, headers=headers, params=params)
                response = json.loads(response.content)['topic_list']
                topics = [(topic['slug'], topic['id'], topic['tags']) for topic in response['topics']]
            else:
                url = re.sub(r'offset=(\d+)', lambda m: 'offset={:g}'.format((float(m.group(1)) + idx) * 100), url)
                print(url)
                response = requests.get(url, headers=headers, params=params)
                response = json.loads(response.content)['user_actions']
                topics = [(topic['slug'], topic['topic_id'], topic['action_type']) for topic in response]
            all_topics.extend(topics)
        except Exception as e:
            print(e)
    return all_topics

# def get_topics_from_user(user):
#     topics = []
#     all_topics = []

#     url = f"https://discourse.onlinedegree.iitm.ac.in/topics/created-by/{user}.json"
#     print(url)
#     response = requests.get(url, headers=headers)
#     response = json.loads(response.content)['topic_list']
#     topics = [(topic['slug'], topic['id'], topic['tags']) for topic in response['topics']]
#     all_topics.extend(topics)
#     return all_topics

def get_topic_urls(course=None, search_what=None, user=None):
    all_topics = []
    from_url = True #Latest, Bookmarks, Top, My Posts, URL, User
    if course:
        from_url = False
        all_topics = get_topics(course)
    elif search_what == "User":
        url = f"https://discourse.onlinedegree.iitm.ac.in/topics/created-by/{user}.json"
    elif search_what == 'Latest':
        url = "https://discourse.onlinedegree.iitm.ac.in/latest"
    elif search_what == 'Bookmarks':
        url = "https://discourse.onlinedegree.iitm.ac.in/bookmarks"
    elif search_what == 'Top':
        url = "https://discourse.onlinedegree.iitm.ac.in/top"
    elif search_what == 'My posts':
        url = "https://discourse.onlinedegree.iitm.ac.in/posted"
    else:
        url = st.text_input("Enter the URL:")
    
    if from_url:
        print(url)
        all_topics = get_topics_from_url(url, activities=search_activites)

    topic_urls = {'URL': [], 'Tags': []}

    for topic in all_topics:
        url = f'https://discourse.onlinedegree.iitm.ac.in/t/{topic[0]}/{topic[1]}'
        topic_urls['URL'].append(url)
        topic_urls['Tags'].append(topic[2])
    return topic_urls

def make_clickable(link):
    return f'<a target="_blank" href="{link}">{link}</a>'

def discourse_data(course=None, search_what=None, user=None):
    urls = get_topic_urls(course=course, search_what=search_what, user=user)
    topic_urls = pd.DataFrame(urls, index=range(1,len(urls['URL']) + 1))
    if search_activites:
        # Eg.https://discourse.onlinedegree.iitm.ac.in/user_actions.json?offset=0&username=karthik_pod
        # For legend on activities, refer https://www.rubydoc.info/github/discourse/discourse/UserAction
        topic_urls.replace({1: 'Liked', 2: 'Was liked', 3: 'Bookmark', 4: 'New Topic', 
            5: 'Reply', 6: 'Response', 7: 'Mention', 9: 'Quote', 11: 'Edit', 
            15: 'Solved', 16: 'Assigned'}, inplace=True)
        topic_urls.drop_duplicates(inplace=True)
    else:
        topic_urls.drop_duplicates(subset=['URL'], inplace=True) # can't drop the second column, which is a list.
    topic_urls['URL'] = topic_urls['URL'].apply(make_clickable)
    return topic_urls.to_html(escape=False, col_space='75px')
    
#main program
course = None
url = None
user = None
search_what = st.radio("Search", ["Course", "Latest", "Bookmarks","Top", "My posts", "User", "URL"])
search_activites = st.checkbox("Search activites") # Search into activities.  This has a separate json format.
if search_what == "Course":
    options = ['mlt', 'tds', 'mlf', 'bdm']
    course = st.selectbox("Select course slug:", options)
    if st.button("Search Course"):
        data = discourse_data(course=course)
        # print(data)
        st.write(data, unsafe_allow_html=True)
else:
    if search_what == "User":
        user = st.text_input("Which user?")
    if st.button(f"Search {search_what}"):
        data = discourse_data(course=course, search_what=search_what, user=user)
        st.write(data, unsafe_allow_html=True)