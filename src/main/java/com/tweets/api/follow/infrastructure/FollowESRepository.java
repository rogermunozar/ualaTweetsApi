package com.tweets.api.follow.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweets.api.follow.domain.Follow;
import com.tweets.api.follow.domain.IFollowRepository;
import com.tweets.api.infrastructure.ES.ESRepository;
import com.tweets.api.infrastructure.ES.SqlQuery;
import com.tweets.api.infrastructure.ES.SqlResponse;

import reactor.core.publisher.Mono;

@Repository
public class FollowESRepository extends ESRepository implements IFollowRepository {

    protected String followDoc = base.concat("follow/_doc/");
    protected String followSource = base.concat("follow/_source/");

    private String sql_I_follow_them  = "SELECT username, followed, since FROM follow WHERE username = ':username' ORDER BY since";
    private String sql_they_follow_me = "SELECT username, followed, since FROM follow WHERE followed = ':username' ORDER BY since";
    
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(FollowESRepository.class);

    @Autowired
    private IFollowMapper mapper;

    @Override
    public List<Follow> getTheyFollowMe(String username) {
        String uri = sqlCall;         
        String sql = sql_they_follow_me.replaceAll(":username", username);
        SqlQuery query = new SqlQuery(sql);
        SqlResponse response = getMany(uri, query);
        //
        List<Follow> followList= new ArrayList<>();
        for(int i=0; i< response.getRows().length; i++){                
            followList.add(  mapper.toDomain(new FollowModel(response,i)));
        }
        return followList;
    }

    @Override
    public List<Follow> getIFollowedThem(String username) {
        String uri = sqlCall;         
        String sql = sql_I_follow_them.replaceAll(":username", username);
        SqlQuery query = new SqlQuery(sql);
        SqlResponse response = getMany(uri, query);
        //
        List<Follow> follows= new ArrayList<>();
        for(int i=0; i< response.getRows().length; i++){                
            follows.add(mapper.toDomain(new FollowModel(response,i)));
        }
        return follows;
    }

    @Override
    public String addFollow(Follow follow) {
        FollowModel followModel = mapper.toModel(follow);  
        //      
        String uri = followDoc; 
        String response = WebClient.create(uri)
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(followModel),FollowModel.class)
            .retrieve()
            .bodyToMono(String.class).block();
        return response;

    }






}
