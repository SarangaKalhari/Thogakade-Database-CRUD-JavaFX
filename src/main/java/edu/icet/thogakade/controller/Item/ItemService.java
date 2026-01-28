package edu.icet.thogakade.controller.Item;

import edu.icet.thogakade.model.DTO.Item;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ItemService {
    void addItem(String code, String description, String packSize, double unitPrice, int qty);

    ObservableList<Item> loadItemTable() throws SQLException;
}
