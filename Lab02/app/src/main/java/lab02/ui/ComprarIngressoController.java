package lab02.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lab02.model.Cliente;
import lab02.model.Evento;
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

    private Evento evento;

    public void setEvento(Evento evento){
        this.evento = evento;
        mostrarDetalhes();
    }

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado(); 
        saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
    }

    private void mostrarDetalhes() {
        eventoLabel.setText("Evento: " + evento.getNome());
        dataLabel.setText("Data: " + evento.getData());
        localLabel.setText("Local: " + evento.getLocal().getNome());
        precoLabel.setText("Preco: " + evento.getPrecoIngresso());
    }

    @FXML
    private void handleConfirmarCompra(ActionEvent event) {
        String pagamento = precoIngresso.getText();
        String valorIngresso = Double.toString(evento.getPrecoIngresso());
        if(!pagamento.equals(valorIngresso)){
            messageLabel.setText("Insira o valor correto");
            return;
        }
        // try{
        //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConfirmarVenda.fxml"));
        //     Scene newScene = new Scene(loader.load(), 800, 600);
    
        //     Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        //     stage.setScene(newScene);
        // }catch (IOException ex) {
        //     ex.printStackTrace(); // Para depuração
        // }
        System.out.println("sim");
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
