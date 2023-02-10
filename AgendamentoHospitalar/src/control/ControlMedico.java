package control;

import model.Atestado;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Receita;

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
			String sql = "select * from medicos where email_medicos = ? and senha_medico = ?"; // mesmo q ta no banco

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
		String sql = "select * from medicos";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Medico objmedico = new Medico();
				 objmedico.setIdmedico(rs.getInt("idmedico"));
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
	public void cadastrarReceita(Receita objreceita) {
		conn = new ConexaoDAO().conectaBD();
		
		String sql = "insert into receita (nome_paciente, medicamento, dosagem, frequencia, dias, email, nome_medico) values (?,?,?,?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objreceita.getNomePaciente());
			pstm.setString(2, objreceita.getMedicamento());
			pstm.setString(3, objreceita.getDosagemReceitada());
			pstm.setString(4, objreceita.getFrequencia());
			pstm.setString(5, objreceita.getDias());
			pstm.setString(6, objreceita.getEmail());
			pstm.setString(7, objreceita.getMedicoResp());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Receita Cadastrada com sucesso!");
			pstm.close();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Receitas cadastro"+ erro);
		}
	}
	public void cadastrarAtestado(Atestado objatestado) {
		conn = new ConexaoDAO().conectaBD();
		
		String sql = "insert into atestados (nome, quantidade_dias, justificativa, recomendacoes, validade) values (?,?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objatestado.getNome());
			pstm.setString(2, objatestado.getQtdDias());
			pstm.setString(3, objatestado.getJustificativa());
			pstm.setString(4, objatestado.getRecomendacoes());
			pstm.setString(5, objatestado.getValidade());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "atestado Cadastrado com sucesso!");
			pstm.close();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Receitas cadastro"+ erro);
		}
	}
	
}
