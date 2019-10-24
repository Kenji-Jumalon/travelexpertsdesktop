package controller;

import application.DBHelper;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Agent;
import model.BookingDetail;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController {
    Package totalPackage;
    Agent userAgent;
    public static Stage astage;
    public static Stage cstage;
    public static Stage pstage;
    public static Stage bstage;

    Stage agentStage;
    Stage customerStage;
    Stage packagesStage;
    Stage bookingStage;

    DBHelper myConnection = new DBHelper();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgent;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnPackages;

//    @FXML
//    private Button btnPrint;

    @FXML
    private TextField tfNumberOfPackage;

    @FXML
    private TextField tfPackageLowestAmount;

    @FXML
    private TextField tfPackageHighestAmount;

    @FXML
    private TextField tfTripStart;

    @FXML
    private TextField tfTripEnd;

    @FXML
    private TextField tfDestination;

    @FXML
    private TextField tfBasePrice;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextArea taDetails;

    @FXML
    private ComboBox<Integer> cbLoadBookingId;

    @FXML
    private ImageView exit;

//    @FXML
//    private ListView<BookingDetail> lvDetails;

    @FXML
    private TableView<BookingDetail> tblBookingsDetail;

    @FXML
    private TableColumn<BookingDetail, Integer> colBookingDetailId;

    @FXML
    private TableColumn<BookingDetail, Double> colIteneraryNo;

    @FXML
    private TableColumn<BookingDetail, Date> colTripStart;

    @FXML
    private TableColumn<BookingDetail, Date> colTripEnd;

    @FXML
    private TableColumn<BookingDetail, String> colDescription;


    //agents view
    @FXML
    void agentOnBtnAction(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/AgentsDisplay.fxml"));
            Parent agentRoot = (Parent) fxmlLoader.load();
//            Stage agentStage = new Stage();
            agentStage = new Stage();
            agentStage.setTitle("Agents");
            agentStage.setScene(new Scene(agentRoot, 1000, 380));
            agentStage.initStyle(StageStyle.DECORATED);
            agentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.astage = agentStage;
    }

    //customer view
    @FXML
    void custOnBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/CustomersDisplay.fxml"));
            Parent custRoot = (Parent) fxmlLoader.load();
//            Stage customerStage = new Stage();
            customerStage = new Stage();
            customerStage.setTitle("Customers");
            customerStage.setScene(new Scene(custRoot, 1000, 380));
            customerStage.initStyle(StageStyle.DECORATED);
            customerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cstage = customerStage;
    }

    // package view
    @FXML
    void packagesOnBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Packages.fxml"));
            Parent packageRoot = (Parent) fxmlLoader.load();
//            Stage customerStage = new Stage();
            packagesStage = new Stage();
            packagesStage.setTitle("Packages");
            packagesStage.setScene(new Scene(packageRoot, 1000, 600));
            packagesStage.initStyle(StageStyle.DECORATED);
            packagesStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.pstage = packagesStage;
    }

    // booking view
    @FXML
    void bookingsOnBtnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Packages.fxml"));
            Parent bookingRoot = (Parent) fxmlLoader.load();
