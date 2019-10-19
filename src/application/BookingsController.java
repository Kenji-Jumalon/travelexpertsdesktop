//package application;
//
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import model.Bookings;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class BookingsController {
//
//    DBHelper myConnection = new DBHelper();
//
//    @FXML
//    private ComboBox<?> cbBookingId;
//
//    @FXML
//    private Button btnEdit;
//
//    @FXML
//    private Button btnSave;
//
//    @FXML
//    private TextField tfBookingId;
//
//    @FXML
//    private TextField tfBookingDate;
//
//    @FXML
//    private TextField tfBookingNo;
//
//    @FXML
//    private TextField tfCustomerId;
//
//    @FXML
//    private TextField tfTripTypeId;
//
//    @FXML
//    private TextField tfTravelerCount;
//
//    @FXML
//    void OnActionBtnSave(ActionEvent event)throws SQLException {
//
//        Connection conn = helper.createConnection();
//        String sql = "UPDATE `bookings` SET `BookingId`=?,`BookingDate`=?, `BookingNo`=?, `CustomerId`=?, `TripTypeId`=?,`PackageId`=?, `TravelerCount`=?,WHERE `BookingId`= ?";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, Integer.parseInt(tfBookingId.getText()));
//        stmt.setString(2, tfBookingDate.getText());
//        stmt.setString(3, tfBookingNo.getText());
//        stmt.setString(4, tfCustomerId.getText());
//        stmt.setString(5, tfTripTypeId.getText());
//        stmt.setString(6, tfTravelerCount.getText());
//
//
//
//        int rows = stmt.executeUpdate();
//        conn.close();
//        if (rows == 0) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Update failed, contact Dream Team", ButtonType.OK);
//            alert.show();
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update successful", ButtonType.OK);
//            alert.show();
//        }
//
//
//
//
//
//
//
//
//    }
//
//    @FXML
//    void onActionBtnEdit(ActionEvent event) {
//
//        btnEdit.setDisable(true);
//        tfBookingId.setEditable(true);
//        tfBookingDate.setEditable(true);
//        tfBookingNo.setEditable(true);
//        tfCustomerId.setEditable(true);
//        tfTripTypeId.setEditable(true);
//        tfTravelerCount.setEditable(true);
//        btnSave.setDisable(false);
//
//
//
//    }
//
//    @FXML
//    void initialize() throws SQLException {
//        assert cbBookingId != null : "fx:id=\"cbBookingId\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfCustomerId != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfTripTypeId != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfTravelerCount != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'sample.fxml'.";
//
//
//        try {
//            conn = helper.createConnection();
//            Statement stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from Bookings");
//            ArrayList<Bookings> agentArrayList = new ArrayList<>();
//            while (rs.next()) {
//                agentArrayList.add(new Bookings(rs.getInt(1), rs.getString(2),
//                        rs.getString(3), rs.getString(4),
//                        rs.getString(5), rs.getString(6)));
//
//
//            }
//            ObservableList<Bookings> agent = FXCollections.observableArrayList(agentArrayList);
//            cbBookingId.setItems(Bookings);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        cbBookingId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bookings>() {
//            @Override
//            public void changed(ObservableValue<? extends Bookings> observable, Bookings oldValue, Bookings newValue) {
//                if (newValue != null) {
//                    tfBookingId.setText(newValue.getBookingId() + "");
//                    tfBookingDate.setText(newValue.getBookingDate());
//                    tfBookingNo.setText(newValue.getBookingNo());
//                    tfCustomerId.setText(newValue.getCustomerId());
//                    tfTripTypeId.setText(newValue.getTripTypeId());
//                    tfTravelerCount.setText(newValue.getTravelerCount());
//
//                }
//            }
//        });
//    }
//
//
//    @FXML
//    void initialize() throws SQLException {
//        assert cbBookingId != null : "fx:id=\"cbBookingId\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'sample.fxml'.";
//        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfCustomerId != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfTripTypeId != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'sample.fxml'.";
//        assert tfTravelerCount != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'sample.fxml'.";
//
//
//        try {
//            conn = helper.createConnection();
//            Statement stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from Bookings");
//            ArrayList<Bookings> agentArrayList = new ArrayList<>();
//            while (rs.next()) {
//                agentArrayList.add(new Bookings(rs.getInt(1), rs.getString(2),
//                        rs.getString(3), rs.getString(4),
//                        rs.getString(5), rs.getString(6)));
//
//
//            }
//            ObservableList<Bookings> agent = FXCollections.observableArrayList(agentArrayList);
//            cbBookingId.setItems(Bookings);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        cbBookingId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bookings>() {
//            @Override
//            public void changed(ObservableValue<? extends Bookings> observable, Bookings oldValue, Bookings newValue) {
//                if (newValue != null) {
//                    tfBookingId.setText(newValue.getBookingId() + "");
//                    tfBookingDate.setText(newValue.getBookingDate());
//                    tfBookingNo.setText(newValue.getBookingNo());
//                    tfCustomerId.setText(newValue.getCustomerId());
//                    tfTripTypeId.setText(newValue.getTripTypeId());
//                    tfTravelerCount.setText(newValue.getTravelerCount());
//
//                }
//            }
//        });
//    }
//
//
//
//
//}
