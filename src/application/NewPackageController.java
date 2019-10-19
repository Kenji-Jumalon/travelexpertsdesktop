//package application;
//
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.TextField;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class NewPackageController {
//    DBHelper myConnection = new DBHelper();
//
//
//    @FXML
//    private Button btnExit;
//
//    @FXML
//    private Button btnSave;
//
//    @FXML
//    private TextField tfPackageId;
//
//    @FXML
//    private TextField tfPkgName;
//
//    @FXML
//    private TextField tfPkgStartDate;
//
//    @FXML
//    private TextField tfPkgEndDate;
//
//    @FXML
//    private TextField tfPkgDesc;
//
//    @FXML
//    private TextField tfPkgBasePrice;
//
//    @FXML
//    private TextField tfPkgAgencyCommission;
//
//
//
//}
//
//
//
//    @FXML
//    void OnActionBtnSave(ActionEvent event)throws SQLException {
//
//        Connection conn = helper.createConnection();
//        String sql = INSERT INTO `packages`(`PackageId`, `PkgName`, `PkgStartDate`, `PkgEndDate`, `PkgDesc`, `PkgBasePrice`, `PkgAgencyCommission`, `PkgImg`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
//
//
//
//        int rows = stmt.executeInsert();
//        conn.close();
//        if (rows == 0) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, "Package was not added, contact Dream Team", ButtonType.OK);
//            alert.show();
//        } else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Package Added successfully", ButtonType.OK);
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
