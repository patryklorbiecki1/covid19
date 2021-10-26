package API.Menu;

import API.ChangeScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuUserController implements Initializable {
    @FXML
    private Label role;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      role.setText("Witaj! Jesteś zalogowany jako użytkownik.");
    }
    @FXML
    private void userData() {
        ChangeScene.launchScene("/views/User/UserData.fxml");
    }
    @FXML
    private void messages() {
        ChangeScene.launchScene("/views/User/UserMessages.fxml");
    }
    @FXML
    private void sendRequest() {
        ChangeScene.launchScene("/views/User/SendRequest.fxml");
    }
    @FXML
    private void statistics() {
        ChangeScene.launchScene("/views/Statistics.fxml");
    }

    @FXML
    private void polls() { ChangeScene.launchScene("/views/User/Polls.fxml");
    }
    @FXML
    private void requests() { ChangeScene.launchScene("/views/User/Rate.fxml");
    }
    @FXML
    private void hospital() {
        ChangeScene.launchScene("/views/User/Healthcare.fxml");
    }
    @FXML
    private void logout() {
        ChangeScene.launchScene("/Login.fxml");
    }

}
