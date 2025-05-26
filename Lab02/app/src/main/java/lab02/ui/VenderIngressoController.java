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
import lab02.model.Ingresso;

public class VenderIngressoController {

    @FXML
    private Label saldoLabel;

    @FXML
    private Label eventoLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Label localLabel;

    @FXML
    private TextField precoVenda;


    private Ingresso ingresso;

    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
        mostrarDetalhes();
    }

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado(); 
        saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
    }

    private void mostrarDetalhes() {
        Evento evento = ingresso.getEvento();
        eventoLabel.setText("Evento: " + evento.getNome());
        dataLabel.setText("Data: " + evento.getData());
        localLabel.setText("Local: " + evento.getLocal().getNome());
    
    }

    @FXML
    private void handleConfirmarVenda(ActionEvent event) {
        double precoPedido = Double.parseDouble(precoVenda.getText());
        Cliente vendedor = Sessao.getClienteLogado();
        ingresso.setVendendo(true);
        
        MarketplaceRepository.getMarketplace().receberOferta(ingresso, precoPedido , vendedor, false);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeusIngressos.fxml"));
        Scene newScene = new Scene(loader.load(), 800, 600);

        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        }catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    
}
