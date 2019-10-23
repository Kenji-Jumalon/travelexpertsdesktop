package application;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Packages;

import java.sql.*;


public class NewPackageController {
 Connection conn;
 DBHelper myConnection = new DBHelper();
 ObservableList<Packages> packages;

 @FXML
 private Button btnExit;

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
    private TextField tfImage;



    @FXML
     boolean OnActionBtnSave(ActionEvent event) throws SQLException {

        Connection conn = myConnection.createConnection();
           String sql = "INSERT INTO `packages` (`PkgName`, `PkgStartDate`, `PkgEndDate`, `PkgDesc`, `PkgBasePrice`, `PkgAgencyCommission`, `PkgImg`) values (?,?,?,?,?,?,?)"; //VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])


     PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
     // stmt.setInt(1, Integer.parseInt(tfPackageId.getText()));
      stmt.setString(1, tfPkgName.getText());
      stmt.setDate(2, Date.valueOf(tfPkgStartDate.getText()));
      stmt.setDate(3, Date.valueOf(tfPkgEndDate.getText()));
      stmt.setString(4, tfPkgDesc.getText());
      stmt.setDouble(5, Double.parseDouble(tfPkgBasePrice.getText()));
      stmt.setDouble(6, Double.parseDouble(tfPkgAgencyCommission.getText()));
     stmt.setString(7, tfImage.getText());




     System.out.println(stmt);

     int numRows = stmt.executeUpdate();
     conn.close();
     if (numRows > 0)
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION, "Package created successfully", ButtonType.OK);
         alert.show();

         return true;
     }
     else
     {
         Alert alert = new Alert(Alert.AlertType.INFORMATION, "New Package not created", ButtonType.OK);
         alert.show();

         return false;
     }





       /* int rows = stmt.executeUpdate();
        conn.close();
       if (rows == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Package was not added, contact Dream Team", ButtonType.OK);alert.show();
       } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Package Added successfully. We are the champions!! ", ButtonType.OK);
            alert.show();
       }

*/






    }

    public void OnActionBtnExit(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void OnActionMenuExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}


   /* public boolean savePackage() throws Exception
            {
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", userInfo);
            String sql = "INSERT INTO Packages (PkgName,AgtMiddleInitial,AgtLastName,AgtEmail,AgtBusPhone,AgtPosition,AgencyId) VALUES('"
            + tfPkgName.getText()
            + "','"
            + tfPkgStartDate.getText()
            + "','"
            + tfPkgEndDate.getText()
            + "','"
            + tfPkgBaseDesc.getText()
            + "','"
            + tfPkgBasePrice.getText()
            + "','"
            + tfPkgAgencyCommission.getText()
            + "',"
            + tfAgencyId.getText()
            + ")";
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

            //return true;
            } */