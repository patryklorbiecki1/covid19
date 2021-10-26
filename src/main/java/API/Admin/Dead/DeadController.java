package API.Admin.Dead;

import API.ChangeScene;
import API.Login.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DeadController {
    @FXML
    private Label permission;
    public void displayUsers() {
        ChangeScene.launchScene("/views/Admin/ListOfDead.fxml"); }
    public void addToDead() {
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/Admin/AddToDead.fxml"); }
    public void back(){
        ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
    }
}
