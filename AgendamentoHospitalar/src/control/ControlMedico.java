package control;

import model.Medico;
import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Date;

import javax.swing.JOptionPane;

import util.Dados;
import util.Validar;

public class ControlMedico {
	
	Connection conn;
	

	public ResultSet autenticacaoMedico(Medico medicocontrol) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from Medicos where email_medico = ? and senha_medico = ?"; // mesmo q ta no banco

			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, medicocontrol.getEmail()); // primeira ? e o email
			pstm.setString(2, medicocontrol.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "MedicoControl: " + erro);
			return null;
		}
	}

}
