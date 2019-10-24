package controller;

import application.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomersController {

    DBHelper myConnection = new DBHelper();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Customer> tblCustomers;

    @FXML
    private TableColumn<Customer, Integer> colCustId;

    @FXML
    private TableColumn<Customer, String> colCustFirstName;

    @FXML
    private TableColumn<Customer, String> colCustLastName;

    @FXML
    private TableColumn<Customer, String> colAddress;

    @FXML
    private TableColumn<Customer, String> colCustCity;

    @FXML
    private TableColumn<Customer, String> colCustProv;

    @FXML
    private TableColumn<Customer, String> colCustPostal;

    @FXML
    private TableColumn<Customer, String> colCustCountry;

    @FXML
    private TableColumn<Customer, String> colCustHomePhone;

    @FXML
    private TableColumn<Customer, String> colCustBusPhone;

    @FXML
    private TableColumn<Customer, String> colCustEmail;

    @FXML
    private TableColumn<Customer, Integer> colAgentId;

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblCustFistName;

    @FXML
    private Label lblCustLastName;

    @FXML
    private Label lblCustAddress;

    @FXML
    private Label lblCustCity;

    @FXML
    private Label lblCustProvince;

    @FXML
    private Label lblCustPostal;

    @FXML
    private Label lblCustCountry;

    @FXML
    private Label lblCustHomePhone;

    @FXML
    private Label lblCustBusPhone;

    @FXML
    private Label lblCustEmail;

    @FXML
    private Label lblCustAgentId;


    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustProvince;

    @FXML
    private TextField tfCustPostal;

    @FXML
    private TextField tfCustCountry;


    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustBusPhone;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustAgentId;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    void initialize() throws SQLException {
        assert tblCustomers != null : "fx:id=\"tblCustomers\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustId != null : "fx:id=\"colCustId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustFirstName != null : "fx:id=\"colCustFirstName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustLastName != null : "fx:id=\"colCustLastName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colAddress != null : "fx:id=\"colAddress\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustCity != null : "fx:id=\"colCustCity\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustCountry != null : "fx:id=\"colCustCountry\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustBusPhone != null : "fx:id=\"colCustBusPhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colCustEmail != null : "fx:id=\"colCustEmail\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustomerId != null : "fx:id=\"lblCustomerId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustFistName != null : "fx:id=\"lblCustFistName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustLastName != null : "fx:id=\"lblCustLastName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustAddress != null : "fx:id=\"lblCustAddress\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustCity != null : "fx:id=\"lblCustCity\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustProvince != null : "fx:id=\"lblCustProvince\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustPostal != null : "fx:id=\"lblCustPostal\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustCountry != null : "fx:id=\"lblCustCountry\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustHomePhone != null : "fx:id=\"lblCustHomePhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustBusPhone != null : "fx:id=\"lblCustBusPhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustEmail != null : "fx:id=\"lblCustEmail\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert lblCustAgentId != null : "fx:id=\"lblCustAgentId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfAddress\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCity\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustProvince != null : "fx:id=\"tfProvince\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfPostal\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCountry\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfHomePhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert tfCustAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'CustomersDisplay.fxml'.";

        this.lblCustomerId.setVisible(false);
        this.lblCustFistName.setVisible(false);
        this.lblCustLastName.setVisible(false);
        this.lblCustAddress.setVisible(false);
        this.lblCustCity.setVisible(false);
        this.lblCustProvince.setVisible(false);
        this.lblCustPostal.setVisible(false);
        this.lblCustCountry.setVisible(false);
        this.lblCustHomePhone.setVisible(false);
        this.lblCustBusPhone.setVisible(false);
        this.lblCustEmail.setVisible(false);
        this.lblCustAgentId.setVisible(false);

        this.tfCustomerId.setVisible(false);
        this.tfCustFirstName.setVisible(false);
        this.tfCustLastName.setVisible(false);
        this.tfCustAddress.setVisible(false);
        this.tfCustCity.setVisible(false);
        this.tfCustProvince.setVisible(false);
        this.tfCustPostal.setVisible(false);
        this.tfCustCountry.setVisible(false);
        this.tfCustHomePhone.setVisible(false);
        this.tfCustBusPhone.setVisible(false);
        this.tfCustEmail.setVisible(false);
        this.tfCustAgentId.setVisible(false);


//        ObservableList<Customer> customers = FXCollections.observableArrayList();
        colCustId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerId"));
        colCustFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("custFirstName"));
        colCustLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("custLastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("custAddress"));
        colCustCity.setCellValueFactory(new PropertyValueFactory<Customer, String>("custCity"));
        colCustProv.setCellValueFactory(new PropertyValueFactory<Customer, String>("custProv"));
        colCustPostal.setCellValueFactory(new PropertyValueFactory<Customer, String>("custPostal"));
        colCustCountry.setCellValueFactory(new PropertyValueFactory<Customer, String>("custCountry"));
        colCustHomePhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("custHomePhone"));
        colCustBusPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("custBusPhone"));
        colCustEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("custEmail"));
        colAgentId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("custAgentId"));

        Connection conn = myConnection.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers");
        ArrayList<Customer> custArrayList = new ArrayList<>();
        while (rs.next()){

            custArrayList.add(new Customer(rs.getInt(1), rs.getString(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getString(10),
                    rs.getString(11), rs.getInt(12)));
        }
        ObservableList<Customer> customers = FXCollections.observableArrayList(custArrayList);
        tblCustomers.setItems(customers);
        conn.close();

    }

    @FXML
    void onCustomerSelect(MouseEvent event) {
    Customer customer = tblCustomers.getSelectionModel().getSelectedItem();
    tfCustomerId.setText(Integer.toString(customer.getCustomerId()));
    tfCustFirstName.setText(customer.getCustFirstName());
    tfCustLastName.setText(customer.getCustLastName());
    tfCustAddress.setText(customer.getCustAddress());
    tfCustCity.setText(customer.getCustCity());
    tfCustProvince.setText(customer.getCustProv());
    tfCustPostal.setText(customer.getCustPostal());
    tfCustCountry.setText(customer.getCustCountry());
    tfCustHomePhone.setText(customer.getCustHomePhone());
    tfCustBusPhone.setText(customer.getCustBusPhone());
    tfCustEmail.setText(customer.getCustEmail());
    tfCustAgentId.setText(Integer.toString(customer.getCustAgentId()));
    }

    @FXML
    void onActionEdit(ActionEvent event) {
        this.lblCustomerId.setVisible(true);
        this.lblCustFistName.setVisible(true);
        this.lblCustLastName.setVisible(true);
        this.lblCustAddress.setVisible(true);
        this.lblCustCity.setVisible(true);
        this.lblCustProvince.setVisible(true);
        this.lblCustPostal.setVisible(true);
        this.lblCustCountry.setVisible(true);
        this.lblCustHomePhone.setVisible(true);
        this.lblCustBusPhone.setVisible(true);
        this.lblCustEmail.setVisible(true);
        this.lblCustAgentId.setVisible(true);

        this.tfCustomerId.setVisible(true);
        this.tfCustFirstName.setVisible(true);
        this.tfCustLastName.setVisible(true);
        this.tfCustAddress.setVisible(true);
        this.tfCustCity.setVisible(true);
        this.tfCustProvince.setVisible(true);
        this.tfCustPostal.setVisible(true);
        this.tfCustCountry.setVisible(true);
        this.tfCustHomePhone.setVisible(true);
        this.tfCustBusPhone.setVisible(true);
        this.tfCustEmail.setVisible(true);
        this.tfCustAgentId.setVisible(true);

    }

    @FXML
    void onActionSave(ActionEvent event) throws SQLException {
        Connection conn = myConnection.createConnection();
        String sql = "update customers set customerid=?, custfirstname=?, custlastname=?, custaddress=?, custcity=?, custprov=?, custpostal=?, custcountry=?, custhomephone=?, custbusphone=?, custemail=?, agentid=? where customerid='"+tfCustomerId.getText()+"' ";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1,tfCustomerId.getText());
        stmt.setString(2, tfCustFirstName.getText());
        stmt.setString(3, tfCustLastName.getText());
        stmt.setString(4, tfCustAddress.getText());
        stmt.setString(5, tfCustCity.getText());
        stmt.setString(6, tfCustProvince.getText());
        stmt.setString(7, tfCustPostal.getText());
        stmt.setString(8, tfCustCountry.getText());
        stmt.setString(9, tfCustHomePhone.getText());
        stmt.setString(10, tfCustBusPhone.getText());
        stmt.setString(11, tfCustEmail.getText());
        stmt.setString(12, tfCustAgentId.getText());

