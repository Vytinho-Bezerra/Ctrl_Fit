package ctrlfit.main;

import ctrlfit.conexao.ConexaoDAO;
import java.sql.Connection;
import ctrlfit.telas.Login;

public class Main {

    public static void main(String[] args) {

        ConexaoDAO conexaoDAO = new ConexaoDAO();
        Connection conexao = conexaoDAO.conectarBD();

        if (conexao != null) {
            System.out.println("Teste de conexão bem-sucedido.");
        } else {
            System.out.println("Teste de conexão falhou.");
        }

        Login login = new Login();
        login.setVisible(true);

    }
}
