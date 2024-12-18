package ctrlfit.conexao;

import ctrlfit.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Connection conexao;

    public void cadastrarFuncionario(Funcionario funcionario) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "INSERT INTO funcionario (Nome_Func, Cargo_Func, Cpf_Func,"
                    + " DtNascimento_Func, Telefone_Func, Celular_Func,"
                    + " Endereco_Func, Bairro_Func, Cep_Func, Sexo_Func, Salario_Func,"
                    + " DtAdmissao_Func, Email_Func, Senha_Func, Usuario_Func, Codigo_Usuario)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar a instrução SQL de inserção
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setString(3, funcionario.getCpf());

            //st.setDate(4, (Date) funcionario.getDtNascimento());
            //------------------------------------------------------------------
            //funcionario.getDtNascimento() retorna um java.util.Date
            Date dataUtil = funcionario.getDtNascimento();

            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                st.setDate(4, dataSql);
            } else {
                st.setNull(4, java.sql.Types.DATE);
            }
            //------------------------------------------------------------------

            st.setString(5, funcionario.getTelefone());
            st.setString(6, funcionario.getCelular());
            st.setString(7, funcionario.getEndereco());
            st.setString(8, funcionario.getBairro());
            st.setString(9, funcionario.getCep());
            st.setString(10, String.valueOf(funcionario.getSexo()));
            st.setDouble(11, funcionario.getSalario());

            //st.setDate(12, (Date) funcionario.getDtAdmisao());
            //------------------------------------------------------------------
            //funcionario.getDtAdmisao() retorna um java.util.Date
            Date dataAdmissao = funcionario.getDtAdmissao();

            if (dataAdmissao != null) {
                java.sql.Date dataSql = new java.sql.Date(dataAdmissao.getTime());
                st.setDate(12, dataSql);
            } else {
                st.setNull(12, java.sql.Types.DATE);
            }
            //------------------------------------------------------------------

            st.setString(13, funcionario.getEmail());
            st.setString(14, funcionario.getSenha());
            st.setString(15, funcionario.getUsuario());
            st.setInt(16, 0);

            // Executar o INSERT
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO [ERRO]: " + e);
        }
    }

    public Funcionario exibirFuncionario(Funcionario funcionario) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "SELECT * FROM funcionario WHERE Codigo_Func = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCodigo());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario.setNome(rs.getString("Nome_Func"));
                funcionario.setCargo(rs.getString("Cargo_Func"));
                funcionario.setCpf(rs.getString("Cpf_Func"));
                funcionario.setDtNascimento(rs.getDate("DtNascimento_Func"));
                funcionario.setTelefone(rs.getString("Telefone_Func"));
                funcionario.setCelular(rs.getString("Celular_Func"));
                funcionario.setEndereco(rs.getString("Endereco_Func"));
                funcionario.setBairro(rs.getString("Bairro_Func"));
                funcionario.setCep(rs.getString("Cep_Func"));
                funcionario.setSexo(rs.getString("Sexo_Func").charAt(0));
                funcionario.setSalario(rs.getDouble("Salario_Func"));
                funcionario.setDtAdmissao(rs.getDate("DtAdmissao_Func"));
                funcionario.setEmail(rs.getString("Email_Func"));
                funcionario.setUsuario(rs.getString("Usuario_Func"));
                funcionario.setSenha(rs.getString("Senha_Func"));
            }
            return funcionario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO [ERRO]: " + e);
            return null;
        }
    }

    public void alterarFuncionario(Funcionario funcionario) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "UPDATE funcionario SET Nome_Func = ?, Cargo_Func = ?, Cpf_Func = ?,"
                    + " DtNascimento_Func = ?, Telefone_Func = ?, Celular_Func = ?,"
                    + " Endereco_Func = ?, Bairro_Func = ?, Cep_Func = ?,"
                    + " Sexo_Func = ?, Salario_Func = ?, DtAdmissao_Func = ?, Email_Func = ?,"
                    + " Senha_Func = ?, Usuario_Func = ? WHERE Codigo_Func = ?";

            // Preparar a instrução SQL
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setString(3, funcionario.getCpf());

            //st.setDate(4, (Date) funcionario.getDtNascimento());
            java.util.Date dataUtil = funcionario.getDtNascimento();

            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                st.setDate(4, dataSql);
            } else {
                st.setNull(4, java.sql.Types.DATE);
            }

            st.setString(5, funcionario.getTelefone());
            st.setString(6, funcionario.getCelular());
            st.setString(7, funcionario.getEndereco());
            st.setString(8, funcionario.getBairro());
            st.setString(9, funcionario.getCep());
            st.setString(10, String.valueOf(funcionario.getSexo()));
            st.setDouble(11, funcionario.getSalario());

            //st.setDate(12, (Date) funcionario.getDtAdmisao());
            java.util.Date dataUtilAdmissao = funcionario.getDtAdmissao();

            if (dataUtilAdmissao != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtilAdmissao.getTime());
                st.setDate(12, dataSql);
            } else {
                st.setNull(12, java.sql.Types.DATE);
            }

            st.setString(13, funcionario.getEmail());
            st.setString(14, funcionario.getSenha());
            st.setString(15, funcionario.getUsuario());
            st.setInt(16, funcionario.getCodigo());

            // Executar o UPDATE
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirFuncionario(Funcionario funcionario) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "DELETE FROM funcionario WHERE Codigo_Func = ?";
            PreparedStatement st = conexao.prepareStatement(sql);

            // Define o valor para o parâmetro (codigo_contato)
            st.setInt(1, funcionario.getCodigo());

            // Executar o DELETE
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }

    public boolean verificarCpf(Funcionario funcionario, boolean modoAlterar) {
        conexao = ConexaoDAO.conectarBD();
        boolean cpfCadastrado = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql;

            if (modoAlterar) {
                // Verificação para alteração (ignora o codigo do próprio funcionario)
                sql = "SELECT COUNT(*) FROM funcionario WHERE Cpf_Func = ? AND Codigo_Func != ?";
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, funcionario.getCpf());
                pstm.setInt(2, funcionario.getCodigo());
            } else {
                // Verificação para cadastro
                sql = "SELECT COUNT(*) FROM funcionario WHERE Cpf_Func = ?";
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, funcionario.getCpf());
            }

            rs = pstm.executeQuery();

            // Verificar se o CPF já está cadastrado
            if (rs.next() && rs.getInt(1) > 0) {
                cpfCadastrado = true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO [ERRO]: " + erro);
        }
        return cpfCadastrado;
    }
    
}
