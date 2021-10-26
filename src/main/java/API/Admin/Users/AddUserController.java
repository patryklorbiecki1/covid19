package API.Admin.Users;

import API.ChangeScene;
import Models.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class AddUserController {
    @FXML
    private Label peselExist;
    @FXML
    private Label created;
    @FXML
    private TextField name,lastname,pesel,region,city,district,community,postcode,street,houseNr;
    public void addUser(){
        created.setVisible(false);
        peselExist.setVisible(false);
        UserModel userModel = new UserModel();
        if (userModel.getUser(pesel.getText()) != null) {
            peselExist.setVisible(true);
        }
        else {
            userModel.createUser(pesel.getText(), lastname.getText(),0,0,0,0,0,name.getText(),region.getText(),
                    city.getText(),district.getText(),community.getText(),postcode.getText(),street.getText(),houseNr.getText());
            peselExist.setVisible(false);
            created.setVisible(true);
        }
    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/Users.fxml");
    }
}
