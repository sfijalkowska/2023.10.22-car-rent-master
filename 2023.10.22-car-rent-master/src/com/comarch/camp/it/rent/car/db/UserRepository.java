package com.comarch.camp.it.rent.car.db;

import com.comarch.camp.it.rent.car.model.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> users = new HashMap<>();

    public UserRepository() {
        this.users.put("admin", new User("admin",
                "d7df75a7310ab5cefaabd61266c7b028", "ADMIN"));
        this.users.put("janusz", new User("janusz",
                "7ffa31a869e122c0aff17af274c55cfb", "USER"));
        this.users.put("mateusz", new User("mateusz",
                "a5530b291d856416c2f0699c78b80f35", "USER"));
    }

    public User findByLogin(String login) {
        return this.users.get(login);
    }
}
