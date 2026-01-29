package edu.icet.thogakade.controller.Item;

import edu.icet.thogakade.db.DBConnection;
import edu.icet.thogakade.model.DTO.Customer;
import edu.icet.thogakade.model.DTO.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.awt.SystemColor.text;

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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM item");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                itemInfoArray.add(new Item(
                        rs.getString("itemCode"),
                        rs.getString("description"),
                        rs.getString("packSize"),
                        rs.getDouble("unitPrice"),
                        rs.getInt("qtyOnHand")
                ));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemInfoArray;
    }

    @Override
    public Item getItem(String code) throws SQLException {

        for (Item item: loadItemTable()){
            if (code.equals(item.getItemCode())){
                return item;
            }
        }
        return null;
    }

    @Override
    public void deleteItem(String code) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE itemCode=?");

            statement.setObject(1, code);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItem(String code, String description, String packSize, int qty, double price) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE item SET description=?, packSize=?, unitPrice=?, qtyOnHand=? WHERE itemCode=?");

            statement.setObject(1,description);
            statement.setObject(2,packSize);
            statement.setObject(3,price);
            statement.setObject(4,qty);
            statement.setObject(5, code);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
