package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Administrador;


public class ControlAdministrador {
	Connection conn;
	
	public ResultSet autenticacaoAdministrador(Administrador objadministrador) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from administrador where email= ? and senha = ?"; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objadministrador.getEmail());
			pstm.setString(2, objadministrador.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Administrador Control: " + erro);
			return null;
		}
	}

	
	


}
