package com.baduwal.ecommerce.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String email;
}
