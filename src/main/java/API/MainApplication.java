
package API;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class MainApplication extends Application {

    static Parent root;
    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene;

                root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
                scene = new Scene(root, 800, 500);
                MainApplication.primaryStage = primaryStage;
                primaryStage.setTitle("Covid-19");
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.show();
    }


    public static Parent getRoot(){
        return root;
    }

    public static void setRoot(Parent root){ MainApplication.root = root; }

    public static Stage getStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}