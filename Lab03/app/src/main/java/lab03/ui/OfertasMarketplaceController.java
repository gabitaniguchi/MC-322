package lab03.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lab03.data.MarketplaceRepository;
import lab03.model.Evento;
import lab03.model.OfertaIngresso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.beans.value.ObservableValue;

public class OfertasMarketplaceController {

    @FXML
    private ListView<OfertaIngresso> ofertasListView; // Lista que exibe as ofertas disponíveis no marketplace

    @FXML
    private Label nomeLabel;    // Exibe nome do evento da oferta selecionada

    @FXML
    private Label dataLabel;    // Exibe data do evento da oferta selecionada

    @FXML
    private Label localLabel;   // Exibe local do evento da oferta selecionada

    @FXML
    private Label precoLabel;   // Exibe preço pedido da oferta selecionada

    @FXML
    private Label messageLabel; // Exibe mensagens para o usuário (erros, avisos)

    /**
     * Inicializa a tela carregando as ofertas do marketplace
     * e configura o comportamento da ListView.
     */
    @FXML
    public void initialize() {
        // Obtém as ofertas do marketplace e popula a lista observável
        ObservableList<OfertaIngresso> observableOfertas = FXCollections.observableArrayList(
            MarketplaceRepository.getMarketplace().listarOfertas()
        );

        ofertasListView.setItems(observableOfertas);

        // Configura a exibição de cada célula da lista, mostrando o nome do evento
        ofertasListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(OfertaIngresso oferta, boolean empty) {
                super.updateItem(oferta, empty);
                if (empty || oferta == null) {
                    setText(null);
                } else {
                    setText(oferta.getIngresso().getEvento().getNome());
                    setStyle("-fx-alignment: center;");
                }
            }
        });

        // Adiciona um listener para mostrar detalhes da oferta selecionada
        ofertasListView.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends OfertaIngresso> obs, OfertaIngresso oldVal, OfertaIngresso newVal) -> mostrarDetalhes(newVal)
        );
    }

    /**
     * Atualiza a lista de ofertas (exemplo: após alguma alteração).
     */
    @FXML
    public void atualizarOfertas() {
        ObservableList<OfertaIngresso> observableOfertas = FXCollections.observableArrayList(
            MarketplaceRepository.getMarketplace().listarOfertas()
        );
        ofertasListView.setItems(observableOfertas);
    }

    /**
     * Exibe os detalhes da oferta selecionada nos labels.
     */
    private void mostrarDetalhes(OfertaIngresso oferta) {
        Evento evento = oferta.getIngresso().getEvento();
        if (evento != null) {
            nomeLabel.setText("Nome: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            precoLabel.setText("Preço: R$ " + oferta.getPrecoPedido());
        } else {
            // Limpa os campos caso não haja oferta selecionada
            nomeLabel.setText("Nome:");
            dataLabel.setText("Data:");
            localLabel.setText("Local:");
            precoLabel.setText("Preço:");
        }
    }

    /**
     * Ação disparada ao clicar em "Comprar Ingresso".
     * Valida seleção e impede compra do próprio ingresso.
     * Em caso positivo, navega para a tela de compra.
     */
    @FXML
    private void handleComprarIngresso(ActionEvent event) {
        try {
            OfertaIngresso oferta = ofertasListView.getSelectionModel().getSelectedItem();
            if (oferta == null) {
                messageLabel.setText("Selecione o ingresso");
                return;
            }

            // Impede que o usuário compre um ingresso que ele mesmo está vendendo
            if (Sessao.getClienteLogado() == oferta.getVendedor()) {
                messageLabel.setText("Impossível comprar o próprio ingresso");
                return;
            }

            // Carrega a tela de compra de ingresso
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ComprarIngresso.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            ComprarIngressoController controller = loader.getController();
            controller.setOferta(oferta);  // Passa a oferta selecionada para o controller

            // Troca a cena atual para a tela de compra
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException ex) {
            ex.printStackTrace();  
        }
    }

    /**
     * Volta para a tela principal ao clicar em "Voltar".
     */
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
