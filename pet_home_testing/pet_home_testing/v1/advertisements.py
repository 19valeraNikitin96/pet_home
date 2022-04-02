import json

import requests

from pet_home_testing.v1 import ApiV1


class TestAdvertisementAPI(ApiV1):

    def test_create(self, first_user_ad):
        url = f"{self.get_url_prefix()}advertisements"

        payload = json.dumps(first_user_ad)
        headers = {
            'Content-Type': 'application/json'
        }

        response = requests.request("POST", url, headers=headers, data=payload)
        data = json.loads(response.text)

        id = data.get('id', None)
        assert id is not None, f"Could not find id in {data}"

        assert type(id) is int, f"ID has type {type(id)} instead {int}"

        first_user_ad['id'] = id

    def test_existence_of_created_ad(self, first_user_ad):
        url = f"{self.get_url_prefix()}advertisements"

        payload = json.dumps({
            'user-id': first_user_ad['owner-id'],
            "pov": "OWNER",
            "paged": {
                "current": 1,
                "size": 6
            }
        })
        headers = {
            'Content-Type': 'application/json'
        }

        response = requests.request("GET", url, headers=headers, data=payload)
        data = json.loads(response.text)

        assert first_user_ad['id'] in data['ids'], f"{first_user_ad['id']} does not belong to {data}"

    def test_existence_of_another_ad(self, first_user_ad, second_user_ad):
        url = f"{self.get_url_prefix()}advertisements"

        payload = json.dumps({
            'user-id': first_user_ad['owner-id'],
            "pov": "VIEWER",
            "paged": {
                "current": 1,
                "size": 6
            }
        })
        headers = {
            'Content-Type': 'application/json'
        }

        response = requests.request("GET", url, headers=headers, data=payload)
        data = json.loads(response.text)

        assert second_user_ad['id'] in data['ids'], f"{second_user_ad['id']} does not belong to {data}"
