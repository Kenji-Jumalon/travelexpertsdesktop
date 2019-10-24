package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Bookings;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingsController {

    Connection conn;
    DBHelper myConnection = new DBHelper();
    ObservableList<Bookings> Bookings;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;


    @FXML
    private ComboBox<Bookings> cbBookingId;

    @FXML
    private TextField tfBookingId;

    @FXML
    private TextField tfBookingDate;

    @FXML
    private TextField tfBookingNo;

    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfTripTypeId;

    @FXML
    private TextField tfPackageId;

    @FXML
    private TextField tfTravelerCount;

















    @FXML
    void OnActionBtnSave(ActionEvent event)throws SQLException {

        Connection conn = myConnection.createConnection();
        String sql = "UPDATE `Bookings` SET `BookingId`=?, `BookingDate`=?, `BookingNo`=?, `CustomerId`=?,`TripTypeId`=?,  `PackageId`=?, `TravelerCount`=?,  WHERE `BookingId`= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, Integer.parseInt(tfBookingId.getText()));
        stmt.setDate(2, Date.valueOf(tfBookingDate.getText()));
        stmt.setString(3, tfBookingNo.getText());
        stmt.setInt(4, Integer.parseInt(tfCustomerId.getText()));
        stmt.setString(5, tfTripTypeId.getText());
        stmt.setInt(6,Integer.parseInt(tfPackageId.getText()));
        stmt.setInt(7, Integer.parseInt(tfTravelerCount.getText()));
        int rows = stmt.executeUpdate();
        conn.close();
        if (rows == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Update failed, contact Dream Team", ButtonType.OK);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update successful", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void OnActionBtnEdit(ActionEvent event) {

        btnEdit.setDisable(true);
        tfBookingId.setEditable(true);
        tfBookingDate.setEditable(true);
        tfBookingNo.setEditable(true);
        tfCustomerId.setEditable(true);
        tfTripTypeId.setEditable(true);
        tfPackageId.setEditable(true);
        tfTravelerCount.setEditable(true);
        btnSave.setDisable(false);
    }


  /*  @FXML
    boolean OnActionBtnDelete(ActionEvent event) throws SQLException {
        int numRows = 0;
        Connection conn = myConnection.createConnection();
        //"DELETE FROM `packages` WHERE `packages`.`PackageId` = 3"?
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You are about to delete a package,press yes to confirm", ButtonType.YES, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES){
            String sql = "DELETE FROM packages WHERE PackageId=?" ;
            PreparedStatement stmt = conn.prepareStatement(sql);
            int r = Integer.parseInt(tfPackageId.getText());
            stmt.setInt(1, r);
            System.out.println(r);
            numRows = stmt.executeUpdate();
        }else{
            System.exit(0);
        }

        conn.close();
        if (numRows > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        //Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are about to delete a Package, press OK to confirm", ButtonType.OK);
        //alert.show();


    }

*/


    @FXML
    void initialize() throws SQLException {
        assert cbBookingId != null : "fx:id=\"cbBookingId\" was not injected: check your FXML file 'main.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'main.fxml'.";
        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'main.fxml'.";
        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'main.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'main.fxml'.";
        assert tfTripTypeId != null : "fx:id=\"tfTripTypeId\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPackageId != null : "fx:id=\"tfPackageId\" was not injected: check your FXML file 'main.fxml'.";
        assert tfTravelerCount != null : "fx:id=\"tfTravelerCount\" was not injected: check your FXML file 'main.fxml'.";

        try {
            Connection conn = myConnection.createConnection();
            Statement stmt = conn.createStatement();

            ResultSet rslt = stmt.executeQuery("select * from Bookings");
            ArrayList<Bookings> bookingsArrayList = new ArrayList<>();
            while (rslt.next()) {
                bookingsArrayList.add(new Bookings(rslt.getInt("BookingId"), rslt.getDate("BookingDate"),
                        rslt.getString("BookingNo"), rslt.getInt("CustomerId"),
                        rslt.getString("TripTypeId"), rslt.getInt("PackageId"), rslt.getInt("TravelerCount")));


            }



            ObservableList<Bookings> bookings = FXCollections.observableArrayList(bookingsArrayList);
            cbBookingId.setItems(bookings);
        } catch (SQLException e) {
            e.printStackTrace();
        }






        cbBookingId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bookings>() {
            @Override
            public void changed(ObservableValue<? extends Bookings> observable, Bookings oldValue, Bookings newValue) {
                if (newValue != null) {
                    tfBookingId.setText(newValue.getBookingId().toString());
                    tfBookingDate.setText(newValue.getBookingDate().toString());
                    tfBookingNo.setText(newValue.getBookingNo());
                    tfCustomerId.setText(newValue.getCustomerId().toString());
                    tfTripTypeId.setText(newValue.getTripTypeId());
                    tfPackageId.setText( newValue.getPackageId().toString());
                    tfTravelerCount.setText(newValue.getTravelerCount().toString());

                }
            }
        });
    }



    public void OnActionMenuExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onActionBtnEdit(ActionEvent actionEvent) {
    }
}