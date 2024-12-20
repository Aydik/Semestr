package ru.itis.inf301.semestr.repository;
import ru.itis.inf301.semestr.model.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaRepository {
    private final DBConnection db = DBConnection.getInstance();

    public Pizza findById(Long id) {
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from pizza where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return new Pizza(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("composition"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("price"),
                        resultSet.getString("photo")
                );
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Pizza> findAll() {
        List<Pizza> pizzas = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from pizza");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Pizza pizza = new Pizza(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("composition"),
                        resultSet.getInt("weight"),
                        resultSet.getInt("price"),
                        resultSet.getString("photo")
                );
                pizzas.add(pizza);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizzas;
    }

    public Pizza addPizza(Pizza pizza) {

        try {
            Connection connection = db.getConnection();

            connection.setAutoCommit(false);

            Long id = null;
            PreparedStatement statement
                    = connection.prepareStatement("select nextval('pizza_seq')");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getLong("nextval");
            }
            resultSet.close();

            if (id != null) {
                statement =  connection.prepareStatement(
                        "insert into pizza (id, name, composition, weight, price, photo) values (?,?,?,?,?,?)");
                statement.setLong(1, id);
                statement.setString(2, pizza.getName());
                statement.setString(3, pizza.getComposition());
                statement.setInt(4, pizza.getWeight());
                statement.setInt(5, pizza.getPrice());
                statement.setString(6, pizza.getPhoto());
                statement.executeUpdate();

                statement.close();
                connection.commit();
                db.releaseConnection(connection);
                pizza.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizza;
    }

}