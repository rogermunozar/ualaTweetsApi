package com.tweets.api.follow.domain;

import java.util.List;

public interface IFollowService {

    public String addFollow(Follow follow);

    public List<Follow> getFollows(String username);

}
