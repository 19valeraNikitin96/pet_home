import os


class App(object):
    protocol = os.environ.get('PROTOCOL', 'http')
    addr = os.environ.get('ADDR', '127.0.0.1')  # localhost
    port = os.environ.get('PORT', '8080')

    def get_url_prefix(self) -> str:
        return f"{self.protocol}://{self.addr}:{self.port}/"


first_user_data = {
        'id': 99999,
        'username': 'Bogdan1980',
        'password': '12345',
        'person': {
            'id': 99999,
            'firstname': 'Bogdan',
            'lastname': 'Tkach',
            'location_id': 99999,
        },
    }

second_user_data = {
        'id': 99998,
        'username': 'user123',
        'password': '54321',
        'person': {
            'id': 99998,
            'firstname': 'Andrii',
            'lastname': 'Bilous',
            'location_id': 99998,
        },
    }
