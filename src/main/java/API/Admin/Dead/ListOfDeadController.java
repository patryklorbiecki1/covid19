package API.Admin.Dead;

import API.ChangeScene;
import Entities.User;
import Models.UserModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfDeadController implements Initializable {
    @FXML
    private TableView<User> tab;
    @FXML private TableColumn<User, Integer> idUser;
    @FXML private TableColumn<User, String> pesel;
    @FXML private TableColumn<User, String> lastname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        UserModel userModel = new UserModel();
        ObservableList show  = userModel.getListOfUsers("dead");
        tab.getItems().setAll(show);

    }
    public void back(){
        ChangeScene.launchScene("/views/Admin/Dead.fxml");
    }

}
