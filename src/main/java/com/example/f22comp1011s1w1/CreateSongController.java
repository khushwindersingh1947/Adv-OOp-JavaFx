package com.example.f22comp1011s1w1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
            try
            {
                if(!newV.isBlank())
                    Integer.parseInt(newV);
            }catch (Exception e)
            {
                lengthTextField.setText(oldV);
            }
        });

        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.
                IntegerSpinnerValueFactory(1900,LocalDate.now().getYear(),2000);

        releaseSpinner.setValueFactory(spinnerValueFactory);
//        releaseSpinner.setEditable(true);//now we can edit text field, but users can put any non numeric value

        releaseSpinner.getEditor().textProperty().addListener((observableValue, oldV, newV) -> {
                try
                {
                    if(!newV.isBlank())
                        Integer.parseInt(newV);
                }catch (Exception e)
                {
                    releaseSpinner.getEditor().setText(oldV);
                }
        });

    }

    @FXML
    void createSong(ActionEvent event) {
        Song song= new Song(songTextField.getText(),genreComboBox.getValue(),
                releaseSpinner.getValue(),Integer.parseInt(lengthTextField.getText()),ArtistComboBox.getValue());
        resultLabel.setText(song.toString());

    }

}
