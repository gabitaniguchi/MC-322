package lab02.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.beans.value.ObservableValue;
import lab02.model.Evento;
import lab02.data.EventoRepository;;

public class EventListController {

    @FXML
    private ListView<Evento> eventoListView;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private Label precoLabel;

    private ObservableList<Evento> eventos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        eventos = EventoRepository.definirEventos();
        eventoListView.setItems(eventos);
        
        eventoListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Evento evento, boolean empty) {
                super.updateItem(evento, empty);
                if (empty || evento == null) {
                    setText(null);
                } else {
                    setText(evento.getNome());
                    setStyle("-fx-alignment: center;");
                }
            }
        });

        eventoListView.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Evento> obs, Evento oldVal, Evento newVal) -> mostrarDetalhes(newVal)
        );
    }

    private void mostrarDetalhes(Evento evento) {
        if (evento != null) {
            nomeLabel.setText("Nome: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            precoLabel.setText("Preço: R$ " + evento.getPrecoIngresso());
        } else {
            nomeLabel.setText("Nome:");
            dataLabel.setText("Data:");
            localLabel.setText("Local:");
            precoLabel.setText("Preço:");
        }
    }

    @FXML
    private void handleComprarIngresso(ActionEvent event) {
        System.out.println("E");
    }


    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            // Carrega a nova cena do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    
}
