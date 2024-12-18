package ctrlfit.excel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportarExcel {

    // Método para exportar os dados de uma JTable para um arquivo Excel
    public void exportar(JTable tabela) {
        // Abrir uma janela para o usuário escolher onde salvar o arquivo
        JFileChooser seletorArquivo = new JFileChooser();
        // Filtro para permitir apenas arquivos Excel com extensão .xlsx
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Excel (.xlsx)", "xlsx");
        seletorArquivo.setFileFilter(filtro);
        seletorArquivo.setDialogTitle("Salvar arquivo");
        seletorArquivo.setAcceptAllFileFilterUsed(false);

        // Verifica se o usuário clicou em "Salvar"
        if (seletorArquivo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Captura o caminho e nome do arquivo, adicionando a extensão .xlsx
            String caminho = seletorArquivo.getSelectedFile().toString().concat(".xlsx");
            try {
                File arquivoExcel = new File(caminho);
                // Se o arquivo já existir, ele será deletado
                if (arquivoExcel.exists()) {
                    arquivoExcel.delete();
                }
                // Criar o novo arquivo Excel
                arquivoExcel.createNewFile();

                // Criar o objeto Workbook para arquivos .xlsx
                Workbook planilha = new XSSFWorkbook();
                FileOutputStream arquivoSaida = new FileOutputStream(arquivoExcel);
                // Criar uma aba na planilha chamada "Minha planilha 1"
                Sheet aba = planilha.createSheet("Minha planilha 1");
                // Mostrar as linhas de grade na planilha
                aba.setDisplayGridlines(true);

                // Escrever os nomes das colunas da JTable na primeira linha da planilha
                for (int linha = 0; linha < tabela.getRowCount(); linha++) {
                    Row linhaPlanilha = aba.createRow(linha);
                    for (int coluna = 0; coluna < tabela.getColumnCount(); coluna++) {
                        Cell celula = linhaPlanilha.createCell(coluna);
                        if (linha == 0) {
                            // Na primeira linha, colocar os nomes das colunas da tabela
                            celula.setCellValue(tabela.getColumnName(coluna));
                        }
                    }
                }

                // Preencher os dados da tabela na planilha a partir da segunda linha
                int inicioLinha = 1;
                for (int linha = 0; linha < tabela.getRowCount(); linha++) {
                    Row linhaPlanilha = aba.createRow(inicioLinha);
                    inicioLinha++;
                    for (int coluna = 0; coluna < tabela.getColumnCount(); coluna++) {
                        Cell celula = linhaPlanilha.createCell(coluna);
                        // Verifica o tipo de dado para evitar erros de conversão
                        if (tabela.getValueAt(linha, coluna) instanceof Double) {
                            celula.setCellValue(Double.parseDouble(tabela.getValueAt(linha, coluna).toString()));
                        } else if (tabela.getValueAt(linha, coluna) instanceof Float) {
                            celula.setCellValue(Float.parseFloat(tabela.getValueAt(linha, coluna).toString()));
                        } else {
                            celula.setCellValue(String.valueOf(tabela.getValueAt(linha, coluna)));
                        }
                    }
                }

                // Gravar os dados no arquivo e fechar o fluxo de saída
                planilha.write(arquivoSaida);
                arquivoSaida.close();

                // Abrir o arquivo Excel automaticamente no programa padrão do sistema
                Desktop.getDesktop().open(arquivoExcel);

            } catch (IOException | NumberFormatException e) {
                // Exibir uma mensagem de erro caso ocorra alguma exceção
                JOptionPane.showMessageDialog(null, "Erro ao exportar: " + e.getMessage());
            }
        }
    }

}