//            Stage customerStage = new Stage();
            bookingStage = new Stage();
            bookingStage.setTitle("Bookings");
            bookingStage.setScene(new Scene(bookingRoot, 1000, 600));
            bookingStage.initStyle(StageStyle.DECORATED);
            bookingStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bstage = bookingStage ;
    }

    @FXML
    void initialize() throws SQLException {
        assert btnAgent != null : "fx:id=\"btnAgent\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert btnCustomer != null : "fx:id=\"btnCustomer\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfTripStart != null : "fx:id=\"tfTripStart\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfTripEnd != null : "fx:id=\"tfTripEnd\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfDestination != null : "fx:id=\"tfDestination\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfBasePrice != null : "fx:id=\"tfBasePrice\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfDescription != null : "fx:id=\"tfDescription\" was not injected: check your FXML file 'MainDisplay.fxml'.";
//        assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'MainDisplay.fxml'.";
//        assert lvDetails != null : "fx:id=\"lvDetails\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfNumberOfPackage != null : "fx:id=\"tfNumberOfPackage\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfPackageLowestAmount != null : "fx:id=\"tfPackageLowestAmount\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tfPackageHighestAmount != null : "fx:id=\"tfPackageHighestAmount\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert cbLoadBookingId != null : "fx:id=\"cbLoadBookingId\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert taDetails != null : "fx:id=\"taDetails\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert colBookingDetailId != null : "fx:id=\"colBookingDetailId\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert colIteneraryNo != null : "fx:id=\"colIteneraryNo\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert colTripStart != null : "fx:id=\"ColTripStart\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert colTripEnd != null : "fx:id=\"colTripEnd\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert colDescription != null : "fx:id=\"ColDescription\" was not injected: check your FXML file 'MainDisplay.fxml'.";
        assert tblBookingsDetail != null : "fx:id=\"tblBookingsDetail\" was not injected: check your FXML file 'MainDisplay.fxml'.";

        colBookingDetailId.setCellValueFactory(new PropertyValueFactory<BookingDetail, Integer>("bookingDetailId"));
        colIteneraryNo.setCellValueFactory(new PropertyValueFactory<BookingDetail, Double>("itineraryNo"));
        colTripStart.setCellValueFactory(new PropertyValueFactory<BookingDetail, Date>("tripStart"));
        colTripEnd.setCellValueFactory(new PropertyValueFactory<BookingDetail, Date>("tripEnd"));
        colDescription.setCellValueFactory(new PropertyValueFactory<BookingDetail, String>("description"));

        userAgent = Main.getUser();

        tfNumberOfPackage.setText(String.valueOf(loadNumberOfPackage()));
//        tfPackageLowestAmount.setText(String.valueOf(getMax()));

        getMax();
        getMin();
        loadComboBox();

        this.tfNumberOfPackage.setEditable(false);
        this.tfPackageLowestAmount.setEditable(false);
        this.tfPackageHighestAmount.setEditable(false);

    }//initialized end

    private void loadComboBox() throws SQLException {
        Connection conn = myConnection.createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select bookingId from bookingdetails");
        ArrayList<Integer> bookingId = new ArrayList<>();
        while (rs.next()){
            bookingId.add(rs.getInt("BookingId"));
        }
        ObservableList<Integer> bkgId = FXCollections.observableArrayList(bookingId);
        cbLoadBookingId.setItems(bkgId);
        conn.close();
    }

    @FXML
    void onActionSelectBookingDetailId(ActionEvent event) {
        int id = cbLoadBookingId.getSelectionModel().selectedItemProperty().getValue();

        Connection conn = myConnection.createConnection();
//        String sql = "select tripstart, tripend, description, baseprice, destination from bookingdetails where bookingid = ?";
        String sql = "select bookingdetailid, itineraryno, tripstart, tripend, description from bookingdetails where bookingid = ?";
//        ResultSet rs = stmt.executeQuery("select * from bookingdetails");
        PreparedStatement prepstmt = null;
        try {
            prepstmt = conn.prepareStatement(sql);

            prepstmt.setInt(1, id);
            ResultSet rs = prepstmt.executeQuery();
            ArrayList<BookingDetail> detailArrayList = new ArrayList<>();
            if(rs.next())
            {
                BookingDetail bookingDetail = new BookingDetail();
                bookingDetail.setBookingDetailId(rs.getInt("BookingDetailId"));
                bookingDetail.setItineraryNo(rs.getDouble("ItineraryNo"));
                bookingDetail.setTripStart(rs.getDate("TripStart"));
                bookingDetail.setTripEnd(rs.getDate("TripEnd"));
                bookingDetail.setDescription(rs.getString("Description"));

                detailArrayList.add(bookingDetail);

//                    colBookingDetailId.setCellValueFactory(new PropertyValueFactory<BookingDetail, Integer>("bookingDetailId"));
//                    colIteneraryNo.setCellValueFactory(new PropertyValueFactory<BookingDetail, Double>("itineraryNo"));
//                    colTripStart.setCellValueFactory(new PropertyValueFactory<BookingDetail, Date>("tripStart"));
//                    colTripEnd.setCellValueFactory(new PropertyValueFactory<BookingDetail, Date>("tripEnd"));
//                    colDescription.setCellValueFactory(new PropertyValueFactory<BookingDetail, String>("description"));
                conn.close();
                ObservableList<BookingDetail> bookingsdetail = FXCollections.observableArrayList(detailArrayList);
                tblBookingsDetail.setItems(bookingsdetail);
            }} catch (SQLException e) {
            e.printStackTrace();
        }

    }


   private int loadNumberOfPackage() throws SQLException {
       Connection conn = myConnection.createConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("select * from packages");
       int count = 0;
       while(rs.next()){
           count++;
       }
       return count;
   }

   private void getMax() throws SQLException {
       Connection conn = myConnection.createConnection();
//       Statement stmt = conn.createStatement();
       String sql = "select packageId, pkgName, pkgStartDate, pkgEndDate, pkgDesc, max(PkgBasePrice) as max from packages";
       PreparedStatement prepstmt = conn.prepareStatement(sql);
       ResultSet rs = prepstmt.executeQuery();
//       ArrayList<Integer> highestPackage = new ArrayList<>();
       while(rs.next()){
//           tfPackageHighestAmount.setText(String.valueOf(rs.getDouble(5)));
           tfPackageHighestAmount.setText(String.valueOf(rs.getDouble("max")));
       }
   }
    private void getMin() throws SQLException {
        Connection conn = myConnection.createConnection();
    //       Statement stmt = conn.createStatement();
        String sql = "select packageId, pkgName, pkgStartDate, pkgEndDate, pkgDesc, min(PkgBasePrice) as min from packages";
        PreparedStatement prepstmt = conn.prepareStatement(sql);
        ResultSet rs = prepstmt.executeQuery();
    //       ArrayList<Integer> highestPackage = new ArrayList<>();
        while(rs.next()){
    //           tfPackageHighestAmount.setText(String.valueOf(rs.getDouble(5)));
            tfPackageLowestAmount.setText(String.valueOf(rs.getDouble("min")));
        }
    }

}//controller class end

