package ctrlfit.conexao;

import ctrlfit.entity.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class PagamentoDAO {

    Connection conexao;

    public void registrarPagamento(Pagamento pagamento) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "UPDATE pagamento SET Aluno_Matricula_Aluno = ?, NomeAluno_Pagamento = ?, Plano_Pagamento = ?,"
                    + " Preco_Pagamento = ?, Forma_Pagamento = ?, Dt_Pagamento = ?,"
                    + " DtInicio_Aluno = ?, DtFim_Aluno = ?, Situacao_Aluno = ? WHERE Aluno_Matricula_Aluno = ?";

            // Preparar a instrução SQL
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setInt(1, pagamento.getMatricula());
            st.setString(2, pagamento.getNome());
            st.setString(3, pagamento.getPlano());
            st.setDouble(4, pagamento.getPreco());
            st.setString(5, pagamento.getForma());

            //st.setDate(6, (Date) pagamento.getDtPagamento());
            //------------------------------------------------------------------
            //pagamento.getDtPagamento() retorna um java.util.Date
            Date dataUtil = pagamento.getDtPagamento();

            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                st.setDate(6, dataSql);
            } else {
                st.setNull(6, java.sql.Types.DATE);
            }
            //------------------------------------------------------------------

            //st.setDate(7, (Date) pagamento.getDtInicio());
            dataUtil = pagamento.getDtInicio();

            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                st.setDate(7, dataSql);
            } else {
                st.setNull(7, java.sql.Types.DATE);
            }

            //st.setDate(8, (Date) pagamento.getDtFim());
            dataUtil = pagamento.getDtFim();

            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                st.setDate(8, dataSql);
            } else {
                st.setNull(8, java.sql.Types.DATE);
            }

            st.setString(9, pagamento.getSituacao());
            st.setInt(10, pagamento.getMatricula());

            // Executar o UPDATE
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
