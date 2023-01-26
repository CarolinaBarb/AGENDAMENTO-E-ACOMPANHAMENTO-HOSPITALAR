package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Consulta;
import model.Disponibilidade;
import model.Medico;
import model.Paciente;

public class ControlConsulta {

	Connection conn;
	PreparedStatement pstm;
	ArrayList<Consulta> lista = new ArrayList<>();
	

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
	public ArrayList<Consulta> PesquisarConsulta(){
		String sql = "select * from consultas";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Consulta objconsulta = new Consulta();
				 objconsulta.setIdPaciente(rs.getString("paciente"));
				 objconsulta.setEspecialidade(rs.getString("especialidade"));
				 objconsulta.setHorario(rs.getString("horario"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setValor(rs.getString("valor"));
				 objconsulta.setID(rs.getInt("idconsulta"));
				 
				 lista.add(objconsulta);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Pesquisar Consulta:" + erro);
	 
		 }
		 return lista;
	 
	}
	
	public void excluirConsulta (Consulta objConsulta) {
		String sql = "delete from consultas where idconsulta = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, objConsulta.getID() );
			 
			 pstm.execute();
			 pstm.close();
			
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Consulta Excluir:" + erro);
	 
		 }
		 	
	}
	
}
