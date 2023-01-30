package ru.javarush.quest.kolontsov.repository;

import ru.javarush.quest.kolontsov.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private static final Repo instance = new Repo();

    private List<User> users;

    public static Repo getInstance() {
        return instance;
    }

    private Repo() {
        users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }
}
