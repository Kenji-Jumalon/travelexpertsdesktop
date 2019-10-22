package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;




public class NewPackageController {
   DBHelper myConnection = new DBHelper();


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



}





 // @FXML
 /*void OnActionBtnSave(ActionEvent event) throws SQLException, SQLException {

        Connection conn = helper.createConnection();
       String sql = INSERT INTO `packages` VALUES(`PackageId`, `PkgName`, `PkgStartDate`, `PkgEndDate`, `PkgDesc`, `PkgBasePrice`, `PkgAgencyCommission`, `PkgImg`) //VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
       PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
      stmt.setInt(1, Integer.parseInt(tfPackageId.getText()));
      stmt.setString(2, tfPkgName.getText());
      stmt.setDate(3, Date.valueOf(tfPkgStartDate.getText()));
      stmt.setDate(4, Date.valueOf(tfPkgEndDate.getText()));
      stmt.setString(5, tfPkgDesc.getText());
      stmt.setInt(6, Integer.parseInt(tfPkgBasePrice.getText()));
      stmt.setInt(7, Integer.parseInt(tfPkgAgencyCommission.getText()));


        int rows = stmt.executeInsert();
        conn.close();
       if (rows == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Package was not added, contact Dream Team", ButtonType.OK);alert.show();
       } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Package Added successfully. We are ", ButtonType.OK);
            alert.show();
       }








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