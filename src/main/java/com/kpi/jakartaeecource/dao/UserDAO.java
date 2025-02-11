package com.kpi.jakartaeecource.dao;

import com.kpi.jakartaeecource.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@ApplicationScoped
public class UserDAO {

    private final List<User> users = new ArrayList<>();

    public UserDAO() {
        users.add(new User(
                1,
                "admin",
                "admin",
                "admin",
                "email",
                "phone",
                20,
                true,
                "admin"

        ));
    }

    public User getByUserNameAndPass(String userName, String pass) {
        return users.stream().filter(m -> Objects.equals(m.getUserName(), userName) && Objects.equals(m.getPass(), pass)).findFirst().orElse(null);
    }
}