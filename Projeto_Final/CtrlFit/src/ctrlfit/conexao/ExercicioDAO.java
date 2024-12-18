package ctrlfit.conexao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ctrlfit.entity.Aluno;
import ctrlfit.entity.Exercicio;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ExercicioDAO {

    Connection conexao;

    public void cadastrarExercicio(Exercicio exercicio) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "INSERT INTO treino (Aluno_Matricula_Aluno, Divisao_Treino, Nome_Treino, QuantSeries_Treino, QuantRepeticoes_Treino, Observacoes_Treino) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar a instrução SQL de inserção
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setInt(1, exercicio.getMatricula());
            st.setString(2, String.valueOf(exercicio.getDivisaoTreino()));
            st.setString(3, exercicio.getNome());
            st.setInt(4, exercicio.getQuantSeries());
            st.setInt(5, exercicio.getQuantRepeticoes());
            st.setString(6, exercicio.getObservacoes());

            // Executar o INSERT
            st.executeUpdate();

            //JOptionPane.showMessageDialog(null, "valor do codigo atual ao cadastrar: "+ exercicio.getCodigo());
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Exercicio exibirExercicio(Exercicio exercicio) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "SELECT * FROM treino WHERE Codigo_Treino = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, exercicio.getCodigo());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                exercicio.setMatricula(rs.getInt("Aluno_Matricula_Aluno"));
                exercicio.setDivisaoTreino(rs.getString("Divisao_Treino").charAt(0));
                exercicio.setNome(rs.getString("Nome_Treino"));
                exercicio.setQuantSeries(rs.getInt("QuantSeries_Treino"));
                exercicio.setQuantRepeticoes(rs.getInt("QuantRepeticoes_Treino"));
                exercicio.setObservacoes(rs.getString("Observacoes_Treino"));
            }
            return exercicio;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExercicioDAO [ERRO]: " + e);
            return null;
        }
    }

    public void alterarExercicio(Exercicio exercicio) {
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "UPDATE treino SET Aluno_Matricula_Aluno = ?, Divisao_Treino = ?, Nome_Treino = ?, QuantSeries_Treino = ?, QuantRepeticoes_Treino = ?, Observacoes_Treino = ? WHERE Codigo_Treino = ?";

            // Preparar a instrução SQL
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setInt(1, exercicio.getMatricula());
            st.setString(2, String.valueOf(exercicio.getDivisaoTreino()));
            st.setString(3, exercicio.getNome());
            st.setInt(4, exercicio.getQuantSeries());
            st.setInt(5, exercicio.getQuantRepeticoes());
            st.setString(6, exercicio.getObservacoes());
            st.setInt(7, exercicio.getCodigo());

            // Executar o UPDATE
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void excluirExercicio(Exercicio exercicio) {
        try {
            conexao = new ConexaoDAO().conectarBD();
            String sql = "DELETE FROM treino WHERE Codigo_Treino = ?";
            PreparedStatement st = conexao.prepareStatement(sql);

            // Define o valor para o parâmetro (codigo_contato)
            st.setInt(1, exercicio.getCodigo());

            // Executar o DELETE
            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ExercicioDAO [ERRO]: " + e);
        }
    }

    public boolean verificarMatriculaExistente(int matricula) {
        boolean existe = false;
        try {
            //estabelecer a conexão com o banco de dados
            conexao = new ConexaoDAO().conectarBD();

            String sql = "SELECT COUNT(*) FROM aluno WHERE Matricula_Aluno = ?";

            // Preparar a instrução SQL de inserção
            PreparedStatement st = conexao.prepareStatement(sql);

            // Definir os valores dos parâmetros
            st.setInt(1, matricula);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Verifica se a matrícula existe
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return existe;
    }

    public void emitirTreino(Aluno objAluno) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("FichaDeTreino.pdf"));
            document.open();

            // Criando a fonte em negrito
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

            // Adicionando o título
            Paragraph titulo = new Paragraph("FICHA DE TREINO", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER); // Centraliza o título
            document.add(titulo);

            // Adicionando a data, a matricula e o nome
            // Formatar a data para o padrão "09/11/2024" e alinhar à direita
            Date data = new Date();
            //DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            //document.add(new Paragraph("Emissão: " + formatador.format(data)));
            Paragraph dataEmissao = new Paragraph("Emissão: " + formatador.format(data));
            dataEmissao.setAlignment(Element.ALIGN_RIGHT); // Alinhamento à direita
            document.add(dataEmissao);

            // Adicionando a matrícula do aluno
            document.add(new Paragraph("Matrícula do aluno(a): " + objAluno.getMatricula()));
            // Adicionando o nome do aluno
            document.add(new Paragraph("Nome do aluno(a): " + objAluno.getNome()));
            document.add(new Paragraph(" "));// Pular linha

            // Conectar ao banco de dados
            conexao = new ConexaoDAO().conectarBD();
            int matriculaAluno = objAluno.getMatricula();

            // Consulta para obter os dados do treino
            String sql = "SELECT Divisao_Treino, Nome_Treino, QuantSeries_Treino, QuantRepeticoes_Treino, Observacoes_Treino FROM treino WHERE Aluno_Matricula_Aluno = ? ORDER BY Divisao_Treino";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, matriculaAluno);
            ResultSet rs = st.executeQuery();

            // Variáveis para controlar o treino atual
            String treinoAtual = "";

            // Criar tabela fora do laço
            PdfPTable tabela = null;

            // Adiciona as linhas da tabela
            while (rs.next()) {
                String divisaoTreino = rs.getString("Divisao_Treino");
                String nomeTreino = rs.getString("Nome_Treino");
                String quantSeries = rs.getString("QuantSeries_Treino");
                String quantRepeticoes = rs.getString("QuantRepeticoes_Treino");
                String observacoes = rs.getString("Observacoes_Treino");

                // Se a divisão do treino mudar, adicione um novo título de treino e uma nova tabela
                if (!treinoAtual.equals(divisaoTreino)) {
                    if (!treinoAtual.isEmpty()) {
                        document.add(tabela); // Adiciona a tabela anterior ao documento
                        document.add(new Paragraph(" ")); // Espaço entre os treinos
                    }

                    // Atualiza o treino atual
                    treinoAtual = divisaoTreino;

                    // Adiciona o título do treino
                    Paragraph tituloTreino = new Paragraph("Treino: " + divisaoTreino, fontTitulo);
                    tituloTreino.setSpacingBefore(10); // Espaço antes do título do treino
                    tituloTreino.setSpacingAfter(5);  // Espaço após o título do treino
                    document.add(tituloTreino);

                    // Cria uma nova tabela para o novo treino
                    tabela = new PdfPTable(4); // Número de colunas ajustado para 4
                    tabela.setWidthPercentage(100);

                    // Criar a fonte em negrito para o título das colunas
                    Font fontTituloColuna = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

                    // Adiciona os títulos das colunas com negrito e cor de fundo
                    PdfPCell cellExercicio = new PdfPCell(new Phrase("Exercício"));
                    PdfPCell cellSeries = new PdfPCell(new Phrase("Séries"));
                    PdfPCell cellRepeticoes = new PdfPCell(new Phrase("Repetições"));
                    PdfPCell cellObservacoes = new PdfPCell(new Phrase("Observações"));

                    // Define a cor de fundo para os títulos das colunas
                    BaseColor headerColor = new BaseColor(220, 220, 220); // cor cinza claro
                    cellExercicio.setBackgroundColor(headerColor);
                    cellSeries.setBackgroundColor(headerColor);
                    cellRepeticoes.setBackgroundColor(headerColor);
                    cellObservacoes.setBackgroundColor(headerColor);

                    // Adiciona os títulos das colunas
                    tabela.addCell(cellExercicio);
                    tabela.addCell(cellSeries);
                    tabela.addCell(cellRepeticoes);
                    tabela.addCell(cellObservacoes);
                }

                // Adiciona os dados do exercício na tabela
                tabela.addCell(nomeTreino);
                tabela.addCell(quantSeries);
                tabela.addCell(quantRepeticoes);
                tabela.addCell(observacoes);
            }

            // Adiciona a última tabela ao documento
            if (tabela != null) {
                document.add(tabela);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            document.close();
        }

        // Abrir o pdf automaticamente no leitor padrão do sistema
        try {
            Desktop.getDesktop().open(new File("FichaDeTreino.pdf"));
        } catch (Exception e2) {
            System.out.println("Erro: " + e2.getMessage());
        }
    }

}
