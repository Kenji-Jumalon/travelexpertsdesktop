package controller;

import application.DBHelper;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Agent;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentsController {

    DBHelper myConnection = new DBHelper();
    Agent usrAgent;

    @FXML
    private TableView<Agent> tblAgents;

    @FXML
    private TableColumn<Agent, Integer> colAgentId;

    @FXML
    private TableColumn<Agent, String> colAgtFirstName;

    @FXML
    private TableColumn<Agent, String> colAgtMiddleInitial;

    @FXML
    private TableColumn<Agent, String> colAgtLastName;

    @FXML
    private TableColumn<Agent, String> colAgtBusPhone;

    @FXML
    private TableColumn<Agent, String> colAgtEmail;

    @FXML
    private TableColumn<Agent, String> colAgtPosition;

    @FXML
    private TableColumn<Agent, Integer> colAgencyId;

    @FXML
    private TableColumn<Agent, String> colUserName;

    @FXML
    private TableColumn<Agent, String> colPassword;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblId;

    @FXML
    private Label lblFistName;

    @FXML
    private Label lblMidInitial;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblBusPhone;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPosition;

    @FXML
    private Label lblAgencyId;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblPassword;

    @FXML
    private TextField tfAgentId;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfMidInitial;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfBusPhone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPosition;

    @FXML
    private TextField tfAgencyId;

    @FXML
    private TextField tfUserName;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label usrLastName;

    @FXML
    private Label usrFirstName;

    @FXML
    private Label usrPosition;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnLogOut;

    @FXML
    void initialize() throws SQLException {
        assert tblAgents != null : "fx:id=\"tblAgents\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtFirstName != null : "fx:id=\"colAgtFirstName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtMiddleInitial != null : "fx:id=\"colAgtMiddleInitial\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtLastName != null : "fx:id=\"collAgtLastName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtBusPhone != null : "fx:id=\"colAgtBusPhone\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtEmail != null : "fx:id=\"colAgtEmail\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgtPosition != null : "fx:id=\"colAgtPosition\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert colAgencyId != null : "fx:id=\"colAgencyId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblId != null : "fx:id=\"lblId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblFistName != null : "fx:id=\"lblFistName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblMidInitial != null : "fx:id=\"lblMidInitial\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblLastName != null : "fx:id=\"lblLastName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblBusPhone != null : "fx:id=\"lblBusPhone\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblPosition != null : "fx:id=\"lblPosition\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblAgencyId != null : "fx:id=\"lblAgencyId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblUserName != null : "fx:id=\"lblUserName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfMidInitial != null : "fx:id=\"tfMidInitial\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfBusPhone != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfPosition != null : "fx:id=\"tfPosition\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfUserName != null : "fx:id=\"tfUserName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert tfPassword != null : "fx:id=\"tfPassword\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert usrFirstName != null : "fx:id=\"usrFirstName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert usrLastName != null : "fx:id=\"usrLastName\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert usrPosition != null : "fx:id=\"usrPosition\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'AgentsDisplay.fxml'.";

        usrAgent = Main.getUser();

        usrFirstName.setText(usrAgent.getFirstName());
        usrLastName.setText(usrAgent.getLastName());
        usrPosition.setText(usrAgent.getPosition());


        this.lblId.setVisible(false);
        this.lblFistName.setVisible(false);
        this.lblMidInitial.setVisible(false);
        this.lblLastName.setVisible(false);
        this.lblBusPhone.setVisible(false);
        this.lblEmail.setVisible(false);
        this.lblPosition.setVisible(false);
        this.lblAgencyId.setVisible(false);
        this.lblUserName.setVisible(false);
        this.lblPassword.setVisible(false);

        this.tfAgentId.setVisible(false);
        this.tfFirstName.setVisible(false);
        this.tfMidInitial.setVisible(false);
        this.tfLastName.setVisible(false);
        this.tfBusPhone.setVisible(false);
        this.tfEmail.setVisible(false);
        this.tfPosition.setVisible(false);
        this.tfAgencyId.setVisible(false);
        this.tfUserName.setVisible(false);
        this.tfPassword.setVisible(false);

//        this.tfAgentId.setDisable(true);
//        this.tfFirstName.setDisable(true);
//        this.tfMidInitial.setDisable(true);
//        this.tfLastName.setDisable(true);
//        this.tfBusPhone.setDisable(true);
//        this.tfEmail.setDisable(true);
//        this.tfPosition.setDisable(true);
//        this.tfAgencyId.setDisable(true);
//        this.tfUserName.setDisable(true);
//        this.tfPassword.setDisable(true);

//        ObservableList<Agent> agents = FXCollections.observableArrayList();
        colAgentId.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("agentId"));
        colAgtFirstName.setCellValueFactory(new PropertyValueFactory<Agent, String>("firstName"));
        colAgtMiddleInitial.setCellValueFactory(new PropertyValueFactory<Agent, String>("midInitial"));
        colAgtLastName.setCellValueFactory(new PropertyValueFactory<Agent, String>("lastName"));
        colAgtBusPhone.setCellValueFactory(new PropertyValueFactory<Agent, String>("phone"));
        colAgtEmail.setCellValueFactory(new PropertyValueFactory<Agent, String>("email"));
        colAgtPosition.setCellValueFactory(new PropertyValueFactory<Agent, String>("position"));
        colAgencyId.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("agencyId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<Agent, String>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Agent, String>("password"));

        Connection conn = myConnection.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from agents");
        ArrayList<Agent> agentsArrayList = new ArrayList<>();
        while(rs.next())
        {
            agentsArrayList.add(new Agent(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getInt(8), rs.getString(9),rs.getString(10)));
        }
        ObservableList<Agent> agents = FXCollections.observableArrayList(agentsArrayList);
        tblAgents.setItems(agents);
        conn.close();
    }// initialize end

    @FXML
    void onAgentSelect(MouseEvent event) {
    Agent agent=tblAgents.getSelectionModel().getSelectedItem();
    tfAgentId.setText(Integer.toString(agent.getAgentId()));
    tfFirstName.setText(agent.getFirstName());
    tfMidInitial.setText(agent.getMidInitial());
    tfLastName.setText(agent.getLastName());
    tfBusPhone.setText(agent.getPhone());
    tfEmail.setText(agent.getEmail());
    tfPosition.setText(agent.getPosition());
    tfAgencyId.setText(Integer.toString(agent.getAgencyId()));
    tfUserName.setText(agent.getUserName());
    tfPassword.setText(agent.getPassword());
    }

    @FXML
    void onActionEdit(ActionEvent event) {
        this.lblId.setVisible(true);
        this.lblFistName.setVisible(true);
        this.lblMidInitial.setVisible(true);
        this.lblLastName.setVisible(true);
        this.lblBusPhone.setVisible(true);
        this.lblEmail.setVisible(true);
        this.lblPosition.setVisible(true);
        this.lblAgencyId.setVisible(true);
        this.lblUserName.setVisible(true);
        this.lblPassword.setVisible(true);

        this.tfAgentId.setVisible(true);
        this.tfFirstName.setVisible(true);
        this.tfMidInitial.setVisible(true);
        this.tfLastName.setVisible(true);
        this.tfBusPhone.setVisible(true);
        this.tfEmail.setVisible(true);
        this.tfPosition.setVisible(true);
        this.tfAgencyId.setVisible(true);
        this.tfUserName.setVisible(true);
        this.tfPassword.setVisible(true);

        this.tfAgentId.setDisable(false);
        this.tfFirstName.setDisable(false);
        this.tfMidInitial.setDisable(false);
        this.tfLastName.setDisable(false);
        this.tfBusPhone.setDisable(false);
        this.tfEmail.setDisable(false);
        this.tfPosition.setDisable(false);
        this.tfAgencyId.setDisable(false);
        this.tfUserName.setDisable(true);
        this.tfPassword.setDisable(true);
    }

    @FXML
    void onActionSave(ActionEvent event) throws SQLException {
        Connection conn = myConnection.createConnection();
        String sql = "update agents set agentid=?, agtfirstname=?, agtmiddleinitial=?, agtlastname=?, agtbusphone=?, agtemail=?," +
                " agtposition=?, agencyid=?, username=?, password=? where agentid='"+tfAgentId.getText()+"' ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1,tfAgentId.getText());
        stmt.setString(2, tfFirstName.getText());
        stmt.setString(3, tfMidInitial.getText());
        stmt.setString(4, tfLastName.getText());
        stmt.setString(5, tfBusPhone.getText());
        stmt.setString(6, tfEmail.getText());
        stmt.setString(7, tfPosition.getText());
        stmt.setString(8, tfAgencyId.getText());
        stmt.setString(9, tfUserName.getText());
        stmt.setString(10, tfPassword.getText());

//        int data = stmt.executeUpdate();
        stmt.executeUpdate();
        stmt.close();
    }

    @FXML
    void onActionLogOut(ActionEvent event) {
        Main.stg.show();
        MainController.astage.close();
        MainController.cstage.close();
        LoginController.mstage.close();
    }

}// class end
