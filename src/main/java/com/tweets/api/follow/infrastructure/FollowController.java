package com.tweets.api.follow.infrastructure;

import org.springframework.web.bind.annotation.RestController;

import com.tweets.api.follow.application.FollowCreate;
import com.tweets.api.follow.domain.Follow;
import com.tweets.api.follow.domain.IFollowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/v1/follow")
public class FollowController {
    
    @Autowired
    private IFollowService service;

    @Operation(summary = "Allow add a new followed user ")
    @PostMapping
    public ResponseEntity<?>  add(@RequestBody FollowCreate followCreate) {        
        Follow follow = followCreate.toDomain();
        String response = service.addFollow(follow);
        if(response.equals("201")){
            return new ResponseEntity<String>("201", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("400", HttpStatus.BAD_REQUEST);
        }
    }

}   
