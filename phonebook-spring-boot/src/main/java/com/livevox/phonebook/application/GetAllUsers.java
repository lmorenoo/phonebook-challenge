package com.livevox.phonebook.application;

import com.livevox.phonebook.domain.User;
import com.livevox.phonebook.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllUsers {

    private final UserRepository userRepository;

    public List<User> get() {
        return userRepository.findAll();
    }

}
