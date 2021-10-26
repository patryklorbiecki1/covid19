package API.Requests;

import API.ChangeScene;
import Entities.User;
import Models.MessageModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestsController implements Initializable {

    @FXML
    private TableView<User> tab;
    @FXML private TableColumn<User, Integer> idMessage;
    @FXML private TableColumn<User, String> pesel;
    @FXML private TableColumn<User, String> message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idMessage.setCellValueFactory(new PropertyValueFactory<>("idMessage"));
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));

        MessageModel messageModel = new MessageModel();
        ObservableList show  = messageModel.getAllMessages();
        tab.getItems().setAll(show);

    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/MenuAdmin.fxml");
    }


}
