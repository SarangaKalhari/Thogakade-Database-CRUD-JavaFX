package edu.icet.thogakade.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    Stage stage = new Stage();

    String title = "Thogakade";

    public void customerOnAction(ActionEvent actionEvent) throws IOException {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer.fxml"))));
            stage.setTitle(title);

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();


        stage.show();
    }

    public void itemOnAction(ActionEvent actionEvent) throws IOException {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item.fxml"))));
            stage.setTitle(title);

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();


    }

    public void orderOnAction(ActionEvent actionEvent) throws IOException {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/order_management.fxml"))));
            stage.setTitle(title);

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

    }

    public void orderDetailOnAction(ActionEvent actionEvent) throws IOException {


            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/order_details.fxml"))));
            stage.setTitle(title);

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

    }
}
