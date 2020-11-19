package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private ListView<String> listView;

    ObservableList<String> wordList = FXCollections.observableArrayList("Привет","Жмых");

    @FXML
    public void initialize(){
        listView.setItems(wordList);
    }

    @FXML
    public void addMassageToList(){
        String massage = textField.getText();
        if (!massage.isBlank()) {
            listView.getItems().add(massage);
        }
        textField.setText("");
    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    @FXML
        public void help(){
        String warning = "Сам себе не поможешь никто не поможет";
        listView.getItems().add(warning);
    }
}
