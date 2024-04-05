package com.tweets.api.timeline.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweets.api.infrastructure.ES.ESRepository;
import com.tweets.api.infrastructure.ES.SqlQuery;
import com.tweets.api.infrastructure.ES.SqlResponse;
import com.tweets.api.timeline.domain.Timeline;

import reactor.core.publisher.Mono;

@Repository
public class TimelineESRepository extends ESRepository implements ITimelineRepository {

    private String timelineDoc = base.concat("timeline/_doc/");
    private String timelineSource = base.concat("timeline/_source/");

    private String sqlTL = "SELECT username, followed, sent, message FROM timeline WHERE username = ':username' ORDER BY sent";
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(TimelineESRepository.class);

    @Autowired
    private ITimelineMapper mapper;


    @Override
    public List<Timeline> getTimelines(String username) {
        String uri = sqlCall;         
        String sql = sqlTL.replaceAll(":username", username);
        SqlQuery query = new SqlQuery(sql);        
        SqlResponse response  = getMany(uri, query);
        //
        List<Timeline> timelines = new ArrayList<>();
        for(int i=0; i< response.getRows().length; i++){
            timelines.add(mapper.toDomain(new TimelineModel(response,i)));
        }
        return timelines;
    }

    @Override
    public String add(Timeline timeline) {
        String uri = timelineDoc; 
        TimelineModel timelineModel = mapper.toModel(timeline);
        String response = WebClient.create(uri)
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(timelineModel),TimelineModel.class)
            .retrieve()
            .bodyToMono(String.class).block();
        return response;

    }






}
