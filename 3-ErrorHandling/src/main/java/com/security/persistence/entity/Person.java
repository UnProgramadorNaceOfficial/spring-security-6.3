package com.security.persistence.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(as = Person.class)
public class Person {

    private Long id;
    private String name;
    private String lastName;
    private Double balance;
}
