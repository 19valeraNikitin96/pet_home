from _pytest.fixtures import fixture

from pet_home_testing import App


class ApiV1(App):
    _first_user_ad = {
        "pet-name": "Tom",
        "signs": [
            "black spot",
            "white color"
        ],
        "age": 2,
        "type": "OBSERVED",
        "location": {
            "city": "Kyiv",
            "district": "Solomenskiy",
            "street": "Shevchenka"
        },
        "date": {
            "day": 13,
            "month": 5,
            "year": 2021
        },
        "owner-id": 99999
    }

    _second_user_ad = {
            'id': 99998,
            "pet-name": "Noname",
            "signs": [
                "black spot",
                "white color"
            ],
            "age": 1,
            "type": "FOUND",
            "location": {
                "city": "Kharkiv",
                "district": "Kyivskyi",
                "street": "Industrialna"
            },
            "date": {
                "day": 13,
                "month": 5,
                "year": 2021
            },
            "owner-id": 99998
        }

    def get_url_prefix(self) -> str:
        return f"{super().get_url_prefix()}v1/"

    @fixture
    def first_user_ad(self):
        return self._first_user_ad

    @fixture
    def second_user_ad(self):
        return self._second_user_ad
