package com.tweets.api.user.domain;

import java.util.List;

public interface IUserService {

    public String addUser(User user);

    public List<User> getAllUsers();

    public User getUser(String username);

}
