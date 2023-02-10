package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Consulta;
import model.Paciente;
import model.Prontuário;
import model.Paciente;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.mysql.jdbc.PreparedStatement;

public class ControlPaciente {

	Connection conn;
	PreparedStatement pstm;
	public static ArrayList<Paciente> lista = new ArrayList<>();
	

	

	public ResultSet autenticacaoPaciente(Paciente objpacientecontrol) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from paciente where email = ? and senha_usuario = ?"; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objpacientecontrol.getEmail()); // primeira ? e o email
			pstm.setString(2, objpacientecontrol.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PacienteControl: " + erro);
			return null;
		}
	}
	
	public ArrayList<Paciente> PesquisarPaciente(){
		 String sql = "select * from paciente";
		 conn = new ConexaoDAO().conectaBD();
		  
		 try {
			 pstm = conn.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Paciente objpaciente = new Paciente();
				 objpaciente.setIdpaciente(rs.getInt("idpaciente"));
				 objpaciente.setNome(rs.getString("nome_usuario"));
				 objpaciente.setIdade(rs.getString("idade"));
				 objpaciente.setDataNascimento(rs.getString("DataNascimento"));
				 objpaciente.setCpf(rs.getString("cpf"));
				 objpaciente.setAltura(rs.getString("altura"));
				 objpaciente.setPeso(rs.getString("peso"));
				 objpaciente.setSexo(rs.getString("sexo_usuario"));
				 objpaciente.setEmail(rs.getString("email"));
				 objpaciente.setObservacao(rs.getString("observacao"));
				
				 
				 lista.add(objpaciente);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Pesquisar Paciente:" + erro);
	 
		 }
		 return lista;
	 }
	
	
	public ArrayList<Paciente> PacienteProntuario(String email){
		String sql = "select * from paciente where email = ?";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				 Paciente objpaciente = new Paciente();
				 objpaciente.setNome(rs.getString("nome_usuario"));
				 objpaciente.setIdade(rs.getString("idade"));
				 objpaciente.setDataNascimento(rs.getString("DataNascimento"));
				 objpaciente.setCpf(rs.getString("cpf"));
				 objpaciente.setAltura(rs.getString("altura"));
				 objpaciente.setPeso(rs.getString("peso"));
				 objpaciente.setSexo(rs.getString("sexo_usuario"));
				 objpaciente.setEmail(rs.getString("email"));
				 objpaciente.setObservacao(rs.getString("observacao"));
				
				 
				 lista.add(objpaciente);
			}
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"Paciente receita" + erro);
		}
		return lista;
		
	}
	
	public ResultSet autenticacaoAcessoProntuario(Paciente objpacientecontrol) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from paciente where email = ? "; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objpacientecontrol.getEmail()); // primeira ? e o email

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PacienteControl: " + erro);
			return null;
		}
	}

	
}
