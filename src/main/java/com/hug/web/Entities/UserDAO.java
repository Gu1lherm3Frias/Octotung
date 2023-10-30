package com.hug.web.Entities;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();

    public static User addNewUser(String firstName, String lastName, String cpf, String borndate, String email, String password) {
        User user = new User(firstName, lastName, cpf, borndate, email, password);
        users.add(user);
        return user;
    }

    public static List<User> showAll() {
        return users;
    }

    public static User findByCPF(String cpf) {
        for (User user : users) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }
        return null;
    }

    public static User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public static Boolean doLogin(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean emailAlreadyExists(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
