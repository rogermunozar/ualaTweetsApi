package com.tweets.api.follow.infrastructure;

import com.tweets.api.follow.domain.Follow;

public interface IFollowMapper{
    public Follow toDomain(FollowModel model);
    public FollowModel toModel(Follow domain);    
}
