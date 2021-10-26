package API.Admin.Users;

import API.ChangeScene;
import API.Login.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class UsersController{

    @FXML
    private Label permission;
    public void addUser(){
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/Admin/AddUser.fxml");
    }
    public void displayUsers() {ChangeScene.launchScene("/views/Admin/ListOfUsers.fxml"); }
    public void sendMessage(){
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/User/SendMessage.fxml");
    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
    }
}