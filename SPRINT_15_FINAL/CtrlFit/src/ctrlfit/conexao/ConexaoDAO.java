package ctrlfit.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    public static Connection conectarBD() {
        Connection conexao = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/ctrl_fit";
            String USER = "root";
            String PASSWORD = "";

            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o Banco de Dados realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o Banco de Dados.");
        }
        return conexao;
    }

}
