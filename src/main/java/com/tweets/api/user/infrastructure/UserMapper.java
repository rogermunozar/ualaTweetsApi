package com.tweets.api.user.infrastructure;

import org.springframework.stereotype.Component;

import com.tweets.api.user.domain.User;

@Component
public class UserMapper implements IUserMapper {

    @Override
    public User toDomain(UserModel model) {
        User domain = new User();
        domain.setUsername(model.getUsername());
        domain.setFirstname(model.getFirstname());
        domain.setLastname(model.getLastname());
        domain.setCreated(model.getCreated());
        return domain;
    }

    @Override
    public UserModel toModel(User domain) {
        UserModel model = new UserModel();        
        model.setUsername(domain.getUsername().toLowerCase());
        model.setFirstname(domain.getFirstname().toUpperCase());
        model.setLastname(domain.getLastname().toUpperCase());
        model.setCreated(domain.getCreated());
        return model;
        
    }

}
