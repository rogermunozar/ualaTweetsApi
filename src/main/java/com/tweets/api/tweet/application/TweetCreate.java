package com.tweets.api.tweet.application;

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
public class TweetCreate {
    @NotBlank
	private String username;    
    @NotBlank
    @Size(min = 1, max = 280)
    private String message;
}
