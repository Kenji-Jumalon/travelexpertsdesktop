package controller;


import application.DBHelper;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Agent;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    Agent agent;

    DBHelper myConnection = new DBHelper();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfUserName;

    @FXML
    private PasswordField pwfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    void initialize() {
        assert tfUserName != null : "fx:id=\"tfUserName\" was not injected: check your FXML file 'Login.fxml'.";
        assert pwfPassword != null : "fx:id=\"pwfPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }

//    private void login() throws SQLException {
//        Connection conn = myConnection.createConnection();
//        String sql = "select password from agents where username = '"+tfUserName+"' ";
//        PreparedStatement prepstmt = conn.prepareStatement(sql);
//        ResultSet rs = prepstmt.executeQuery();
//        ArrayList<String> logpwd = new ArrayList<>();
//        if (rs.next()){
//            logpwd.add(rs.getString(10));
//        }
//        conn.close();
//    }

    @FXML
    void onLogInAction(ActionEvent event) throws SQLException, IOException {
        try {
            String userName = tfUserName.getText();
            String pwd = pwfPassword.getText();
            String pwd_db = null;
            Connection conn = myConnection.createConnection();
            String sql = "select * from agents where username = ?";
            PreparedStatement prepstmt = conn.prepareStatement(sql);
            prepstmt.setString(1, userName);
            ResultSet rs = prepstmt.executeQuery();
            if (rs.next()) {
                pwd_db=rs.getString("PassWord");
                agent = new Agent(rs.getInt("AgentId"), rs.getString("AgtFirstName"), rs.getString("AgtMiddleInitial"),
                        rs.getString("AgtLastName"), rs.getString("AgtBusPhone"), rs.getString("AgtEmail"),
                        rs.getString("AgtPosition"), rs.getInt("AgencyId"), rs.getString("UserName"),
                        rs.getString("Password"));
                Main.setUser(agent);
            }
            conn.close();
            if(BCrypt.checkpw(pwd, pwd_db)){

    //            System.getProperty("user.name");
                Main.stg.close();// to close the login the main stage which is the Login window
                loadWindow();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong! try again or contact support", ButtonType.OK);
                alert.show();
            }
        } catch (SQLException e) {


        }

    }

    private void loadWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../application/MainDisplay.fxml"));
            Parent root3 = (Parent) fxmlLoader.load();
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(root3, 1000, 600));
            stage3.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeWindow() throws IOException {

    }
}
