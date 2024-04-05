package com.tweets.api.tweet.infrastructure;

import com.tweets.api.tweet.domain.Tweet;

public interface ITweetMapper{
    public Tweet toDomain(TweetModel model);
    public TweetModel toModel(Tweet domain);
}
