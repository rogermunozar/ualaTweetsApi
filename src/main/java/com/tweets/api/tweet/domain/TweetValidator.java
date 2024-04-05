package com.tweets.api.tweet.domain;

import org.springframework.stereotype.Component;

import com.tweets.api.util.Constants;

@Component
public class TweetValidator implements ITweetValidator{

    public Boolean isValid(Tweet tweet){        
        return 
            !tweet.getUsername().isEmpty() && 
            !tweet.getMessage().isEmpty() && 
            !(tweet.getMessage().length()>Constants.MAX_LENGTH_TWEET);
    }

}
