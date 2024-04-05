package com.tweets.api.tweet.infrastructure;

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
import com.tweets.api.tweet.domain.ITweetRepository;
import com.tweets.api.tweet.domain.Tweet;

import reactor.core.publisher.Mono;

@Repository
public class TweetESRepository extends ESRepository implements ITweetRepository {

    protected String tweetDoc = base.concat("tweet/_doc/");
    protected String tweetSource = base.concat("tweet/_source/");

    private String sqlTweet = "SELECT username, sent, message FROM tweet WHERE username = ':username' ORDER BY sent";
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(TweetESRepository.class);

    @Autowired
    TweetMapper mapper;
    
    @Override
    public List<Tweet> getTweets(String username) {
        String uri = sqlCall;         
        String sql = sqlTweet.replaceAll(":username", username);
        SqlQuery query = new SqlQuery(sql);        
        SqlResponse response  = getMany(uri, query);
        //
        List<Tweet> tweetList= new ArrayList<>();
        for(int i=0; i< response.getRows().length; i++){                
            tweetList.add(mapper.toDomain(new TweetModel(response,i)));
        }
        return tweetList;
    }

    @Override
    public String send(Tweet tweet) {
        String uri = tweetDoc;         
        //
        TweetModel tweetModel = mapper.toModel(tweet);
        String response = WebClient.create(uri)
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(tweetModel),TweetModel.class)
            .retrieve()
            .bodyToMono(String.class).block();
        return response;
    }

}
