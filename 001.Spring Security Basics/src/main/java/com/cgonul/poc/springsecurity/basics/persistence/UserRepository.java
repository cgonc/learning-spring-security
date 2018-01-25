package com.cgonul.poc.springsecurity.basics.persistence;

import com.cgonul.poc.springsecurity.basics.web.model.User;

public interface UserRepository {

    Iterable<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);

}
