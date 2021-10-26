package API.User.Polls;

import API.ChangeScene;

public class PollsController {

    public void back(){
        ChangeScene.launchScene("/views/User/MenuUser.fxml");
    }
    public void health() { ChangeScene.launchScene("/views/User/HealthPolls.fxml"); }
    public void shopping(){ ChangeScene.launchScene("/views/User/ShoppingPolls.fxml");}
}
