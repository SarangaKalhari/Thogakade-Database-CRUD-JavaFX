package edu.icet.thogakade.controller.Item;

import edu.icet.thogakade.db.DBConnection;
import edu.icet.thogakade.model.DTO.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController implements ItemService{

    @Override
    public void addItem(String code, String description, String category, double unitPrice, int qty) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, code);
            ps.setObject(2, description);
            ps.setObject(3, category);
            ps.setObject(4, unitPrice);
            ps.setObject(5, qty);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Item> loadItemTable() throws SQLException {
        ObservableList<Item> itemInfoArray = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                itemInfoArray.add(new Item(
                        rs.getString("itemCode"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getInt("qtyOnHand"),
                        rs.getDouble("unitPrice")
                ));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemInfoArray;
    }
}
