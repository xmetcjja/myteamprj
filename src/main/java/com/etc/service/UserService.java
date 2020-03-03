package com.etc.service;

import com.etc.entity.User;

public interface UserService extends BaseService<User> {

    public User loginquery(User user);

}
