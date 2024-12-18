package ctrlfit.conexao;

import ctrlfit.entity.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    Connection conexao;

    public ResultSet autenticarUsuario(Usuario objUsuario) {
        conexao = ConexaoDAO.conectarBD();
        try {
            String sql = "SELECT * FROM usuario_sistema WHERE Nome_Usuario = ? AND Senha_Usuario = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objUsuario.getNome_usuario());
            pstm.setString(2, objUsuario.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO [ERRO]: " + erro);
            return null;
        }
    }

}
