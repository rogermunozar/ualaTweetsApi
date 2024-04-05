package com.tweets.api.timeline.infrastructure;

import com.tweets.api.timeline.domain.Timeline;

public interface ITimelineMapper{
    public Timeline toDomain(TimelineModel model);
    public TimelineModel toModel(Timeline domain);
}
