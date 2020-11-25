package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.EchoClient;
import sample.Network;

import java.io.IOException;


public class Controller {

    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    private Network network;
    EchoClient echoClient;

    @FXML
    public void initialize() {
        sendButton.setOnAction(event -> Controller.this.sendMessage());
        textField.setOnAction(event -> Controller.this.sendMessage());
    }

    private void sendMessage() {
        String message = textField.getText();
        appendMessage(message);
        textField.clear();

        try {
            network.getDataOutputStream().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Ошибка при отправке сообщения";
            EchoClient.showErrorMessage(e.getMessage(), errorMessage);
        }

    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }

    @FXML
    public void newDialog() {
        echoClient.showDialog();
    }

    public void setEchoClient(EchoClient echoClient) {
        this.echoClient = echoClient;
    }
}
