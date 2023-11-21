package com.hug.web.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.hug.web.database.Connector;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;


public class UserDAO {

    public static User addNewUser(String firstName, String lastName, String cpf, Date bornDate, String phone, String email, String password, Boolean isOrganizer) {
        User user = null;
        String hashPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        String query = "INSERT INTO User (FirstName, LastName, CPF, BornDate, Phone, Email, Password, IsOrganizer) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (
            Connection connection = Connector.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, cpf);
            statement.setDate(4, bornDate);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, hashPassword);
            statement.setBoolean(8, isOrganizer);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                user = new User(result.getInt(1), firstName, lastName, cpf, bornDate, phone, email, hashPassword, isOrganizer);
            }

            result.close();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> showAll() {
        String query = "SELECT * FROM User;";
        List<User>  users = new ArrayList<>();

        try (
            Connection connection = Connector.getConnection(); 
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
        ) {
            while (result.next()) {
                users.add(
                    new User(result.getInt("Id"),
                    result.getString("FirstName"), 
                    result.getString("LastName"), 
                    result.getString("CPF"), 
                    result.getDate("BornDate"), 
                    result.getString("Phone"),
                    result.getString("Email"), 
                    result.getString("Password"), 
                    result.getBoolean("IsOrganizer"))
                );
            }
            result.close();

        } catch (Exception e) {
            e.printStackTrace();
            return users;
        }
        return users;
    }

    public static User findByCPF(String cpf) {
        String query = "SELECT * FROM User WHERE CPF = ?;";

        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, cpf);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return new User(result.getInt("Id"),
                    result.getString("FirstName"), 
                    result.getString("LastName"), 
                    result.getString("CPF"), 
                    result.getDate("BornDate"), 
                    result.getString("Phone"),
                    result.getString("Email"), 
                    result.getString("Password"), 
                    result.getBoolean("IsOrganizer")
                );
            }

            result.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static User findByEmail(String email) {
        String query = "SELECT * FROM User WHERE Email = ?;";

        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return new User(result.getInt("Id"),
                    result.getString("FirstName"), 
                    result.getString("LastName"), 
                    result.getString("CPF"), 
                    result.getDate("BornDate"), 
                    result.getString("Phone"),
                    result.getString("Email"), 
                    result.getString("Password"), 
                    result.getBoolean("IsOrganizer")
                );
            }

            result.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public static Integer getUserIdByEmail(String email) {
        String query = "SELECT Id FROM User WHERE Email = ?;";
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                return result.getInt("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNameById(Integer id) {
        String query = "SELECT FirstName, LastName FROM User WHERE Id = ?;";
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            String userName = "";

            if (result.next()) {
                userName = result.getString("FirstName") + " " + result.getString("LastName");
                return userName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static LocalDate getBornDateByEmail(String email) {
        String query = "SELECT BornDate FROM User WHERE Email = ?;";
        LocalDate castedBornDate = null; 
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                Date bornDate =  result.getDate("BornDate");
                castedBornDate = bornDate.toLocalDate();
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return castedBornDate;
    }

    public static Integer calculateAgeByEmail(String email) {
        LocalDate bornDate = getBornDateByEmail(email);
        if (bornDate != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(bornDate, currentDate).getYears();
        }else {
            return -1;
        }
    }

    public static Boolean doLogin(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            return result.verified;
        }
        return false;
    }

    public static Boolean emailAlreadyExists(String email) {
        return findByEmail(email) != null;
    }

    public static Boolean CPFAlreadyExists(String cpf) {
        return findByCPF(cpf) != null;
    }
}
