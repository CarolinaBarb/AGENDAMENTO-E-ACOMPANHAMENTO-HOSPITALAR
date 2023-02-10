package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.*;

public class ControlDisponibilidade {
	
	Connection conn;
	PreparedStatement pstm;
	

	public void MarcarDisponibilidade(Disponibilidade indisponiveis) {
		String sql = "insert into indisponiveis(data) " + "values (?)";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, indisponiveis.getData());
			//pstm.setString(2, indisponiveis.getHorario());
		

			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlDisponibilidade" + erro);
		}

	}
	public ResultSet autenticacaoDisponibilidade(Disponibilidade objdisponibilidade) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from indisponiveis where data = ?";

			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objdisponibilidade.getData()); 


			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "DisponibilidadeControl: " + erro);
			return null;
		}
	}

}
