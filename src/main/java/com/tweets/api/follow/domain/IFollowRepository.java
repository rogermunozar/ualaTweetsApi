package com.tweets.api.follow.domain;

import java.util.List;

public interface IFollowRepository {

    public List<Follow> getTheyFollowMe(String username);
    public List<Follow> getIFollowedThem(String username);
    public String addFollow(Follow follow);

}
