package API.Admin.Recovered;

import API.ChangeScene;
import API.Login.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RecoveredController {
    @FXML
    private Label permission;
    public void displayUsers() {
        ChangeScene.launchScene("/views/Admin/ListOfRecovered.fxml"); }
    public void addToRecovered() {
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/Admin/AddToRecovered.fxml"); }
    public void back(){
        ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
    }
}
