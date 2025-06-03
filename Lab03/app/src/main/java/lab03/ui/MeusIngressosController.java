package lab03.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lab03.model.Cliente;
import lab03.model.Evento;
import lab03.model.Ingresso;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class MeusIngressosController {

    @FXML
    private ListView<Ingresso> ingressosListView;  // Lista para mostrar os ingressos do cliente

    @FXML
    private Label eventoLabel;        // Exibe o nome do evento selecionado

    @FXML
    private Label dataLabel;          // Exibe a data do evento selecionado

    @FXML
    private Label localLabel;         // Exibe o local do evento selecionado

    @FXML
    private Label organizadoraLabel;  // Exibe a organizadora do evento selecionado

    @FXML
    private Label messageLabel;       // Mensagens para o usuário (erros, avisos, etc)

    // Lista observável para os ingressos, que atualiza a ListView automaticamente
    private ObservableList<Ingresso> ingressos = FXCollections.observableArrayList();

    /**
     * Método chamado automaticamente após o carregamento do FXML.
     * Inicializa a lista de ingressos do cliente logado e configura a ListView.
     */
    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado();

        if (cliente != null) {
            // Adiciona todos os ingressos do cliente à lista observável
            ingressos.addAll(cliente.getIngressos());
            ingressosListView.setItems(ingressos);

            // Define como cada ingresso será mostrado na lista (apenas nome do evento centralizado)
            ingressosListView.setCellFactory(listView -> new ListCell<>() {
                @Override
                protected void updateItem(Ingresso ingresso, boolean empty) {
                    super.updateItem(ingresso, empty);
                    if (empty || ingresso == null) {
                        setText(null);
                    } else {
                        setText(ingresso.getEvento().getNome());
                        setStyle("-fx-alignment: center;");
                    }
                }
            });

            // Adiciona um listener para atualizar os detalhes do ingresso selecionado
            ingressosListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> mostrarDetalhes(newVal));
        }
    }

    /**
     * Atualiza os labels com as informações do ingresso selecionado.
     * @param ingresso ingresso selecionado na lista
     */
    private void mostrarDetalhes(Ingresso ingresso) {
        if (ingresso != null) {
            Evento evento = ingresso.getEvento();
            eventoLabel.setText("Evento: " + evento.getNome());
            dataLabel.setText("Data: " + evento.getData());
            localLabel.setText("Local: " + evento.getLocal().getNome());
            organizadoraLabel.setText("Organizadora: " + evento.getOrganizadora().getNome());
        } else {
            // Limpa os labels caso nenhum ingresso esteja selecionado
            eventoLabel.setText("Evento:");
            dataLabel.setText("Data:");
            localLabel.setText("Local: ");
            organizadoraLabel.setText("Organizadora: ");
        }
    }

    /**
     * Método chamado quando o usuário clica no botão "Vender Ingresso".
     * Verifica se um ingresso foi selecionado e se ele já está à venda.
     * Caso esteja tudo certo, abre a tela para colocar o ingresso à venda.
     */
    @FXML
    private void handleVenderIngresso(ActionEvent event) {
        try {
            Ingresso ingressoSelecionado = ingressosListView.getSelectionModel().getSelectedItem();
            if (ingressoSelecionado == null) {
                messageLabel.setText("Selecione o ingresso");
                return;
            }

            if (ingressoSelecionado.getVendendo()) {
                messageLabel.setText("Ingresso já está à venda");
                return;
            }

            // Carrega a tela de venda de ingresso
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VenderIngresso.fxml"));
            Scene newScene = new Scene(loader.load(), 800, 600);

            // Passa o ingresso selecionado para o controlador da tela de venda
            VenderIngressoController controller = loader.getController();
            controller.setIngresso(ingressoSelecionado);

            // Troca a cena atual para a de venda de ingresso
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException ex) {
            ex.printStackTrace(); 
        }
    }

    /**
     * Método chamado ao clicar no botão "Voltar".
     * Retorna para a tela principal.
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
