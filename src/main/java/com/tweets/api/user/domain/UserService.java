package com.tweets.api.user.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweets.api.util.DateTime;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;

    public String addUser(User user) {
        if(isValid(user)){
            user.setCreated(DateTime.now());                            
            repository.addUser(user);
            return "201";
        }else{
            return "401";
        }    
    }
    
    public List<User> getAllUsers() {        
        List<User> listUser = repository.getAllUsers();                                
        return listUser;
    }

    public User getUser(String username){
        User user = repository.getUser(username);
        return user;
    }

    private Boolean isValid(User user){
        return 
            !user.getUsername().isEmpty() && 
            !user.getFirstname().isEmpty();
    }


}
