package API.Login;

import API.ChangeScene;
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
    public static String P;
    public static int isAdmin;
    @FXML
    private TextField pesel;
    @FXML
    private Label warning;
    @FXML
    private void login(){

        Task<User> loadUserTask = new Task<User>() {
            @Override
            protected User call() {
                UserModel userModel = new UserModel();
                isAdmin = userModel.getUser(pesel.getText()).getAdmin();
                P = pesel.getText();
                return userModel.getUser(pesel.getText());
            }
        };
        loadUserTask.setOnSucceeded(e -> {
            if(loadUserTask.getValue()!=null){
                try {
                   if(isAdmin==1) ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
                   else ChangeScene.launchScene("/views/User/MenuUser.fxml");
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else{
                warning.setVisible(true);
            }
        });
        loadUserTask.setOnFailed(e ->{
            warning.setVisible(true);});


        Thread loadUserThread = new Thread(loadUserTask);
        loadUserThread.start();
    }

    @FXML
    public void registrationForm(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            URL xmlURL = getClass().getResource("/views/Admin/Registration.fxml");
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