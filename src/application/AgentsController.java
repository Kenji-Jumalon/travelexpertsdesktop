package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Agent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentsController {

    DBHelper myConnection = new DBHelper();

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
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    void initialize() throws SQLException {
        assert tblAgents != null : "fx:id=\"tblAgents\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtFirstName != null : "fx:id=\"colAgtFirstName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtMiddleInitial != null : "fx:id=\"colAgtMiddleInitial\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtLastName != null : "fx:id=\"collAgtLastName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtBusPhone != null : "fx:id=\"colAgtBusPhone\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtEmail != null : "fx:id=\"colAgtEmail\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgtPosition != null : "fx:id=\"colAgtPosition\" was not injected: check your FXML file 'Agents.fxml'.";
        assert colAgencyId != null : "fx:id=\"colAgencyId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblId != null : "fx:id=\"lblId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblFistName != null : "fx:id=\"lblFistName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblMidInitial != null : "fx:id=\"lblMidInitial\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblLastName != null : "fx:id=\"lblLastName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblBusPhone != null : "fx:id=\"lblBusPhone\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblPosition != null : "fx:id=\"lblPosition\" was not injected: check your FXML file 'Agents.fxml'.";
        assert lblAgencyId != null : "fx:id=\"lblAgencyId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfMidInitial != null : "fx:id=\"tfMidInitial\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfBusPhone != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfPosition != null : "fx:id=\"tfPosition\" was not injected: check your FXML file 'Agents.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'Agents.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'Agents.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Agents.fxml'.";



//        ObservableList<Agent> agents = FXCollections.observableArrayList();
        colAgentId.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("agentId"));
        colAgtFirstName.setCellValueFactory(new PropertyValueFactory<Agent, String>("firstName"));
        colAgtMiddleInitial.setCellValueFactory(new PropertyValueFactory<Agent, String>("midInitial"));
        colAgtLastName.setCellValueFactory(new PropertyValueFactory<Agent, String>("lastName"));
        colAgtBusPhone.setCellValueFactory(new PropertyValueFactory<Agent, String>("phone"));
        colAgtEmail.setCellValueFactory(new PropertyValueFactory<Agent, String>("email"));
        colAgtPosition.setCellValueFactory(new PropertyValueFactory<Agent, String>("position"));
        colAgencyId.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("agencyId"));

        Connection conn = myConnection.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from agents");
        ArrayList<Agent> agentsArrayList = new ArrayList<>();
        while(rs.next())
        {
            agentsArrayList.add(new Agent(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getInt(8)));
        }
        ObservableList<Agent> agents = FXCollections.observableArrayList(agentsArrayList);
        tblAgents.setItems(agents);
        conn.close();
    }

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
    }

    @FXML
    void onActionEdit(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

}// class end
