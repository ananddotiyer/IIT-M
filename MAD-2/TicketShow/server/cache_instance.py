from flask_caching import Cache
from flask import current_app as app


def make_cache():
    cache_mapping = {
        "CACHE_TYPE": "RedisCache",
        "CACHE_REDIS_HOST": "localhost",
        "CACHE_REDIS_PORT": 6379
    }

    app.config.from_mapping(cache_mapping)  # Setup Redis Cache

    cache = Cache(app)  # cache instance
    app.app_context().push()

    return cache


current_cache_inst = make_cache()
