package com.tweets.api.tweet.infrastructure;

import org.springframework.stereotype.Component;

import com.tweets.api.tweet.domain.Tweet;

@Component
public class TweetMapper implements ITweetMapper {

    @Override
    public Tweet toDomain(TweetModel model) {
        Tweet domain = new Tweet();
        domain.setUsername(model.getUsername());
        domain.setMessage(model.getMessage());    
        domain.setSent(model.getSent());
        return domain;
    }

    @Override
    public TweetModel toModel(Tweet domain) {
        TweetModel model = new TweetModel();
        model.setUsername(domain.getUsername());
        model.setMessage(domain.getMessage());    
        model.setSent(domain.getSent());
        
        return model;
        
    }

}
