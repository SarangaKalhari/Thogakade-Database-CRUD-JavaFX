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

        colCustId.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("CustTitle"));
        colName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, customerInfoDto, t1) -> {
            if (t1 != null) {
                txtID.setText(t1.getCustID());
                txtTitle.setText(t1.getCustTitle());
                txtName.setText(t1.getCustName());
                calDate.setValue(LocalDate.parse(t1.getDob()));
                txtSalary.setText(String.valueOf(t1.getSalary()));
                txtAddress.setText(t1.getCustAddress());
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
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        controller.deleteCustomer(txtID.getText());
        loadCustomerDetails();
        clearFields();

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadCustomerDetails();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        controller.updateCustomerDetails(txtID.getText(), txtTitle.getText(), txtName.getText(), calDate.toString(), Double.parseDouble(txtSalary.getText()), txtAddress.getText(), txtCity.getText(), txtProvience.getText(), txtPostalCode.getText());
        loadCustomerDetails();
        clearFields();
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        Customer customer = controller.getCustomer(txtID.getText());
        if(customer!= null){
            txtID.setText(customer.getCustID());
            txtTitle.setText(customer.getCustTitle());
            txtName.setText(customer.getCustName());
            calDate.setValue(LocalDate.parse(customer.getDob()));
            txtSalary.setText(String.valueOf(customer.getSalary()));
            txtAddress.setText(customer.getCustAddress());
            txtCity.setText(customer.getCity());
            txtProvience.setText(customer.getProvince());
            txtPostalCode.setText(customer.getPostalCode());
        }
    }

    void clearFields(){
        txtID.clear();
        txtName.clear();
        txtCity.clear();
        txtAddress.clear();
        txtPostalCode.clear();
        txtProvience.clear();
        txtSalary.clear();
        txtTitle.clear();
        calDate.setValue(null);
    }

}
