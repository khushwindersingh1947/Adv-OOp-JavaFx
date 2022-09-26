package com.example.f22comp1011s1w1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateSongController implements Initializable {

    @FXML
    private ComboBox<Artist> ArtistComboBox;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private TextField lengthTextField;

    @FXML
    private Spinner<Integer> releaseSpinner;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField songTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Artist artist1 = new Artist("Alfred","Jackson", LocalDate.of(1987,10,11));
        Artist artist2 = new Artist("Jack","Johnson", LocalDate.of(1997,01,8));

        ArtistComboBox.getItems().add(artist1);
        ArtistComboBox.getItems().add(artist2);
        resultLabel.setText("");
        genreComboBox.getItems().addAll(Song.getGenres());

        // this is called lambda expression
        lengthTextField.textProperty().addListener((observableValue, oldV, newV) -> {
            try{
                Integer.parseInt(newV);
            }catch (Exception e){
                lengthTextField.setText(oldV);
            }
        });

    }

    @FXML
    void createSong(ActionEvent event) {

    }

}
