package com.tweets.api.user.infrastructure;

import com.tweets.api.user.domain.User;

public interface IUserMapper{
    public User toDomain(UserModel model);
    public UserModel toModel(User domain);
}
