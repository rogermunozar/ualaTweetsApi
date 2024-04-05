package com.tweets.api.timeline.domain;

import com.tweets.api.follow.domain.Follow;
import com.tweets.api.tweet.domain.Tweet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Timeline {
	private String username;    
    private String followed;    
    private String sent;
    private String message;

    public Timeline(Tweet tweet, Follow follow){        
        setUsername(follow.getUsername());
        setFollowed(follow.getFollowed());
        setSent(tweet.getSent());
        setMessage(tweet.getMessage());
    }

}
