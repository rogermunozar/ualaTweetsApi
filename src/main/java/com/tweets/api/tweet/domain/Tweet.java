package com.tweets.api.tweet.domain;

import com.tweets.api.tweet.application.TweetCreate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
    @NotBlank
	private String username;    
    @NotBlank
    private String sent;    
    @NotBlank
    @Size(min = 1, max = 280)
    private String message;
    
    public Tweet(TweetCreate tweet0){
        this.setUsername(tweet0.getUsername());
        this.setMessage(tweet0.getMessage());        
    }
}
