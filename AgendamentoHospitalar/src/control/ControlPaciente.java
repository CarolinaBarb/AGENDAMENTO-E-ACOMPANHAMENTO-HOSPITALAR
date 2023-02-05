package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Consulta;
import model.Paciente;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.mysql.jdbc.PreparedStatement;

public class ControlPaciente {

	Connection conn;
	PreparedStatement pstm;
	ArrayList<Paciente> lista = new ArrayList<>();
	

	public void cadastrar(Paciente pacientes) {
		String sql = "insert into paciente ( nome_usuario, email, senha_usuario, sexo_usuario, DataNascimento, cpf, altura, peso, observacao, idade) "
				      + "values (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacientes.getNome()); //get pega, set atribui pegando o nome do paciente pra colocar na tabela
			pstm.setString(2, pacientes.getEmail());
			pstm.setString(3, pacientes.getSenha());
			pstm.setString(4, pacientes.getSexo());
			pstm.setString(5, pacientes.getDataNascimento());
			pstm.setString(6, pacientes.getCpf());
			pstm.setString(7, pacientes.getAltura());
			pstm.setString(8, pacientes.getPeso());
			pstm.setString(9, pacientes.getObservacao());
			pstm.setString(10, pacientes.getIdade());
		

			pstm.execute();
			JOptionPane.showMessageDialog(null, "cadastro concluido!");
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlPaciente" + erro);
		}

	}

	public ResultSet autenticacaoPaciente(Paciente objpacientecontrol) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from paciente where email_usuario = ? and senha_usuario = ?"; // mesmo q ta no banco

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
	public void excluirPaciente (Paciente objPaciente) {
		String sql = "delete from paciente where idpaciente = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, objPaciente.getIdpaciente());
			 
			 pstm.execute();
			 pstm.close();
			
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Consulta Excluir:" + erro);
	 
		 }
		 	
	}
	
}
