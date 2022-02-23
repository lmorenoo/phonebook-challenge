package com.livevox.phonebook.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {

    String firstName;

    String lastName;

    String phone;
}
