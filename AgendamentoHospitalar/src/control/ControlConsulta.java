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

import java.util.*
;
public class ControlConsulta {

	Connection conn;
	PreparedStatement pstm;
	public static ArrayList<Consulta> lista = new ArrayList<>();
	

	public void cadastrar(Consulta consultas) {
		String sql = "insert into consultas (paciente,medico, especialidade, data, horario, valor,email) " + "values (?,?, ?, ?, ?, ?,?)";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, consultas.getIdPaciente());
			pstm.setString(2, consultas.getIdMedico());
			pstm.setString(3, consultas.getEspecialidade());
			pstm.setString(4, consultas.getData());	
			pstm.setString(5, consultas.getHorario());	
			pstm.setString(6, consultas.getValor());
			pstm.setString(7, consultas.getEmail());
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
				 objconsulta.setID(rs.getInt("idconsulta"));
				 objconsulta.setIdPaciente(rs.getString("paciente"));
				 objconsulta.setIdMedico(rs.getString("medico"));
				 objconsulta.setEspecialidade(rs.getString("especialidade"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setHorario(rs.getString("horario"));
				 objconsulta.setValor(rs.getString("valor"));
				 objconsulta.setEmail(rs.getString("email"));
				 
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
	
	public ArrayList<Consulta> PacienteConsulta(String email){
		
		
		String sql = "select * from consultas where email = ? "; //ColocarNome.getText()
		conn = new ConexaoDAO().conectaBD();
		
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, email);
			
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
		    JOptionPane.showMessageDialog(null, "Paciente Consulta:" + erro);
	 
		 }
		 return lista;
	 
	}
	
	public void editarConsulta(Consulta objconsulta) {
		String sql = "update consultas set paciente = ?, medico = ?, especialidade = ?, horario = ?, data = ?, valor = ? where idconsulta = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objconsulta.getIdPaciente());
			pstm.setString(2, objconsulta.getIdMedico());
			pstm.setString(3, objconsulta.getEspecialidade());
			pstm.setString(5, objconsulta.getHorario());	
			pstm.setString(4, objconsulta.getData());	
			pstm.setString(6, objconsulta.getValor());
			pstm.setInt(7, objconsulta.getID());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "editado");
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Control Editar" + erro);
		}
		
		
	}

	
}
