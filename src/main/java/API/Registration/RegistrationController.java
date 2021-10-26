package API.Registration;

import API.ChangeScene;
import Models.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class RegistrationController {

    @FXML private TextField pesel;
    @FXML private TextField lastname;
    @FXML private Label peselExist;
    @FXML private Label created;
    @FXML
    public void register(){
        created.setVisible(false);
        peselExist.setVisible(false);
        String p = this.pesel.getText();
        String l = this.lastname.getText();
        UserModel userModel = new UserModel();
        if (userModel.getUser(p) != null) {
            peselExist.setVisible(true);
        }
        else {
            userModel.createUser(p, l,0,0,0,0,0,"","","","","","","","");
            peselExist.setVisible(false);
            created.setVisible(true);
        }
    }

    @FXML
    public void back(){
        ChangeScene.launchScene("/views/Admin/Users.fxml");
    }

}
