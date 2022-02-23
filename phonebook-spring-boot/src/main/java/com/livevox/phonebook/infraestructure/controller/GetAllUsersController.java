package com.livevox.phonebook.infraestructure.controller;

import com.livevox.phonebook.application.GetAllUsers;
import com.livevox.phonebook.infraestructure.controller.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class GetAllUsersController {

    private final GetAllUsers getAllUsers;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        var users = getAllUsers.get().stream()
                .map(user -> new UserDto(user.getFirstName(), user.getLastName(), user.getPhone())).collect(Collectors.toUnmodifiableList());

        return ResponseEntity.ok(users);
    }
}
