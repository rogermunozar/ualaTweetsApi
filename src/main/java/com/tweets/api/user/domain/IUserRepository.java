package com.tweets.api.user.domain;

import java.util.List;

public interface IUserRepository {

    public User getUser(String username) ;
    public Boolean exists(String username) ;
    public List<User> getAllUsers();
    public String addUser(User user);

}
