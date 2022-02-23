package com.livevox.phonebook.infraestructure.controller;

import com.livevox.phonebook.application.CreateUser;
import com.livevox.phonebook.domain.User;
import com.livevox.phonebook.infraestructure.controller.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class CreateUserController {

    private final CreateUser createUser;

    @PostMapping
    public ResponseEntity<Void> create(@NotNull @Valid @RequestBody UserDto userDto) {
        var user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .build();
        createUser.create(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
