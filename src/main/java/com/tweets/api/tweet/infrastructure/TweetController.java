package com.tweets.api.tweet.infrastructure;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweets.api.timeline.domain.ITweetService;
import com.tweets.api.tweet.application.TweetCreate;
import com.tweets.api.tweet.domain.Tweet;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/v1/tweet")
public class TweetController {
    
    @Autowired
    private ITweetService service;

    @Operation(summary = "Allow send a tweet",
        description="It 'll be sent to all followed")
    @PostMapping
    public ResponseEntity<?>  add(@RequestBody TweetCreate tweet0) {        
        String response = service.send(new Tweet(tweet0));
        if(response.equals("201")){
            return new ResponseEntity<String>("Ok", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}   
