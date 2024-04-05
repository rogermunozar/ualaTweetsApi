package com.tweets.api.tweet.domain;

import java.util.List;

public interface ITweetRepository {

    public List<Tweet> getTweets(String username);
    public String send(Tweet tweet);



}
