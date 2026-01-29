package edu.icet.thogakade.controller.OrderDetails;

import edu.icet.thogakade.db.DBConnection;
import edu.icet.thogakade.model.DTO.Customer;
import edu.icet.thogakade.model.DTO.OrderDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailController implements OrderDetailService{
    @Override
    public ObservableList<OrderDetail> loadOrderDetails() {
        ObservableList<OrderDetail> orderDetailArray= FXCollections.observableArrayList( );

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        resultSet.getString("OrderID"),
                        resultSet.getString("ItemCode"),
                        resultSet.getInt("OrderQTY"),
                        resultSet.getDouble("Discount")       // You can also use resultSet.getDate("dob") if DTO uses java.sql.Data
                );
                orderDetailArray.add(orderDetail);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderDetailArray;
    }

    @Override
    public void addOrderDetail(String code, String itemCode, int qty, double discount) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO orderdetail VALUES (?, ?, ?, ?)");
            ps.setObject(1, code);
            ps.setObject(2, itemCode);
            ps.setObject(3, qty);
            ps.setObject(4, discount);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
