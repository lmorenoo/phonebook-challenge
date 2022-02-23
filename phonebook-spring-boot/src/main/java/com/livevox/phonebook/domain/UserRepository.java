package com.livevox.phonebook.domain;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    List<User> findBySearchValue(String value);
}
