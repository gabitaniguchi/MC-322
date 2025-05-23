package lab02.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node; // Import necessário
import java.io.IOException;

public class MainWindowController {

    @FXML
    private void VisualizarEventos(ActionEvent e) {
        try {
            // Carrega a nova cena do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventList.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Pega a janela atual a partir do botão que disparou o evento
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException ex) {
            ex.printStackTrace(); // Para depuração
        }
    }

    @FXML
    private void MeusIngressos(ActionEvent e) {
        System.out.println("Opção 2 selecionada!");
    }

    @FXML
    private void ComprarIngressos(ActionEvent e) {
        System.out.println("Comprar ingressos clicado!");
    }

    @FXML
    private void VenderIngressos(ActionEvent e) {
        System.out.println("Vender ingressos clicado!");
    }
}
