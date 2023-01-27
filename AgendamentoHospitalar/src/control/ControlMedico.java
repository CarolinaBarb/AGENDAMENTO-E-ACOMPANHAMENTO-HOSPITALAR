package control;

import model.Medico;
import model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ControlMedico {
	
	Connection conn;
	PreparedStatement pstm;
	ArrayList<Medico> lista = new ArrayList<>();
	

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
	
	public ArrayList<Medico> PesquisarMedico(){
		String sql = "select * from Medicos";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Medico objmedico = new Medico();
				 objmedico.setNome(rs.getString("nome"));
				 objmedico.setEmail(rs.getString("email_medicos"));
				 objmedico.setCrm(rs.getString("crm"));
				 objmedico.setEspecialidade(rs.getString("especialidade"));
				 
				 lista.add(objmedico);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Pesquisar Medico:" + erro);
	 
		 }
		 return lista;
	 
	}

	public void cadastrar(Medico medicos) {
		String sql = "insert into Medicos (idmedico, nome, email_medicos,crm,especialidade) "
			      + "values (?, ?, ?, ?)";

	conn = new ConexaoDAO().conectaBD();

	try {
		
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, medicos.getIdmedico());
		pstm.setString(2, medicos.getNome()); 
		pstm.setString(3, medicos.getEmail());
		pstm.setString(4, medicos.getCrm());
		pstm.setString(5, medicos.getEspecialidade());
	
		

		pstm.execute();
		pstm.close();
		
	} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, "ControlMedico" + erro);
	}
		
	}
	
	public void excluirMedico(Medico objMedico) {
		String sql = "delete from medicos where idmedico = ?";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, objMedico.getIdmedico());
			 
			 pstm.execute();
			 pstm.close();
			
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Medico Excluir:" + erro);
	 
		 }
		
		
	}

}
