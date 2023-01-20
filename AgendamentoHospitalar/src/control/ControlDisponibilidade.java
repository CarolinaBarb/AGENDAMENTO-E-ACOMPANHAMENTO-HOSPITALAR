package control;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.*;

public class ControlDisponibilidade {
	
	Connection conn;
	PreparedStatement pstm;
	

	public void cadastrar(Disponibilidade indisponiveis) {
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

}
