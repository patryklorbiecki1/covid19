package API.Menu;


import API.ChangeScene;
import API.Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable {
    @FXML
    private Label role;
    @FXML
    private Label permission;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.setText("Witaj! Jesteś zalogowany jako administrator.");
    }
    @FXML
    private void listOfUsers() {
       ChangeScene.launchScene("/views/Admin/Users.fxml");
    }
    @FXML
    private void quarantine() {
        ChangeScene.launchScene("/views/Admin/Quarantine.fxml");
    }
    @FXML
    private void infected() {
        ChangeScene.launchScene("/views/Admin/Infected.fxml");
    }
    @FXML
    private void recovered() {
        ChangeScene.launchScene("/views/Admin/Recovered.fxml");
    }
    @FXML
    private void dead() {
        ChangeScene.launchScene("/views/Admin/Dead.fxml");
    }
    @FXML
    private void polls() {
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/User/Polls.fxml");
    }
    @FXML
    private void requests() {
        if(LoginController.isAdmin==0) permission.setVisible(true);
        else ChangeScene.launchScene("/views/Admin/Requests.fxml");
    }
    @FXML
    private void statistics() {
        ChangeScene.launchScene("/views/Statistics.fxml");
    }
    @FXML
    private void logout() {
        ChangeScene.launchScene("/Login.fxml");
    }


}
