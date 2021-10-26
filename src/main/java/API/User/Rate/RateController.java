package API.User.Rate;

import API.ChangeScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class RateController {
    @FXML
    public Label l;
    public void back(){
        ChangeScene.launchScene("/views/User/MenuUser.fxml");
    }

    public void send(){
        l.setVisible(true);
    }
}
