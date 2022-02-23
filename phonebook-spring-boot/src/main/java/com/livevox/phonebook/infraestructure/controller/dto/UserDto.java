package com.livevox.phonebook.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@NotNull
public class UserDto {

    @NotEmpty
    @NotNull
    String firstName;

    @NotEmpty
    @NotNull
    String lastName;

    @NotEmpty
    @NotNull
    String phone;
}
