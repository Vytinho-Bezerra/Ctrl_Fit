package ctrlfit.conexao;

import ctrlfit.entity.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PlanoDAO {

    Connection conexao;

    public void cadastrarPlano(Plano plano) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "INSERT INTO mensalidade_plano (NomeMensalidade_Plano, PrecoMensalidade_Plano, DuracaoMensalidade_Plano, DescricaoMensalidade_Plano) VALUES (?, ?, ?, ?)";

            // Preparar a instrução SQL de inserção
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setString(1, plano.getNome());
            st.setDouble(2, plano.getPreco());
            st.setInt(3, plano.getDuracao());
            st.setString(4, plano.getDescricao());

            // Executar o INSERT
            st.executeUpdate();

            //JOptionPane.showMessageDialog(null, "valor do codigo atual ao cadastrar: "+ exercicio.getCodigo());
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Plano exibirPlano(Plano plano) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "SELECT * FROM mensalidade_plano WHERE CodigoMensalidade_Plano = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, plano.getCodigo());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                plano.setNome(rs.getString("NomeMensalidade_Plano"));
                plano.setPreco(rs.getDouble("PrecoMensalidade_Plano"));
                plano.setDuracao(rs.getInt("DuracaoMensalidade_Plano"));
                plano.setDescricao(rs.getString("DescricaoMensalidade_Plano"));
            }
            return plano;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PlanoDAO [ERRO]: " + e);
            return null;
        }
    }

    public void alterarPlano(Plano plano) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "UPDATE mensalidade_plano SET NomeMensalidade_Plano = ?, PrecoMensalidade_Plano = ?, DuracaoMensalidade_Plano = ?, DescricaoMensalidade_Plano = ? WHERE CodigoMensalidade_Plano = ?";

            // Preparar a instrução SQL
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setString(1, plano.getNome());
            st.setDouble(2, plano.getPreco());
            st.setInt(3, plano.getDuracao());
            st.setString(4, plano.getDescricao());
            st.setInt(5, plano.getCodigo());

            // Executar o UPDATE
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirPlano(Plano plano) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "DELETE FROM mensalidade_plano WHERE CodigoMensalidade_Plano = ?";
            PreparedStatement st = conexao.prepareStatement(sql);

            // Define o valor para o parâmetro (codigo_contato)
            st.setInt(1, plano.getCodigo());

            // Executar o DELETE
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir exercício: " + e.getMessage());
        }
    }

}
