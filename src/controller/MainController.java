package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Agent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    Agent userAgent;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgent;

    @FXML
    private Button btnCustomer;

    @FXML
    private ImageView exit;
    //agents view
    @FXML
    void agentOnBtnAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../application/AgentsDisplay.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 1000, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //customer view
    @FXML
    void custOnBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../application/CustomersDisplay.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2, 1200, 600));
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    void onClickExit(MouseEvent event) {
//        System.exit(0);
//    }

    @FXML
    void initialize() {
        assert btnAgent != null : "fx:id=\"btnAgent\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert btnCustomer != null : "fx:id=\"btnCustomer\" was not injected: check your FXML file 'MainDisplay.fxml'.";


        userAgent = Main.getUser();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, userAgent.getFirstName(), ButtonType.OK);
        alert.show();
    }

}//controller class end