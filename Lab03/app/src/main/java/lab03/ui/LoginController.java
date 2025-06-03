package lab03.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab03.data.ClienteRepository;
import lab03.data.ClienteRepository.ClienteNaoEncontradoException;
import lab03.model.Cliente;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * Controlador da tela de login.
 * Permite ao usuário entrar no sistema com nome de usuário e senha.
 */
public class LoginController {

    @FXML
    private TextField usernameField; // Campo para o nome de usuário

    @FXML
    private PasswordField passwordField; // Campo para a senha (ocultada)

    @FXML
    private Label messageLabel; // Mensagem de erro ou status

    /**
     * Trata o clique no botão de login.
     * Valida o usuário e carrega a tela principal se o login for bem-sucedido.
     */
    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText(); // Senha é ignorada nesse exemplo

        // Verifica se os campos estão preenchidos
        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Preencha usuário e senha");
            return;
        }

        try {
            // Inicializa os clientes registrados
            ClienteRepository.definirClientes();

            // Busca o cliente com o nome informado
            Cliente cliente = ClienteRepository.buscarCliente(username);

            // Define o cliente como logado na sessão
            Sessao.setClienteLogado(cliente);

            // Carrega a tela principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Scene mainWindowScene = new Scene(loader.load(), 800, 600);

            // Inicializa o controller da tela principal
            MainWindowController controller = loader.getController();
            controller.initialize();

            // Troca a cena da janela atual
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
