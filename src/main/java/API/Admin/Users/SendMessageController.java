package API.Admin.Users;

import API.ChangeScene;
import Entities.User;
import Models.MessageModel;
import Models.UserModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SendMessageController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextArea message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel userModel = new UserModel();
        ObservableList<User> show  = userModel.getListOfUsers("all");
        ArrayList<String> pesels = new ArrayList<>();
        for(int i=0;i<show.size();i++){
            pesels.add(show.get(i).getPesel());
        }
        comboBox.getItems().addAll(pesels);
    }
    public void send()
    {
        String m = message.getText();
        MessageModel messageModel = new MessageModel();
        messageModel.createMessage(comboBox.getValue(),m);
    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/Users.fxml");
    }

}