//        int data = stmt.executeUpdate();
        stmt.executeUpdate();
        stmt.close();

//        this.btnSave.setDisable(true);
//        this.btnEdit.setDisable(false);

    }
    @FXML
//    where customerid=?
    void addOnAction(ActionEvent event) throws SQLException {
        try {
            Connection conn = myConnection.createConnection();
            String sql = "insert into customers ( custfirstname, custlastname, custaddress, custcity, custprov," +
                    "custpostal, custcountry, custhomephone, custbusphone, custemail, agentid)" +
                    " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);

            //stmt.setString(1,tfCustomerId.getText());
            stmt.setString(1, tfCustFirstName.getText());
            stmt.setString(2, tfCustLastName.getText());
            stmt.setString(3, tfCustAddress.getText());
            stmt.setString(4, tfCustCity.getText());
            stmt.setString(5, tfCustProvince.getText());
            stmt.setString(6, tfCustPostal.getText());
            stmt.setString(7, tfCustCountry.getText());
            stmt.setString(8, tfCustHomePhone.getText());
            stmt.setString(9, tfCustBusPhone.getText());
            stmt.setString(10, tfCustEmail.getText());
            stmt.setInt(11, Integer.parseInt(tfCustAgentId.getText()));

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Need to input some data", ButtonType.OK);
            alert.show();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No data to be added. Please try again!", ButtonType.OK);
            alert.show();
        }
//        int data = stmt.executeUpdate();
//        this.btnEdit.setDisable(true);
//        this.btnSave.setDisable(true);
    }

    @FXML
    void ocActionClear(ActionEvent event) {
        this.tfCustomerId.clear();
        this.tfCustFirstName.clear();
        this.tfCustLastName.clear();
        this.tfCustAddress.clear();
        this.tfCustCity.clear();
        this.tfCustProvince.clear();
        this.tfCustPostal.clear();
        this.tfCustCountry.clear();
        this.tfCustHomePhone.clear();
        this.tfCustBusPhone.clear();
        this.tfCustEmail.clear();
        this.tfCustAgentId.clear();
    }


}//class end
