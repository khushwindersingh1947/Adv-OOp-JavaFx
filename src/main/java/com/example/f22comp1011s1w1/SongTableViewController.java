package com.example.f22comp1011s1w1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class SongTableViewController {

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
    private TableView<Song> tableView;

    @FXML
    void createSongScene(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event,"create-song-view.fxml");
    }

}
