package com.tweets.api.timeline.domain;

import java.util.List;

import com.tweets.api.tweet.domain.Tweet;

public interface ITweetService {

    public String send(Tweet tweet);

    public List<Tweet> getTweets(String username);

}
