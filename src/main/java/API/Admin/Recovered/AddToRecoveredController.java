package API.Admin.Recovered;

import API.ChangeScene;
import Entities.User;
import Models.UserModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddToRecoveredController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label label;
    @FXML
    private Label label2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label2.setVisible(false);
        label.setVisible(false);
        UserModel userModel = new UserModel();
        ObservableList<User> show  = userModel.getListOfUsers("all");
        ArrayList<String> pesels = new ArrayList<>();
        for(int i=0;i<show.size();i++){
            pesels.add(show.get(i).getPesel());
        }
        comboBox.getItems().addAll(pesels);
    }

    public void addToRecovered(){
        label.setVisible(true);
        UserModel userModel = new UserModel();
        User user = userModel.getUser(comboBox.getValue());
        if(user.getDead()!=1) {
            userModel.updateUser(user.getPesel(), 0, 0, 0, 1);
            label.setVisible(true);
        }
        else label2.setVisible(true);
    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/Recovered.fxml");
    }


}
