package lab02.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import lab02.model.Ingresso;
import lab02.model.Cliente;
import lab02.model.Evento;

public class MeusIngressosController {

    @FXML
    private ListView<Ingresso> ingressosListView;

    @FXML
    private Label eventoLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private Label precoLabel;

    private ObservableList<Ingresso> ingressos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado();

        if (cliente != null) {
            ingressos.addAll(cliente.getIngressos());
            ingressosListView.setItems(ingressos);

            ingressosListView.setCellFactory(listView -> new ListCell<>() {
                @Override
                protected void updateItem(Ingresso ingresso, boolean empty) {
                    super.updateItem(ingresso, empty);
                    if (empty || ingresso == null) {
                        setText(null);
                    } else {
                        setText(ingresso.getEvento().getNome());
                        setStyle("-fx-alignment: center;");
                    }
                }
            });

            ingressosListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> mostrarDetalhes(newVal));
        }
    }

    private void mostrarDetalhes(Ingresso ingresso) {
        if (ingresso != null) {
            Evento evento = ingresso.getEvento();
            eventoLabel.setText("Evento: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            precoLabel.setText("Preço: R$ " + ingresso.getPreco());
        } else {
            eventoLabel.setText("Evento:");
            dataLabel.setText("Data:");
            localLabel.setText("Local: ");
            precoLabel.setText("Preço:");
        }
    }

    @FXML
    private void handleVenderIngresso(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VenderIngresso.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
    
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        }catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }


    @FXML
    private void handleVoltar(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Scene newScene = new Scene(loader.load(), 800, 600);

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        }catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

}
