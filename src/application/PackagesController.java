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

import java.sql.*;
import java.util.ArrayList;

public class PackagesController {
    DBHelper myConnection = new DBHelper();


    @FXML
    private ComboBox<Packages> cbPackageId;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

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
    void OnActionBtnNewPackage(ActionEvent event) throws SQLException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newPackage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("newPackage.fxml");
            stage.setScene(new Scene(root1));
            stage.show();
        }   catch (Exception e) {
            System.out.println("Window can't load");

        }

    }


    @FXML
    void OnActionBtnSave(ActionEvent event)throws SQLException {

        Connection conn = myConnection.createConnection();
        String sql = "UPDATE `Packages` SET `PackageId`=?,`PkgName`=?, `PkgStartDate`=?, `PkgEndDate`=?, `PkgDesc`=?,`PkgBasePrice`=?, `PkgAgencyCommission`=?,WHERE `PackageId`= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(tfPackageId.getText()));
        stmt.setString(2, tfPkgName.getText());
        stmt.setDate(3, Date.valueOf(tfPkgStartDate.getText()));
        stmt.setDate(4, Date.valueOf(tfPkgEndDate.getText()));
        stmt.setString(5, tfPkgDesc.getText());
        stmt.setInt(6, Integer.parseInt(tfPkgBasePrice.getText()));
        stmt.setInt(7, Integer.parseInt(tfPkgAgencyCommission.getText()));
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
    void onActionBtnEdit(ActionEvent event) {

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

            ResultSet rs = stmt.executeQuery("select * from Packages");
            ArrayList<Packages> packagesArrayList = new ArrayList<>();
            while (rs.next()) {
                packagesArrayList.add(new Packages(rs.getInt(0), rs.getString(1),
                        rs.getDate(2), rs.getDate(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6)));
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

}