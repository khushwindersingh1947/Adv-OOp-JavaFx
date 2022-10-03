package com.example.f22comp1011s1w1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis catAx;

    @FXML
    private NumberAxis numAx;

    @FXML
    void SwitchToTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"song-table-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String,Integer> songs = new XYChart.Series<>();
        songs.getData().add(new XYChart.Data<String,Integer>("bruno",30));
        songs.getData().add(new XYChart.Data<String,Integer>("kill",40));
        songs.getData().add(new XYChart.Data<String,Integer>("ksm",10));
        songs.getData().add(new XYChart.Data<String,Integer>("chotilo",5));

        barChart.getData().addAll(songs);

    }
}
