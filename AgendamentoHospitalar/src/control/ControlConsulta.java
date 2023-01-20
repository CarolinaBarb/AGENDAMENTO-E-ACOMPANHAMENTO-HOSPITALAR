package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Consulta;
import model.Disponibilidade;
import model.Paciente;

public class ControlConsulta {

	Connection conn;
	PreparedStatement pstm;
	

	public void cadastrar(Consulta consultas) {
		String sql = "insert into Consultas (paciente, especialidade, data, horario) " + "values (?, ?, ?, ?)";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, consultas.getIdPaciente());
			pstm.setString(2, consultas.getEspecialidade());
			pstm.setString(3, consultas.getData());	
			pstm.setString(4, consultas.getHorario());	

			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlConsulta" + erro);
		}

	}	
	
}
