package edu.icet.thogakade.controller.Order;

import edu.icet.thogakade.db.DBConnection;
import edu.icet.thogakade.model.DTO.Customer;
import edu.icet.thogakade.model.DTO.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderService {
    @Override
    public ObservableList<Order> loadOrders() {

        ObservableList<Order> orders = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getString("OrderID"),
                        resultSet.getString("OrderDate"),
                        resultSet.getString("CustID")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    @Override
    public void addOrder(String orderID, String date, String custID) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO orders VALUES (?, ?, ?)");

            statement.setObject(1, orderID);
            statement.setObject(2,date);
            statement.setObject(3, custID);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrder(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE OrderID=?");

            statement.setObject(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order getOrder(String id) {
        for (Order order: loadOrders()){
            if (id.equals(order.getOrderID())){
                return order;
            }
        }
        return null;
    }
}
