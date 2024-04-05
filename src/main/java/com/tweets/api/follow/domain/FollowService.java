package com.tweets.api.follow.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweets.api.user.domain.IUserRepository;
import com.tweets.api.user.domain.User;
import com.tweets.api.util.DateTime;

@Service
public class FollowService implements IFollowService{
    @Autowired
    private IFollowRepository repository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public String addFollow(Follow follow) {
        if(!follow.getUsername().isEmpty() && !follow.getFollowed().isEmpty()){                       
            follow.setSince(DateTime.now());
            User user = userRepository.getUser(follow.getUsername());
            if(user == null){
                return "404";
            }else{                    
                repository.addFollow(follow);
                return "201";
            }            
        }else{
            return "401";
        }    
    }

    @Override
    public List<Follow> getFollows(String username) {        
        User user = userRepository.getUser(username);
        if(user == null){
            return null;
        }
        List<Follow> followList = repository.getIFollowedThem(username);        
        return followList;
    }



}
