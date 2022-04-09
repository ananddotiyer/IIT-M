# This app has been deployed using GitHub streamlit at
# https://share.streamlit.io/ananddotiyer/iit-m/main/DiscourseApp/app.py
# To run it locally, run the command "streamlit run app.py"
# Access it locally at http://localhost:8501

import streamlit as st
import pandas as pd
import numpy as np
import requests
import json

# df = pd.DataFrame(
#     np.random.randn(10, 5),
#     columns=('col %d' % i for i in range(5)))

# st.table(df)

def get_topics(course):
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

def get_topics_from_url(url):
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

    idx = -1
    topics = []
    all_topics = []
    while idx < 10: # first 10 pages
        idx += 1
        try:
            params = (
                ('page', str(idx)),
            )

            response = requests.get(url, headers=headers, params=params)

            response = json.loads(response.content)['topic_list']
            
            topics = [(topic['slug'], topic['id'], topic['tags']) for topic in response['topics']]
            all_topics.extend(topics)
        except:
            pass
    print(all_topics)
    return all_topics

def get_topic_urls(course=None, url=None):
    tags_list = []
    if course:
        all_topics = get_topics(course)
    else:
        all_topics = get_topics_from_url(url)

    topic_urls = {'URL': [], 'Tags': []}

    for topic in all_topics:
        url = f'https://discourse.onlinedegree.iitm.ac.in/t/{topic[0]}/{topic[1]}'
        topic_urls['URL'].append(url)
        topic_urls['Tags'].append(topic[2])
    return topic_urls

def make_clickable(link):
    return f'<a target="_blank" href="{link}">{link}</a>'

def discourse_data(course=None, url=None):
    urls = get_topic_urls(course=course, url=url)
    topic_urls = pd.DataFrame(urls, index=range(1,len(urls['URL']) + 1))
    topic_urls['URL'] = topic_urls['URL'].apply(make_clickable)
    return topic_urls.to_html(escape=False)
    
#main program
course = None
url = None
search_what = st.radio("Search", ["Search course", "Search URL"])
if search_what == "Search course":
    options = ['mlt', 'tds', 'mlf', 'bdm']
    course = st.selectbox("Select course slug:", options)
    if st.button("Search Course"):
        data = discourse_data(course=course, url=url)
        # print(data)
        st.write(data, unsafe_allow_html=True)
else:
    url = st.text_input("Enter the URL you want to search?:")
    print(url)
    if st.button("Search URL"):
        data = discourse_data(course=course, url=url)
        # print(data)
        st.write(data, unsafe_allow_html=True)