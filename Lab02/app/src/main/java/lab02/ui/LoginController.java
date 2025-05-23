package lab02.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab02.model.Cliente;
import lab02.data.ClienteRepository;
import lab02.data.ClienteRepository.ClienteNaoEncontradoException;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Preencha usuário e senha");
            return;
        }

        // Carregar a próxima cena
        try {
            ClienteRepository.definirClientes();
            Cliente cliente = ClienteRepository.buscarCliente(username);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene mainWindowScene = new Scene(loader.load(), 800, 600);
            
            // passa qual o cliente logado
            Sessao.setClienteLogado(cliente);

            // inicializa a tela com o nome do usuario
            MainWindowController controller = loader.getController();
            controller.initialize();

            // Pega a janela atual para trocar a cena
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(mainWindowScene);


        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Erro ao carregar próxima tela");
        } catch (ClienteNaoEncontradoException e) {
            e.printStackTrace();
            messageLabel.setText("Cliente não encontrado");
        }
    }
}
