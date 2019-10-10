package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

}// class end
