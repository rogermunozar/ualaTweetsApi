package com.tweets.api.infrastructure.ES;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweets.api.tweet.application.TweetException;
import com.tweets.api.util.exception.NoDataFoundException;

import reactor.core.publisher.Mono;

public class ESRepository {
    
    public static String base = "http://191.101.18.138:9200/";
    protected String sqlCall = ESRepository.base.concat("_sql?format=json");    

    protected SqlResponse getMany(String uri, SqlQuery query){
        SqlResponse response = WebClient.create(uri)
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(query),SqlQuery.class)
            .retrieve()
            .onStatus(httpStatus -> httpStatus.equals(HttpStatus.NOT_FOUND),
                clientresponse -> clientresponse.bodyToMono(String.class).map(NoDataFoundException::new))
            .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                clientresponse -> clientresponse.bodyToMono(String.class).map(TweetException::new))
            .bodyToMono(SqlResponse.class).block()
            .buildHash();
        return response;
    }
}
