package lab02.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lab02.model.Cliente;

public class VenderIngressoController {

    @FXML
    private Label saldoLabel;

    @FXML
    public void initialize() {
        Cliente cliente = Sessao.getClienteLogado(); 
        if (cliente != null) {
            saldoLabel.setText("R$ " + String.format("%.2f", cliente.getSaldo()));
        } else {
            saldoLabel.setText("Cliente não logado");
        }
    }

    
}
