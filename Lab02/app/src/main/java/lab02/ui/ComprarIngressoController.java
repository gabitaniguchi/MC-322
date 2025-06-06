package lab02.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab02.data.MarketplaceRepository;
import lab02.model.Cliente;
import lab02.model.Evento;
import lab02.model.Marketplace;
import lab02.model.OfertaIngresso;
import lab02.model.Cliente.SaldoInsuficienteException;
import javafx.scene.control.Alert;

public class ComprarIngressoController {

    @FXML
    private Label saldoLabel;

    @FXML
    private Label eventoLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private Label precoLabel;

    @FXML
    private TextField precoIngresso;

    @FXML
    private Label messageLabel;

    private OfertaIngresso oferta;

    public void setOferta(OfertaIngresso oferta){
        this.oferta = oferta;
        mostrarDetalhes();
    }

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado(); 
        saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
    }

    private void mostrarDetalhes() {
        Evento evento = oferta.getIngresso().getEvento();
        eventoLabel.setText("Evento: " + evento.getNome());
        dataLabel.setText("Data: " + evento.getData());
        localLabel.setText("Local: " + evento.getLocal().getNome());
        precoLabel.setText("Preco: " + oferta.getPrecoPedido());
    }

    @FXML
    private void handleConfirmarCompra(ActionEvent event) {
        String pagamento = precoIngresso.getText();
        String valorIngresso = Double.toString(oferta.getPrecoPedido());
        if(!pagamento.equals(valorIngresso)){
            messageLabel.setText("Insira o valor correto");
            return;
        }

        try{
            Cliente comprador = Sessao.getClienteLogado();
            Marketplace marketplace = MarketplaceRepository.getMarketplace();

            if(comprador.getSaldo() < oferta.getPrecoPedido()){
                throw new SaldoInsuficienteException("Saldo Insuficiente");
            }
            
            // se é uma oferta oficial, só preciso pagar corretamente
            if(oferta.getOficial()) {
                comprador.comprarIngressoOficial(oferta);
            }

            else
                comprador.comprarIngressoNoMarketplace(oferta, marketplace);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OfertasMarketplace.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);
            OfertasMarketplaceController controller = loader.getController();
            controller.atualizarOfertas();

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (SaldoInsuficienteException e) {
        
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro na compra");
            alert.setHeaderText(null);
            alert.setContentText("Saldo Insuficiente");

            Label contentLabel = new Label("Saldo Insuficiente");
            contentLabel.setStyle("-fx-alignment: center; -fx-text-alignment: center;");
            contentLabel.setWrapText(true);
            alert.getDialogPane().setContent(contentLabel);
            alert.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace(); 
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
