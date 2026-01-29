package edu.icet.thogakade.controller.OrderDetails;

import edu.icet.thogakade.model.DTO.OrderDetail;
import javafx.collections.ObservableList;

public interface OrderDetailService {

    ObservableList<OrderDetail> loadOrderDetails();
}
