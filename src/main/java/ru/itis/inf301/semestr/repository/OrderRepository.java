package ru.itis.inf301.semestr.repository;

import ru.itis.inf301.semestr.model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final DBConnection db = DBConnection.getInstance();

    public void addOrder(List<Cart> carts, String address) {
        try {
            Connection connection = db.getConnection();
            connection.setAutoCommit(false);

            Long user_id = carts.iterator().next().getUser_id();

            List<Long> carts_new = new ArrayList<>();
            for (Cart cart : carts) {
                for (int i = 0; i < cart.getQuantity(); i++) {
                    carts_new.add(cart.getPizza().getId());
                }
            }

            Long products[] = new Long[carts_new.size()];
            for (int i = 0; i < carts_new.size(); i++) {
                products[i] = carts_new.get(i);
            }

            //создаем заказ
            PreparedStatement statement = connection.prepareStatement(
                    "insert into orders (user_id, products, address) values (?,?,?)");
            statement.setLong(1, user_id);
            statement.setArray(2, connection.createArrayOf("LONG", products));
            statement.setString(3, address);
            statement.executeUpdate();
            //чистим корзину
            statement = connection.prepareStatement(
                    "delete from cart where user_id = ?");
            statement.setLong(1, user_id);
            statement.executeUpdate();

            statement.close();
            connection.commit();
            db.releaseConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
