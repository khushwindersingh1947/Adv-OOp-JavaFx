package com.example.f22comp1011s1w1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SongTableViewController implements Initializable {

    @FXML
    private TableColumn<Song, String> artist;

    @FXML
    private TableColumn<Song, String> genre;

    @FXML
    private TableColumn<Song, Integer> length;

    @FXML
    private TableColumn<Song, String> name;

    @FXML
    private TableColumn<Song, Integer> songID;

    @FXML
    private TableColumn<Song, Integer> releaseYear;

    @FXML
    private TableView<Song> tableView;

    @FXML
    void createSongScene(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"create-song-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //configure columns to connect to specific methods in the song class

        songID.setCellValueFactory(new PropertyValueFactory<Song,Integer>("songID"));
        name.setCellValueFactory(new PropertyValueFactory<Song,String>("name"));
        genre.setCellValueFactory(new PropertyValueFactory<Song,String>("genre"));
        length.setCellValueFactory(new PropertyValueFactory<Song,Integer>("length"));
        artist.setCellValueFactory(new PropertyValueFactory<Song,String>("artist"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<Song,Integer>("releaseYear"));


        tableView.getItems().addAll(DBUtility.getSongsFromDB());
    }
}
