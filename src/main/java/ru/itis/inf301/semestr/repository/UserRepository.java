package ru.itis.inf301.semestr.repository;

import ru.itis.inf301.semestr.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final DBConnection db = DBConnection.getInstance();

    public User findByName(String name) {
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from users where user_name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password")
                );
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from users ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password")
                );
                users.add(user);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void addUser(User user) {

        try {
            Connection connection = db.getConnection();

            connection.setAutoCommit(false);


            PreparedStatement statement = connection.prepareStatement(
                    "insert into users (phone_number, user_name, password) values (?, ?, ?)");
            statement.setString(1, user.getPhone());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();

            statement.close();
            connection.commit();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}