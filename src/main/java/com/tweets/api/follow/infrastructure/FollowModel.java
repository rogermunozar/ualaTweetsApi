package com.tweets.api.follow.infrastructure;

import com.tweets.api.infrastructure.ES.SqlResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowModel {
    private String username;
    private String followed;
    private String since;

    public FollowModel(SqlResponse resp, int i){        
        setUsername(resp.getString("username", i)); 
        setFollowed(resp.getString("followed", i)); 
        setSince(resp.getString("since", i)); 
    }

}
