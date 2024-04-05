package com.tweets.api.timeline.infrastructure;

import com.tweets.api.infrastructure.ES.SqlResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimelineModel {
    private String username;    
    private String followed;
    private String sent;
    private String message;
    
    public TimelineModel(SqlResponse resp, int i){        
        setUsername(resp.getString("username", i)); 
        setFollowed(resp.getString("followed", i)); 
        setSent(resp.getString("sent", i)); 
        setMessage(resp.getString("message", i));         
    }

}