/*        Alert alert = new Alert(Alert.AlertType.INFORMATION, userAgent.getFirstName(), ButtonType.OK);
        alert.show();*/

/*listview onload*/
//        //display to a listview during initialization
//        Connection conn = myConnection.createConnection();
//        Statement stmt = conn.createStatement();
////        ResultSet rs = stmt.executeQuery("select * from packages");
//        ResultSet rs = stmt.executeQuery("select * from bookingdetails");
//
////        String sql = "select custfirstname, custlastname, tripstart, tripend, description, baseprice, destination from customers " +
////                "inner JOIN bookings on bookings.customerid = customers.customerid " +
////                "inner JOIN bookingdetail on bookingdetail.bookingid = bookings.bookingid " +
////                "where bookingid = ?";
//
////        ArrayList<Package> packageArrayList = new ArrayList<>();
//        ArrayList<BookingDetail> detailArrayList = new ArrayList<>();
//        while(rs.next())
//        {
////            packageArrayList.add(new Package(rs.getInt("PackageId"), rs.getString("PkgName"),rs.getDate("PkgStartDate"),
////                    rs.getDate("PkgEndDate"), rs.getString("PkgDesc"),
////                    rs.getDouble("PkgBasePrice"), rs.getDouble("PkgAgencyCommission")));
//
//            detailArrayList.add(new BookingDetail(rs.getInt("BookingDetailId"), rs.getDouble("ItineraryNo"),rs.getDate("TripStart"),
//                    rs.getDate("TripEnd"), rs.getString("Description"),rs.getString("Destination"),
//                    rs.getBigDecimal("BasePrice"), rs.getBigDecimal("AgencyCommission"), rs.getInt("BookingId"),
//                    rs.getString("RegionId"), rs.getString("ClassId"), rs.getString("FeeId"),
//                    rs.getInt("ProductSupplierId")));
//        }
//        ObservableList<BookingDetail> details = FXCollections.observableArrayList(detailArrayList);
//        lvDetails.setItems(details);
//        conn.close();
