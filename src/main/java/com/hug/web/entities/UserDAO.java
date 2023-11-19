package com.hug.web.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hug.web.database.Connector;

public class UserDAO {

    public static User addNewUser(String firstName, String lastName, String cpf, String phone, String email, String password) {
        User user = null;
        String query = "INSERT INTO User (firstname, lastname, cpf, phone, email, password) VALUES (?, ?, ?, ?, ?, ?);";

        try (
            Connection connection = Connector.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, cpf);
            statement.setString(4, phone);
            statement.setString(5, email);
            statement.setString(6, password);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                user = new User(result.getInt(1), firstName, lastName, cpf, phone, email, password);
            }

            result.close();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // public static List<User> showAll() {
    //     String query = "SELECT * FROM user;";
    //     List<User>  users = new ArrayList<>();

    //     try (
    //         Connection connection = Connector.getConnection(); 
    //         Statement statement = connection.createStatement();
    //         ResultSet result = statement.executeQuery(query);
    //     ) {
    //         while (result.next()) {
    //             users.add(
    //                 new User(result.getString("firstname"), result.getString("lastname"), result.getString("cpf"), result.getDate("borndate"), result.getString("email"), result.getString("password"))
    //             );
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return users;
    //     }
    //     return users;
    // }

    // public static User findByCPF(String cpf) {
    //     for (User user : users) {
    //         if (user.getCpf().equals(cpf)) {
    //             return user;
    //         }
    //     }
    //     return null;
    // }

    // public static User findByEmail(String email) {
    //     for (User user : users) {
    //         if (user.getEmail().equals(email)) {
    //             return user;
    //         }
    //     }
    //     return null;
    // }

    // public static Boolean doLogin(String email, String password) {
    //     for (User user : users) {
    //         if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public static Boolean emailAlreadyExists(String email) {
    //     for (User user : users) {
    //         if (user.getEmail().equals(email)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
