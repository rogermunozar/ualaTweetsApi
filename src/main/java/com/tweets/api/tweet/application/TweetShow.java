package com.tweets.api.tweet.application;

import com.tweets.api.tweet.domain.Tweet;

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
public class TweetShow {
    @NotBlank
    private String sent;    
    @NotBlank
    @Size(min = 1, max = 280)
    private String message;
    
    public TweetShow(Tweet tweet){
        this.setSent(tweet.getSent());
        this.setMessage(tweet.getMessage());        

    }
}
