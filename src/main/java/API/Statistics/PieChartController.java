package API.Statistics;

import Entities.User;
import Models.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class PieChartController implements Initializable {
    @FXML
    private PieChart pieChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserModel userModel = new UserModel();
        int z =  userModel.getListOfUsers("infected").size();
        int r =  userModel.getListOfUsers("recovered").size();
        int q =  userModel.getListOfUsers("quarantine").size();
        int d =  userModel.getListOfUsers("dead").size();
        int zdrowi =  userModel.getListOfUsers("all").size();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Zarażeni",z),
                new PieChart.Data("Kwarantanna",q),
                new PieChart.Data("Zmarli",d),
                new PieChart.Data("Wyzdrowiali",r),
                new PieChart.Data("Zdrowi", zdrowi-z-q-d-r)
        );
        pieChart.setData(pieChartData);
    }
}
