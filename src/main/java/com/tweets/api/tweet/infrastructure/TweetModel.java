package com.tweets.api.tweet.infrastructure;

import com.tweets.api.infrastructure.ES.SqlResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TweetModel {
    private String username;    
    private String sent;
    private String message;

    public TweetModel(SqlResponse resp, int i){        
        setUsername(resp.getString("username", i)); 
        setSent(resp.getString("sent", i)); 
        setMessage(resp.getString("message", i));         
    }

}
