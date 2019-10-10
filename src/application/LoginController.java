package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pwfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    void initialize() {
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'Login.fxml'.";
        assert pwfPassword != null : "fx:id=\"pwfPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }


}
