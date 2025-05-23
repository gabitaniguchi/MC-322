package lab02.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lab02.model.Cliente;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MainWindowController {

    @FXML
    private Label nomeClienteLabel;

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado();
        if (cliente != null) {
            nomeClienteLabel.setText("Bem-vindo, " + cliente.getNome());
        } else {
            nomeClienteLabel.setText("Bem-vindo");
        }
    }

    @FXML
    private void handleVisualizarEventos(ActionEvent event) {
        try {
            // Carrega a nova cena do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventList.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    @FXML
    private void handleMeusIngressos(ActionEvent event) {
        try {
            // Carrega a nova cena do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MeusIngressos.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    @FXML
    private void handleSair(ActionEvent event) {
        try {
            // desloga o usuário
            Sessao.limpar();
            // Carrega a nova cena do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }
}
