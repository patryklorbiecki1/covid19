package API.User.Polls;

import API.ChangeScene;
import API.Login.LoginController;

public class HealthPollsController {
    public void back(){
        if(LoginController.isAdmin==0) ChangeScene.launchScene("/views/User/MenuUser.fxml");
        else ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
    }
}
