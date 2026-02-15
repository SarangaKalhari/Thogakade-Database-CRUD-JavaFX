package edu.icet.thogakade.controller.OrderDetails;

import edu.icet.thogakade.model.DTO.OrderDetail;
import javafx.collections.ObservableList;

public interface OrderDetailService {

    ObservableList<OrderDetail> loadOrderDetails();

    void addOrderDetail(String code, String itemCode, int qty, double discount);

    OrderDetail viewOrederDetail(String orderId);

    void deleteOrderDetails(String text);

    void updateOrderDetails(double discount, int qty, String id);
}
