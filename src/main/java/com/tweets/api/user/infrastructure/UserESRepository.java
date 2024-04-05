package com.tweets.api.user.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweets.api.infrastructure.ES.ESRepository;
import com.tweets.api.infrastructure.ES.SqlQuery;
import com.tweets.api.infrastructure.ES.SqlResponse;
import com.tweets.api.user.domain.IUserRepository;
import com.tweets.api.user.domain.User;
import com.tweets.api.util.exception.NoDataFoundException;

import reactor.core.publisher.Mono;

@Repository
public class UserESRepository extends ESRepository implements IUserRepository {

    protected String userDoc = base.concat("user/_doc/");
    protected String userSource = base.concat("user/_source/");    
    private String sqlUser = "SELECT username, firstname, lastname, created FROM user WHERE username IS NOT NULL AND created IS NOT NULL";
    private static Logger log = LoggerFactory.getLogger(UserESRepository.class);

    @Autowired
    private IUserMapper userMapper;

    
    @Override
    public List<User> getAllUsers() {
        String uri = sqlCall;                
        SqlQuery query = new SqlQuery(sqlUser);
        SqlResponse response = getMany(uri, query);
        //
        List<User> users= new ArrayList<User>();
        for(int i=0; i< response.getRows().length; i++){                
            users.add(   userMapper.toDomain(new UserModel(response,i) ) );
        }
        return users;
    }

    @Override
    public User getUser(String username) {
        String uri = userSource.concat(username);        
        UserModel userModel = null;
        try{
            userModel = WebClient.create(uri)
                .get()
                .retrieve()
                .onStatus(
                    HttpStatus.NOT_FOUND::equals,
                    response -> response.bodyToMono(String.class).map(NoDataFoundException::new))
                .bodyToMono(UserModel.class)
                .block();
        }catch(Exception nf) {
            return null;
        }
        return  userMapper.toDomain(userModel);
    }

    @Override
    public String addUser(User user){
        UserModel userModel= userMapper.toModel(user);
        String uri = userDoc.concat(user.getUsername());
        log.info(uri);

        String response = WebClient.create(uri)
            .post()
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(userModel),UserModel.class)
            .retrieve()
            .bodyToMono(String.class).block();
        return response;
    }

    @Override
    public Boolean exists(String username) {
        String uri = userDoc.concat(username);
        //
        ResponseEntity s =  WebClient.create(uri)
            .head()
            .retrieve()
            .toBodilessEntity().block();
        return true;
    }





}
