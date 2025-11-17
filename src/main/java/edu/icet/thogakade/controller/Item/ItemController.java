package edu.icet.thogakade.controller.Item;

import edu.icet.thogakade.controller.DashboardFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ItemController {

    DashboardFormController formController = new DashboardFormController();

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<?> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQTY;

    @FXML
    private TextField txtUnitPrice;

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
