package API.User.UserData;

import API.ChangeScene;
import API.Login.LoginController;
import Entities.User;
import Models.UserModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class UserDataController implements Initializable{

    @FXML
    public Label lastname;
    @FXML
    public Label pesel;
    @FXML
    public Label region;
    @FXML
    public Label city;
    @FXML
    public Label district;
    @FXML
    public Label community;
    @FXML
    public Label postcode;
    @FXML
    public Label houseNr;
    @FXML
    public Label street;
    @FXML
    public Label name;

    public void back(){
        ChangeScene.launchScene("/views/User/MenuUser.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel userModel = new UserModel();
        User user = userModel.getUser(LoginController.P);
        lastname.setText(user.getLastName());
        name.setText(user.getName());
        region.setText(user.getRegion());
        city.setText(user.getCity());
        district.setText(user.getDistrict());
        community.setText(user.getCommunity());
        postcode.setText(user.getPostcode());
        houseNr.setText(user.getHouseNr());
        street.setText(user.getStreet());
        pesel.setText(user.getPesel());

    }
}
