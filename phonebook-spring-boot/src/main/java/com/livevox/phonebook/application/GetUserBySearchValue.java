package com.livevox.phonebook.application;

import com.livevox.phonebook.domain.User;
import com.livevox.phonebook.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetUserBySearchValue {

    private final UserRepository userRepository;

    public List<User> get(String searchValue) {
        if (StringUtils.hasText(searchValue)) {
            return userRepository.findBySearchValue(searchValue);
        }
        return userRepository.findAll();
    }

}
