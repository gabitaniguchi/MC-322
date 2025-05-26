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
import lab02.model.OfertaIngresso;
import lab02.data.MarketplaceRepository;;

public class OfertasMarketplaceController {

    @FXML
    private ListView<OfertaIngresso> ofertasListView;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private Label precoLabel;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        ObservableList<OfertaIngresso> observableOfertas = FXCollections.observableArrayList(MarketplaceRepository.getMarketplace().listarOfertas());

        ofertasListView.setItems(observableOfertas);

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

    ofertasListView.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends OfertaIngresso> obs, OfertaIngresso oldVal, OfertaIngresso newVal) -> mostrarDetalhes(newVal)
    );
    }

    @FXML
    public void atualizarOfertas(){
        ObservableList<OfertaIngresso> observableOfertas = FXCollections.observableArrayList(MarketplaceRepository.getMarketplace().listarOfertas());
        ofertasListView.setItems(observableOfertas);
    }


    private void mostrarDetalhes(OfertaIngresso oferta) {
        Evento evento = oferta.getIngresso().getEvento();
        if (evento != null) {
            nomeLabel.setText("Nome: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            precoLabel.setText("Preço: R$ " + oferta.getPrecoPedido());
        } else {
            nomeLabel.setText("Nome:");
            dataLabel.setText("Data:");
            localLabel.setText("Local:");
            precoLabel.setText("Preço:");
        }
    }

    @FXML
    private void handleComprarIngresso(ActionEvent event) {
        try {
            OfertaIngresso oferta = ofertasListView.getSelectionModel().getSelectedItem();
            if(oferta==null){
                messageLabel.setText("Selecione o ingresso");
                return;
            }

            if(Sessao.getClienteLogado() == oferta.getVendedor()){
                messageLabel.setText("Impossível comprar o próprio ingresso");
                return;
            }
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ComprarIngresso.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            ComprarIngressoController controller = loader.getController();
            controller.setOferta(oferta);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
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
