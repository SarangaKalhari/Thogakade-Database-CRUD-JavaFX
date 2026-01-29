package edu.icet.thogakade.controller.Order;

import edu.icet.thogakade.controller.DashboardFormController;
import edu.icet.thogakade.model.DTO.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    DashboardFormController formController = new DashboardFormController();
    OrderController orderController = new OrderController();
    ObservableList<Order> orders = FXCollections.observableArrayList();


    @FXML
    private DatePicker calDate;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableView<Order> tblOrder;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtOrderID;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        orderController.addOrder(txtOrderID.getText(), calDate.getValue().toString(), txtCustID.getText());
        loadOrders();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        orderController.deleteOrder(txtOrderID.getText());
        loadOrders();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
        colCustID.setCellValueFactory(new PropertyValueFactory<>("CustID"));

        loadOrders();

        tblOrder.getSelectionModel().selectedItemProperty().addListener((observableValue, order, t1) -> {
            txtOrderID.setText(t1.getOrderID());
            calDate.setValue(LocalDate.parse(t1.getOrderDate()));
            txtCustID.setText(t1.getCustID());
        });

    }

    private void loadOrders(){
        orders.clear();
        tblOrder.setItems(orderController.loadOrders());
    }
}
