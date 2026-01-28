package edu.icet.thogakade.controller.Item;

import edu.icet.thogakade.controller.DashboardFormController;
import edu.icet.thogakade.model.DTO.Item;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    DashboardFormController formController = new DashboardFormController();

    ItemController itemController = new ItemController();
    ObservableList<Item> itemInfoArray = FXCollections.observableArrayList();



    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colCatagory;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtCatagory;

    @FXML
    private TextField txtQTY;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException {
        itemController.addItem(txtItemCode.getText(), txtDescription.getText(), txtCatagory.getText(), Double.parseDouble(txtUnitPrice.getText()), Integer.parseInt(txtQTY.getText()));
        loadItemDetails();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        itemController.deleteItem(txtItemCode.getText());
        loadItemDetails();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        itemController.updateItem(txtItemCode.getText(), txtDescription.getText(), txtCatagory.getText(), Integer.parseInt(txtQTY.getText()), Double.parseDouble(txtUnitPrice.getText()));
        loadItemDetails();

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws SQLException {
        Item item = itemController.getItem(txtItemCode.getText());
        if(item != null){
            txtItemCode.setText(item.getItemCode());
            txtDescription.setText(item.getDescription());
            txtCatagory.setText(item.getCategory());
            txtQTY.setText(String.valueOf(item.getQtyOnHand()));
            txtUnitPrice.setText(String.valueOf(item.getUnitPrice()));
        }

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

    public void reloadOnAction(ActionEvent actionEvent) throws SQLException {
        loadItemDetails();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCatagory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        try {
            loadItemDetails();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tblItem.getSelectionModel().selectedItemProperty().addListener(((observableValue, item, t1) -> {
            txtItemCode.setText(t1.getItemCode());
            txtDescription.setText(t1.getDescription());
            txtUnitPrice.setText(String.valueOf(t1.getUnitPrice()));
            txtQTY.setText(String.valueOf(t1.getQtyOnHand()));
            txtCatagory.setText(t1.getCategory());
//            txtPackSize.setText(t1.getPackSize());
//            txtItemCode.setText(t1.getCode());
        }));

    }

    private void loadItemDetails() throws SQLException {
        itemInfoArray.clear();
        tblItem.setItems(itemController.loadItemTable());
    }
}
