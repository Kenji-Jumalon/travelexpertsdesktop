package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    static Stage stg;
    private double x,y;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        //primaryStage.setTitle("");
        stg.setScene(new Scene(root, 800, 600));
        stg.initStyle(StageStyle.UNDECORATED);

        //make window draggable
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stg.setX(event.getScreenX() - x);
            stg.setY(event.getScreenY() - y);
        });
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
