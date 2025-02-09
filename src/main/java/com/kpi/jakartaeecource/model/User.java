package com.kpi.jakartaeecource.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phone;
    private int age;
    private boolean admin;
    private String pass;
}
