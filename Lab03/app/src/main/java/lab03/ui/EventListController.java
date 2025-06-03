package lab03.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lab03.data.EventoRepository;
import lab03.model.Evento;
import lab03.model.Ingresso;
import lab03.model.OfertaIngresso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.beans.value.ObservableValue;;

/**
 * Controlador da tela de lista de eventos disponíveis.
 * Exibe eventos oficiais e permite a navegação para a tela de compra de ingressos.
 */
public class EventListController {

    @FXML
    private ListView<Evento> eventoListView; // Lista visual dos eventos disponíveis

    @FXML
    private Label nomeLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private Label organizadoraLabel;

    @FXML
    private Label precoLabel;

    @FXML
    private Label messageLabel;

    private ObservableList<Evento> eventos = FXCollections.observableArrayList();

     /**
     * Inicializa a tela carregando eventos e configurando a visualização da lista.
     */
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

        // Adiciona listener para atualizar os detalhes quando um evento for selecionado
        eventoListView.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Evento> obs, Evento oldVal, Evento newVal) -> mostrarDetalhes(newVal)
        );
    }

    /**
     * Mostra os detalhes do evento selecionado.
     * @param evento Evento selecionado na lista
     */
    private void mostrarDetalhes(Evento evento) {
        if (evento != null) {
            nomeLabel.setText("Nome: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            organizadoraLabel.setText("Organizadora: " + evento.getOrganizadora().getNome());
            precoLabel.setText("Preço: R$ " + evento.getPrecoIngresso());
        } else {
            nomeLabel.setText("Nome:");
            dataLabel.setText("Data:");
            localLabel.setText("Local:");
            organizadoraLabel.setText("Organizadora: ");
            precoLabel.setText("Preço:");
        }
    }
    
    /**
     * Trata o clique no botão de comprar ingresso.
     * Cria uma oferta oficial com o evento selecionado e carrega a tela de compra.
     */
    @FXML
    private void handleComprarIngresso(ActionEvent event) {
        try {
            Evento eventoSelecionado = eventoListView.getSelectionModel().getSelectedItem();
            if(eventoSelecionado==null){
                messageLabel.setText("Selecione o evento");
                return;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ComprarIngresso.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            
            // Cria uma oferta oficial (sem revendedor)
            OfertaIngresso oferta = new OfertaIngresso(new Ingresso(eventoSelecionado, eventoSelecionado.getPrecoIngresso()), eventoSelecionado.getPrecoIngresso(),null, true);
            
            // Passa a oferta para o controller da tela de compra
            ComprarIngressoController controller = loader.getController();
            controller.setOferta(oferta);

            // Troca para a nova cena
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    /**
     * Retorna para a tela principal (MainWindow.fxml).
     */
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
