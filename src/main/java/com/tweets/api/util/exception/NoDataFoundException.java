package com.tweets.api.util.exception;

import com.tweets.api.tweet.application.TweetException;

public class NoDataFoundException extends TweetException{

    public NoDataFoundException(String cause) {
        super(cause);

    }

}
