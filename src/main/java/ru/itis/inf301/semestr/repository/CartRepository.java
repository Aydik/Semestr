package ru.itis.inf301.semestr.repository;

import ru.itis.inf301.semestr.model.Cart;
import ru.itis.inf301.semestr.model.Pizza;
import ru.itis.inf301.semestr.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private final DBConnection db = DBConnection.getInstance();

    public List<Cart> findByUser(Long user_id) {
        try (Connection connection = db.getConnection()) {
            List<Cart> carts = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(
                    "select * from cart join pizza on pizza.id=cart.pizza_id where user_id = ? order by pizza_id");
            statement.setLong(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pizza pizza = new Pizza(
                        resultSet.getLong("pizza_id"),
                        resultSet.getString("name"),
                        resultSet.getString("composition"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("price"),
                        resultSet.getString("photo")
                );

                carts.add(new Cart(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        pizza,
                        resultSet.getInt("quantity")
                ));
            }
            resultSet.close();
            statement.close();

            return carts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByUser(Long user_id) {
        try (Connection connection = db.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "delete from cart where user_id = ?");
            statement.setLong(1, user_id);
            statement.executeUpdate();
            statement.close();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getQuantity(Long user_id, Long pizza_id) {
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from cart where user_id = ? and pizza_id = ? ");
            statement.setLong(1, user_id);
            statement.setLong(2, pizza_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt("quantity");
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void deleteByUserAndPizza(Long user_id, Long pizza_id) {
        try (Connection connection = db.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(
                    "delete from cart where user_id = ? and pizza_id = ?");
            statement.setLong(1, user_id);
            statement.setLong(2, pizza_id);
            statement.executeUpdate();
            statement.close();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateQuantity(Long user_id, Long pizza_id, int quantity) {
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update cart set quantity = ? where user_id = ? and pizza_id = ?");
            statement.setLong(1, quantity);
            statement.setLong(2, user_id);
            statement.setLong(3, pizza_id);
            statement.executeUpdate();
            statement.close();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addCart(Long user_id, Long pizza_id) {

        try (Connection connection = db.getConnection()){

            PreparedStatement statement = connection.prepareStatement(
                    "insert into cart (user_id, pizza_id, quantity) values (?, ?, ?)");
            statement.setLong(1, user_id);
            statement.setLong(2, pizza_id);
            statement.setInt(3, 1);
            statement.executeUpdate();
            statement.close();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}