package edu.icet.thogakade.controller.Order;

import edu.icet.thogakade.controller.DashboardFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OrderController {

    DashboardFormController formController = new DashboardFormController();

    @FXML
    private DatePicker calDate;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtOrderID;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

    @FXML
    void customerOnAction(ActionEvent event) throws IOException {
        formController.customerOnAction(event);
    }

    @FXML
    void itemOnAction(ActionEvent event) throws IOException {
        formController.itemOnAction(event);

    }

    @FXML
    void orderDetailOnAction(ActionEvent event) throws IOException {
        formController.orderDetailOnAction(event);

    }

    @FXML
    void orderOnAction(ActionEvent event) throws IOException {
        formController.orderOnAction(event);

    }

}
