package com.tweets.api.timeline.domain;

import java.util.List;

public interface ITimelineService {

    public List<Timeline> getTimeline(String username);

}
