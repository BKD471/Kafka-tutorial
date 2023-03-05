package com.example.springbootkafka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
