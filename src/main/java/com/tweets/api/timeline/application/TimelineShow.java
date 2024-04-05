package com.tweets.api.timeline.application;

import com.tweets.api.timeline.domain.Timeline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimelineShow {
    private String followed;    
    private String sent;
    private String message;

    public TimelineShow(Timeline timeline){
        setFollowed(timeline.getFollowed());
        setSent(timeline.getSent());
        setMessage(timeline.getMessage());
    }

}
