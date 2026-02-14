package edu.icet.thogakade.controller.OrderDetails;

import edu.icet.thogakade.controller.DashboardFormController;
import edu.icet.thogakade.model.DTO.OrderDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailFormController implements Initializable {

    DashboardFormController formController = new DashboardFormController();
    OrderDetailController controller = new OrderDetailController();
    ObservableList<OrderDetail> detailObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private TableView<OrderDetail> tblOrderDetails;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TextField txtOrderQTY;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        controller.addOrderDetail(txtOrderID.getText(), txtItemCode.getText(), Integer.parseInt(txtOrderQTY.getText()), Double.parseDouble(txtDiscount.getText()));
        loadOrderDetail();
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        controller.deleteOrderDetails(txtOrderID.getText());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    OrderDetail btnViewOnAction(ActionEvent event) {
        return controller.viewOrederDetail(txtOrderID.getText());
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
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("OrderQTY"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));

        loadOrderDetail();

        tblOrderDetails.getSelectionModel().selectedItemProperty().addListener((observableValue, OrderDetail, t1) -> {
            txtOrderID.setText(t1.getOrderID());
            txtItemCode.setText(t1.getItemCode());
            txtOrderQTY.setText(String.valueOf(t1.getOrderQTY()));
            txtDiscount.setText(String.valueOf(t1.getDiscount()));
        });
    }

    private void loadOrderDetail() {
        detailObservableList.clear();
        tblOrderDetails.setItems(controller.loadOrderDetails());
    }

    private void clearFields(){
        txtOrderID.clear();
        txtItemCode.clear();
        txtDiscount.clear();
        txtOrderQTY.clear();
    }

}
