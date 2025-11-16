package edu.icet.thogakade.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    Stage stage = new Stage();

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        if(txtUserName.getText().equals("thogakade")){
            if(txtPassword.getText().equals("123456")){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("ThogaKade");
                stage.show();

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

            }else {
                lblPassword.setText("Password is incorrect");
            }
        }else {
            lblUserName.setText("Username is incorrect");
        }
    }

}
