package API.Statistics;

import Models.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BarChartController implements Initializable {
    @FXML
    private BarChart<?,?> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel userModel = new UserModel();
        XYChart.Series set = new XYChart.Series<>();
        int z =  userModel.getListOfUsers("infected").size();
        int r =  userModel.getListOfUsers("recovered").size();
        int q =  userModel.getListOfUsers("quarantine").size();
        int d =  userModel.getListOfUsers("dead").size();
        int zdrowi =  userModel.getListOfUsers("all").size();
        set.getData().add(new XYChart.Data("Zarażeni",z));
        set.getData().add(new XYChart.Data("Kwarantanna",q));
        set.getData().add(new XYChart.Data("Zmarli",d));
        set.getData().add(new XYChart.Data("Wyzdrowiali",r));
        set.getData().add(new XYChart.Data("Zdrowi",zdrowi-z-q-d-r));
        barChart.getData().addAll(set);
    }
}
