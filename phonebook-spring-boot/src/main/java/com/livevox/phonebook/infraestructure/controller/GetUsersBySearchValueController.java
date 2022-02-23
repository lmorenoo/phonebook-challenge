package com.livevox.phonebook.infraestructure.controller;

import com.livevox.phonebook.application.GetUserBySearchValue;
import com.livevox.phonebook.infraestructure.controller.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class GetUsersBySearchValueController {

    private final GetUserBySearchValue getUserBySearchValue;

    @GetMapping(params = "searchValue")
    public ResponseEntity<List<UserDto>> getBySearchValue(@RequestParam String searchValue) {
        var users = getUserBySearchValue.get(searchValue).stream()
                .map(user -> new UserDto(user.getFirstName(), user.getLastName(), user.getPhone())).collect(Collectors.toUnmodifiableList());

        return ResponseEntity.ok(users);
    }
}
