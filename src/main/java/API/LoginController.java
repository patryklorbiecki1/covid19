package API;

import Entities.User;
import Models.UserModel;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;

public class LoginController {

    @FXML private ProgressBar pi;
    @FXML private TextField pesel;
    @FXML private PasswordField password;
    @FXML
    private Label warning;

    public static String e,p;
    @FXML private Button btn;

    @FXML
    private void login(){
        pi.setVisible(true);
        btn.setDisable(true);
        Task<User> loadUserTask = new Task<User>() {
            @Override
            protected User call() {
                UserModel userModel = new UserModel();
                return userModel.getUser(pesel.getText());
            }
        };
        loadUserTask.setOnSucceeded(e -> {
            if(loadUserTask.getValue()!=null){
                try {
                    pi.setVisible(false);
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    URL xmlURL = getClass().getResource("/views/Menu.fxml");
                    loader.setLocation(xmlURL);
                    Parent root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.setMinHeight(600);
                    stage.setMinWidth(800);
                    stage.show();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else{
                btn.setDisable(false);
                pi.setVisible(false);
                warning.setVisible(true);
            }
        });
        loadUserTask.setOnFailed(e ->{
            pi.setVisible(false);
            btn.setDisable(false);
            warning.setVisible(true);});


        Thread loadUserThread = new Thread(loadUserTask);
        loadUserThread.start();
    }

    @FXML
    public void registrationForm(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            URL xmlURL = getClass().getResource("/views/Registration.fxml");
            loader.setLocation(xmlURL);
            Parent root = loader.load();
            Scene scene2 = new Scene(root);
            stage.setScene(scene2);
            stage.setMinHeight(400);
            stage.setMinWidth(600);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


