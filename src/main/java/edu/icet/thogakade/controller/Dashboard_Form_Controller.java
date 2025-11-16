package edu.icet.thogakade.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard_Form_Controller {

    Stage stage = new Stage();

    public void customerOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer.fxml"))));
            stage.setTitle("ThogaKade");

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.show();
    }

    public void itemOnAction(ActionEvent actionEvent) {

    }

    public void supplierOnAction(ActionEvent actionEvent) {
    }

    public void employeeOnAction(ActionEvent actionEvent) {
    }
}
