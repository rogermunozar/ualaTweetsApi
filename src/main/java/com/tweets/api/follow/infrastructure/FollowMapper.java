package com.tweets.api.follow.infrastructure;

import org.springframework.stereotype.Component;

import com.tweets.api.follow.domain.Follow;

@Component
public class FollowMapper implements IFollowMapper {

    @Override
    public Follow toDomain(FollowModel model){    
        Follow domain = new Follow();
        domain.setUsername(model.getUsername());
        domain.setFollowed(model.getFollowed());
        domain.setSince(model.getSince());
        return domain;
    }

    @Override
    public FollowModel toModel(Follow domain){
        FollowModel model = new FollowModel();
        model.setUsername(domain.getUsername());
        model.setFollowed(domain.getFollowed());
        model.setSince(domain.getSince());
        return model;
        
    }

}
