package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgent;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnBookings;





    @FXML
    private Button btnCustomer;

    @FXML
    private ImageView exit;
/*
    public Controller(Button btnPackages, Button btnBookings) {
        this.btnPackages = btnPackages;
        this.btnBookings = btnBookings;
    }
*/
    @FXML
    void agentOnBtnAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/Agents.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 1000,1000));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void custOnBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/CustomersDisplay.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2, 1200,1200));
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void packagesOnBtnAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/Packages.fxml"));
            Parent root3 = (Parent) fxmlLoader.load();
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(root3));
            stage3.initStyle(StageStyle.UNDECORATED);
            stage3.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void BookingsOnBtnAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/Bookings.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root4));
            stage4.initStyle(StageStyle.UNDECORATED);
            stage4.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void onClickExit(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    void initialize() {
        assert btnAgent != null : "fx:id=\"btnAgent\" was not injected: check your FXML file 'main.fxml'.";
        assert btnCustomer != null : "fx:id=\"btnCustomer\" was not injected: check your FXML file 'main.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'main.fxml'.";
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'main.fxml'.";

    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

  /*  public void bookingOnBtnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/Bookings.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root4));
            stage4.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

*/


    }
//controller class end