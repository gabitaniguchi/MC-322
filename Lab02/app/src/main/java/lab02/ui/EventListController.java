package lab02.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import lab02.model.Evento;
import lab02.model.Local;
import lab02.model.Organizadora;

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
        carregarEventos();
        eventoListView.setItems(eventos);
        
        eventoListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Evento evento, boolean empty) {
                super.updateItem(evento, empty);
                if (empty || evento == null) {
                    setText(null);
                } else {
                    setText(evento.getNome());
                }
            }
        });

        eventoListView.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Evento> obs, Evento oldVal, Evento newVal) -> mostrarDetalhes(newVal)
        );
    }

    private void carregarEventos() {
        Local local1 = new Local("Teatro Municipal", 100);
        Local local2 = new Local("Arena Cultural", 300);
        Organizadora org = new Organizadora("Time For Fun (T4F)", 12345, "Faria Lima");

        eventos.add(new Evento("Concerto Clássico", local1, 50.0, org, "2025-06-01"));
        eventos.add(new Evento("Festival de Jazz", local2, 70.0, org, "2025-07-15"));
        eventos.add(new Evento("Peça Teatral", local1, 40.0, org, "2025-08-10"));
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
    
}
