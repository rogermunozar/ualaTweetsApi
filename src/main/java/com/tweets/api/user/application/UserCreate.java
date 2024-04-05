package com.tweets.api.user.application;

import com.tweets.api.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreate {
	private String username;
    private String firstname;
    private String lastname;

    public User toDomain(){
        User user = new User();
        user.setUsername(this.getUsername());
        user.setFirstname(this.getFirstname());
        user.setLastname(this.getLastname());
        return user;
    }

}
