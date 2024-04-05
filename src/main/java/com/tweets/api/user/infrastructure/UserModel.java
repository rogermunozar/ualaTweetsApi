package com.tweets.api.user.infrastructure;

import com.tweets.api.infrastructure.ES.SqlResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private String username;
    private String firstname;
    private String lastname;
    private String created;

    public UserModel(SqlResponse resp, int i){        
        setUsername(resp.getString("username", i)); 
        setFirstname(resp.getString("firstname", i)); 
        setLastname(resp.getString("lastname", i)); 
        setCreated(resp.getString("created", i)); 
    }

}
