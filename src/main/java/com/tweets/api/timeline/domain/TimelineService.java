package com.tweets.api.timeline.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweets.api.timeline.domain.ITimelineService;
import com.tweets.api.timeline.infrastructure.ITimelineRepository;
import com.tweets.api.user.domain.IUserRepository;
import com.tweets.api.user.domain.User;

@Service
public class TimelineService implements ITimelineService{
    @Autowired
    private ITimelineRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<Timeline> getTimeline(String username) {        
        User user = userRepository.getUser(username);
        if(user == null){
            return null;
        }        
        List<Timeline> timelineList = repository.getTimelines(username);
        return timelineList;
    }


}
