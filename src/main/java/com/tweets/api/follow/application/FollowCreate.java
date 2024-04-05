package com.tweets.api.follow.application;

import com.tweets.api.follow.domain.Follow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowCreate {
	private String username;
    private String followed;

    public Follow toDomain(){
        return new Follow(
            this.getUsername(),
            this.getFollowed(),
            null
        );
    }
}
