package ctrlfit.conexao;

import ctrlfit.entity.Aluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AlunoDAO {

    Connection conexao;

    public void cadastrarAluno(Aluno objAluno) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "INSERT INTO aluno (Cpf_Aluno, Nome_Aluno, DtNascimento_Aluno,"
                    + " Sexo_Aluno, Endereco_Aluno, Bairro_Aluno,"
                    + " Cep_Aluno, Telefone_Aluno, Celular_Aluno, Email_Aluno)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Definir os valores dos parâmetros
            pstm.setString(1, objAluno.getCpf());
            pstm.setString(2, objAluno.getNome());

            //pstm.setDate(3, (Date) objAluno.getDtNascimento());
            Date dataSql = new Date(objAluno.getDtNascimento().getTime());
            pstm.setDate(3, dataSql);

            pstm.setString(4, String.valueOf(objAluno.getSexo()));
            pstm.setString(5, objAluno.getEndereco());
            pstm.setString(6, objAluno.getBairro());
            pstm.setString(7, objAluno.getCep());
            pstm.setString(8, objAluno.getTelefone());
            pstm.setString(9, objAluno.getCelular());
            pstm.setString(10, objAluno.getEmail());

            // Executar o INSERT
            int linhaAfetada = pstm.executeUpdate();

            // Verificar se a inserção foi bem-sucedida
            if (linhaAfetada > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                while (rs.next()) {
                    int matricula = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! \nMatrícula Gerada: " + matricula);
                    //txtMatriculaAluno.setText(String.valueOf(matricula));
                    objAluno.setMatricula(matricula);
                }

                //realiza o cadastro de pagamento
                String sql2 = "INSERT INTO pagamento (Aluno_Matricula_Aluno, NomeAluno_Pagamento, Situacao_Aluno)"
                        + " VALUES (?, ?, ?)";

                // Preparar a instrução SQL de inserção
                PreparedStatement pstm2 = conexao.prepareStatement(sql2);

                // Definir os valores dos parâmetros
                pstm2.setInt(1, objAluno.getMatricula());
                pstm2.setString(2, objAluno.getNome());
                pstm2.setString(3, "Pendente");

                pstm2.executeUpdate();
            } else {
                System.out.println("Nenhuma linha foi afetada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO [ERRO]: " + e);
        }
    }

    public Aluno exibirAluno(Aluno objAluno) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "SELECT * FROM aluno WHERE Matricula_Aluno = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objAluno.getMatricula());
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                objAluno.setCpf(rs.getString("Cpf_Aluno"));
                objAluno.setNome(rs.getString("Nome_Aluno"));
                objAluno.setDtNascimento(rs.getDate("DtNascimento_Aluno"));
                objAluno.setSexo(rs.getString("Sexo_Aluno").charAt(0));
                objAluno.setEndereco(rs.getString("Endereco_Aluno"));
                objAluno.setBairro(rs.getString("Bairro_Aluno"));
                objAluno.setCep(rs.getString("Cep_Aluno"));
                objAluno.setTelefone(rs.getString("Telefone_Aluno"));
                objAluno.setCelular(rs.getString("Celular_Aluno"));
                objAluno.setEmail(rs.getString("Email_Aluno"));
            }
            return objAluno;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO [ERRO]: " + e);
            return null;
        }
    }

    public void alterarAluno(Aluno objAluno) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "UPDATE aluno SET Cpf_Aluno = ?, Nome_Aluno = ?, DtNascimento_Aluno = ?,"
                    + " Sexo_Aluno = ?, Endereco_Aluno = ?, Bairro_Aluno = ?,"
                    + " Cep_Aluno = ?, Telefone_Aluno = ?, Celular_Aluno = ?,"
                    + " Email_Aluno = ? WHERE Matricula_Aluno = ?";

            // Preparar a instrução SQL
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setString(1, objAluno.getCpf());
            st.setString(2, objAluno.getNome());

            Date dataSql = new Date(objAluno.getDtNascimento().getTime());
            st.setDate(3, dataSql);

            st.setString(4, String.valueOf(objAluno.getSexo()));
            st.setString(5, objAluno.getEndereco());
            st.setString(6, objAluno.getBairro());
            st.setString(7, objAluno.getCep());
            st.setString(8, objAluno.getTelefone());
            st.setString(9, objAluno.getCelular());
            st.setString(10, objAluno.getEmail());
            st.setInt(11, objAluno.getMatricula());

            // Executar o UPDATE
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");

            //atualizar nome na tabela pagamento
            String sql2 = "UPDATE pagamento SET NomeAluno_Pagamento = ? WHERE Aluno_Matricula_Aluno = ?";

            // Preparar a instrução SQL
            PreparedStatement st2 = conexao.prepareStatement(sql2);

            // Definir os valores dos parâmetros
            st2.setString(1, objAluno.getNome());
            st2.setInt(2, objAluno.getMatricula());

            st2.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO [ERRO]: " + e);
        }
    }

    public void excluirAluno(Aluno objAluno) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            //excluir primeiro o pagamento do aluno
            String sqlExcluirPagamento = "DELETE FROM pagamento WHERE Aluno_Matricula_Aluno = ?";
            PreparedStatement stExcluirPagamento = conexao.prepareStatement(sqlExcluirPagamento);

            // Define o valor para o parâmetro
            stExcluirPagamento.setInt(1, objAluno.getMatricula());

            // Executar o DELETE
            stExcluirPagamento.executeUpdate();

            //--------------
            //excluir primeiro o treino do aluno
            String sqlExcluirTreino = "DELETE FROM treino WHERE Aluno_Matricula_Aluno = ?";
            PreparedStatement stExcluirTreino = conexao.prepareStatement(sqlExcluirTreino);

            // Define o valor para o parâmetro
            stExcluirTreino.setInt(1, objAluno.getMatricula());

            // Executar o DELETE
            stExcluirTreino.executeUpdate();

            //excluir aluno----------------------------------------------
            String sqlExcluirAluno = "DELETE FROM aluno WHERE Matricula_Aluno = ?";
            PreparedStatement stExcluirAluno = conexao.prepareStatement(sqlExcluirAluno);

            // Define o valor para o parâmetro (codigo_contato)
            stExcluirAluno.setInt(1, objAluno.getMatricula());

            // Executar o DELETE
            stExcluirAluno.executeUpdate();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AlunoDAO [ERRO]: " + e);
        }
    }

    public boolean verificarCpf(Aluno objAluno, boolean modoAlterar) {
        conexao = ConexaoDAO.conectarBD();
        boolean cpfCadastrado = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql;

            if (modoAlterar) {
                // Verificação para alteração (ignora a matrícula do próprio aluno)
                sql = "SELECT COUNT(*) FROM aluno WHERE Cpf_Aluno = ? AND Matricula_Aluno != ?";
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, objAluno.getCpf());
                pstm.setInt(2, objAluno.getMatricula());
            } else {
                // Verificação para cadastro
                sql = "SELECT COUNT(*) FROM aluno WHERE Cpf_Aluno = ?";
                pstm = conexao.prepareStatement(sql);
                pstm.setString(1, objAluno.getCpf());
            }

            rs = pstm.executeQuery();

            // Verificar se o CPF já está cadastrado
            if (rs.next() && rs.getInt(1) > 0) {
                cpfCadastrado = true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "AlunoDAO [ERRO]: " + erro);
        }
        return cpfCadastrado;
    }

    public void atualizarSituacaoAlunos() {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "SELECT Aluno_Matricula_Aluno, DtFim_Aluno FROM pagamento";
            PreparedStatement st = conexao.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            String updateSql = "UPDATE pagamento SET Situacao_Aluno = ? WHERE Aluno_Matricula_Aluno = ?";
            PreparedStatement updateSt = conexao.prepareStatement(updateSql);

            java.util.Date dataAtual = new java.util.Date();  // Data atual do sistema

            while (rs.next()) {
                int matricula = rs.getInt("Aluno_Matricula_Aluno");
                java.util.Date dtFimAluno = rs.getDate("DtFim_Aluno");

                String situacao = "";
                // Se DtFim_Aluno for nula, define a situação como "Pendente"
                if (dtFimAluno == null) {
                    situacao = "Pendente";
                } else {
                    // Verifica se DtFim_Aluno é maior ou igual à data atual
                    if (!dtFimAluno.before(dataAtual)) {
                        situacao = "Ativa";  // Se a data de fim for igual ou maior que a data atual, está ativa
                    } else {
                        // Se a data de fim for menor que a data atual, marca como "Pendente"
                        situacao = "Pendente";

                        // Verifica se a diferença entre a data atual e DtFim_Aluno é maior ou igual a 6 meses
                        Calendar calendario = Calendar.getInstance();
                        calendario.setTime(dtFimAluno);
                        calendario.add(Calendar.MONTH, 6);  // Adiciona 6 meses à DtFim_Aluno

                        java.util.Date seisMesesAposDtFim = calendario.getTime();

                        if (dataAtual.after(seisMesesAposDtFim) || dataAtual.equals(seisMesesAposDtFim)) {
                            situacao = "Encerrada";  // Se já passaram 6 meses ou mais, a situação é "Encerrada"
                        }
                    }
                }
                // Atualizar a situação do aluno
                updateSt.setString(1, situacao);
                updateSt.setInt(2, matricula);
                updateSt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar situação dos alunos: " + e.getMessage());
        }
    }

}
