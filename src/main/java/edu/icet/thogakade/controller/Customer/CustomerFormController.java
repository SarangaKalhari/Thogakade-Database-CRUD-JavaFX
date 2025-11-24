package edu.icet.thogakade.controller.Customer;

import edu.icet.thogakade.controller.DashboardFormController;
import edu.icet.thogakade.controller.db.DBConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    DashboardFormController formController = new DashboardFormController();

    ObservableList<Customer> customers = FXCollections.observableArrayList();

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

        colCustId.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();
//        tblCustomer.setItems(customers);


    }

    private void loadCustomerDetails() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customerDTO = new Customer(
                        resultSet.getString("custId"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),        // You can also use resultSet.getDate("dob") if DTO uses java.sql.Date
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );
                customers.add(customerDTO);
            }
            tblCustomer.setItems(customers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        controller.addCustomer(txtID.getText(), txtTitle.getText(), txtName.getText(), calDate.toString(), Double.parseDouble(txtSalary.getText()), txtAddress.getText(), txtCity.getText(), txtProvience.getText(), txtPostalCode.getText());
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        controller.deleteCustomer(txtID.getText());
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

}
