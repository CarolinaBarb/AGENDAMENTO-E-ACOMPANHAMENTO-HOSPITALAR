package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Secretaria;

public class ControlSecretaria {
	Connection conn;
	
	public ResultSet autenticacaoSecretaria(Secretaria objsecretaria) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from secretaria where email= ? and senha = ?"; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objsecretaria.getEmail()); // primeira ? e o email
			pstm.setString(2, objsecretaria.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Secretaria Control: " + erro);
			return null;
		}
	}


}
