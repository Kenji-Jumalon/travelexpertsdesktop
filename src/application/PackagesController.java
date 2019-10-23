package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Packages;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PackagesController {

    Connection conn;
    DBHelper myConnection = new DBHelper();
    ObservableList<Packages> packages;

   @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnDelete;

    @FXML
    private ComboBox<Packages> cbPackageId;

    @FXML
    private TextField tfPackageId;

    @FXML
    private TextField tfPkgName;

    @FXML
    private TextField tfPkgStartDate;

    @FXML
    private TextField tfPkgEndDate;

    @FXML
    private TextField tfPkgDesc;

    @FXML
    private TextField tfPkgBasePrice;

    @FXML
    private TextField tfPkgAgencyCommission;

    @FXML
    private Button btnNewPackage;


   /* @FXML
    void OnActionBtnNewPackage(ActionEvent event) throws IOException {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/NewPackage.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root5,  1000, 1000));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






*/
   public void OnActionBtnNewPackage(ActionEvent event) throws SQLException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controller/NewPackage.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("NewPackage.fxml");
            stage.setScene(new Scene(root5,  1000, 800 ));
            stage.show();
        }   catch (Exception e) {
            e.printStackTrace();
            System.out.println("Window can't load");

        }

    }








    @FXML
    void OnActionBtnSave(ActionEvent event)throws SQLException {

        Connection conn = myConnection.createConnection();
        String sql = "UPDATE `Packages` SET `PkgName`=?, `PkgStartDate`=?, `PkgEndDate`=?, `PkgDesc`=?,`PkgBasePrice`=?, `PkgAgencyCommission`=? WHERE `PackageId`= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, tfPkgName.getText());
        stmt.setDate(2, Date.valueOf(tfPkgStartDate.getText()));
        stmt.setDate(3, Date.valueOf(tfPkgEndDate.getText()));
        stmt.setString(4, tfPkgDesc.getText());
        stmt.setDouble(5, Double.parseDouble(tfPkgBasePrice.getText()));
        stmt.setDouble(6,Double.parseDouble(tfPkgAgencyCommission.getText()));
        stmt.setInt(7, Integer.parseInt(tfPackageId.getText()));
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
        tfPackageId.setEditable(true);
        tfPkgName.setEditable(true);
        tfPkgStartDate.setEditable(true);
        tfPkgEndDate.setEditable(true);
        tfPkgDesc.setEditable(true);
        tfPkgBasePrice.setEditable(true);
        tfPkgAgencyCommission.setEditable(true);
        btnSave.setDisable(false);
    }


    @FXML
    boolean OnActionBtnDelete(ActionEvent event) throws SQLException {

        Connection conn = myConnection.createConnection();
        //"DELETE FROM `packages` WHERE `packages`.`PackageId` = 3"?
       // Alert alert = new Alert(Alert.AlertType.INFORMATION, "You are about to delete a Package, press OK to confirm", ButtonType
        String sql = "DELETE * FROM `packages` WHERE `PackageId`=?" ;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,Integer.parseInt(tfPackageId.getText()));



        System.out.println(sql);
        Statement stmt1 = conn.createStatement();
        int numRows = stmt1.executeUpdate(sql);
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




    @FXML
    void initialize() throws SQLException {
        assert cbPackageId != null : "fx:id=\"cbPackageId\" was not injected: check your FXML file 'main.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'main.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgStartDate != null : "fx:id=\"tfStartDate\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgEndDate != null : "fx:id=\"tfPkgEndDate\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgDesc != null : "fx:id=\"tfPkgDesc\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'main.fxml'.";
        assert tfPkgAgencyCommission != null : "fx:id=\"tfPkgAgencyCommission\" was not injected: check your FXML file 'main.fxml'.";

        try {
            Connection conn = myConnection.createConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select PackageId, PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission from Packages");
            ArrayList<Packages> packagesArrayList = new ArrayList<>();
            while (rs.next()) {
                packagesArrayList.add(new Packages(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getDate(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7)));
            }

            ObservableList<Packages> packages = FXCollections.observableArrayList(packagesArrayList);
            cbPackageId.setItems(packages);
        } catch (SQLException e) {
            e.printStackTrace();
        }






        cbPackageId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Packages>() {
            @Override
            public void changed(ObservableValue<? extends Packages> observable, Packages oldValue, Packages newValue) {
                if (newValue != null) {
                    tfPackageId.setText(newValue.getPackageId().toString());
                    tfPkgName.setText(newValue.getPkgName());
                    tfPkgStartDate.setText(newValue.getPkgStartDate().toString());
                    tfPkgEndDate.setText(newValue.getPkgEndDate().toString());
                    tfPkgDesc.setText(newValue.getPkgDesc());
                    tfPkgBasePrice.setText( newValue.getPkgBasePrice().toString());
                    tfPkgAgencyCommission.setText(newValue.getPkgAgencyCommission().toString());

                }
            }
        });
    }


    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public Button getBtnNewPackage() {
        return btnNewPackage;
    }

    public void setBtnNewPackage(Button btnNewPackage) {
        this.btnNewPackage = btnNewPackage;
    }

    public void OnActionMenuExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}