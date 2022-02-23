package com.livevox.phonebook.application;

import com.livevox.phonebook.domain.User;
import com.livevox.phonebook.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CreateUser {

    private final UserRepository userRepository;

    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

}
