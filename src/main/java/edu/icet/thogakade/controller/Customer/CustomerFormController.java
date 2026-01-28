package edu.icet.thogakade.controller.Customer;

import edu.icet.thogakade.controller.DashboardFormController;
import edu.icet.thogakade.model.DTO.Customer;
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

public class CustomerFormController implements Initializable {

    DashboardFormController formController = new DashboardFormController();

    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    CustomerController controller = new CustomerController();


    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvience;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    private DatePicker calDate;


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

        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, customerInfoDto, t1) -> {
            if (t1 != null) {
                txtID.setText(t1.getCustId());
                txtTitle.setText(t1.getTitle());
                txtName.setText(t1.getName());
                calDate.setValue(LocalDate.parse(t1.getDob()));
                txtSalary.setText(String.valueOf(t1.getSalary()));
                txtAddress.setText(t1.getAddress());
                txtCity.setText(t1.getCity());
                txtProvience.setText(t1.getProvince());
                txtPostalCode.setText(t1.getPostalCode());
            }

        });

    }

    private void loadCustomerDetails() {
        customerObservableList.clear();
        tblCustomer.setItems(controller.loadCustomerDetails());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        LocalDate localDate = calDate.getValue();
        controller.addCustomer(txtID.getText(), txtTitle.getText(), txtName.getText(), String.valueOf(localDate), Double.parseDouble(txtSalary.getText()), txtAddress.getText(), txtCity.getText(), txtProvience.getText(), txtPostalCode.getText());
        loadCustomerDetails();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        controller.deleteCustomer(txtID.getText());
        loadCustomerDetails();
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadCustomerDetails();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        controller.updateCustomerDetails(txtID.getText(), txtTitle.getText(), txtName.getText(), calDate.toString(), Double.parseDouble(txtSalary.getText()), txtAddress.getText(), txtCity.getText(), txtProvience.getText(), txtPostalCode.getText());
        loadCustomerDetails();
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        Customer customer = controller.getCustomer(txtID.getText());
        if(customer!= null){
            txtID.setText(customer.getCustId());
            txtTitle.setText(customer.getTitle());
            txtName.setText(customer.getName());
            calDate.setValue(LocalDate.parse(customer.getDob()));
            txtSalary.setText(String.valueOf(customer.getSalary()));
            txtAddress.setText(customer.getAddress());
            txtCity.setText(customer.getCity());
            txtProvience.setText(customer.getProvince());
            txtPostalCode.setText(customer.getPostalCode());
        }
    }

}
