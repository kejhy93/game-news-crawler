#! /bin/bash

docker build --pull --rm -f "Dockerfile" -t game-news-crawler:latest "game-news-crawler"