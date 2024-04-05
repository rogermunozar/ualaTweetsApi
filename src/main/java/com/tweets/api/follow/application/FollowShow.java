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
public class FollowShow {
    private String followed;
    private String since;

    public FollowShow(Follow follow){
        this.setFollowed(follow.getFollowed());
        this.setSince(follow.getSince());        
    }
}
