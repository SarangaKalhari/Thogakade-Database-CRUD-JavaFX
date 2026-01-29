package edu.icet.thogakade.controller.Order;

import edu.icet.thogakade.model.DTO.Order;
import javafx.collections.ObservableList;

public interface OrderService {

    ObservableList<Order> loadOrders();
}
