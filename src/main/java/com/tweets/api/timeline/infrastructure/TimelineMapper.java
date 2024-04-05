package com.tweets.api.timeline.infrastructure;

import org.springframework.stereotype.Component;

import com.tweets.api.timeline.domain.Timeline;

@Component
public class TimelineMapper implements ITimelineMapper {

    @Override
    public Timeline toDomain(TimelineModel model) {
        Timeline domain = new Timeline();
        domain.setUsername(model.getUsername());
        domain.setFollowed(model.getFollowed());
        domain.setMessage(model.getMessage());    
        domain.setSent(model.getSent());
        return domain;
    }

    @Override
    public TimelineModel toModel(Timeline domain) {
        TimelineModel model = new TimelineModel();
        model.setUsername(domain.getUsername());
        model.setFollowed(domain.getFollowed());
        model.setMessage(domain.getMessage());    
        model.setSent(domain.getSent());
        
        return model;
        
    }

}
