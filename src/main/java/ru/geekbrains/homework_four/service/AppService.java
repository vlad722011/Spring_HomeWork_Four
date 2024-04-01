package ru.geekbrains.homework_four.service;


import org.springframework.stereotype.Service;
import ru.geekbrains.homework_four.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {
    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return users;
    }
}
