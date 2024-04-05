package com.tweets.api.timeline.infrastructure;

import java.util.List;

import com.tweets.api.timeline.domain.Timeline;

public interface ITimelineRepository {
    public String add(Timeline timeline);
    public List<Timeline> getTimelines(String username);
}
