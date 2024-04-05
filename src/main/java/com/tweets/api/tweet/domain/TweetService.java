package com.tweets.api.tweet.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweets.api.follow.domain.Follow;
import com.tweets.api.follow.domain.IFollowRepository;
import com.tweets.api.timeline.domain.ITweetService;
import com.tweets.api.timeline.domain.Timeline;
import com.tweets.api.timeline.infrastructure.ITimelineRepository;
import com.tweets.api.user.domain.IUserRepository;
import com.tweets.api.user.domain.User;
import com.tweets.api.util.Constants;
import com.tweets.api.util.DateTime;

@Service
public class TweetService implements ITweetService{
    @Autowired
    private ITweetRepository repository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IFollowRepository followRepository;
    @Autowired
    private ITimelineRepository tlRepository;

    @Autowired
    private ITweetValidator validator;

    @Override
    public List<Tweet> getTweets(String username) {        
        User user = userRepository.getUser(username);
        if(user == null){
            return null;
        }        
        List<Tweet> tweetList = repository.getTweets(username);        
        return tweetList;
    }

    @Override
    public String send(Tweet tweet) {
        User user = userRepository.getUser(tweet.getUsername());
        if(user == null){
            return "401";
        }
        if(validator.isValid(tweet)){   
            tweet.setSent(DateTime.now());            
            repository.send(tweet);
            List<Follow> followList = followRepository.getTheyFollowMe(tweet.getUsername());
                followList.forEach( (follow)->                 
                    tlRepository.add( new Timeline(tweet,follow))
                );            
                return "201";
        }else{
            return "401";
        }    
    }


}
