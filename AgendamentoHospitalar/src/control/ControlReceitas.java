package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Medico;
import model.Paciente;
import model.Receita;

public class ControlReceitas {
	Connection conn;
	PreparedStatement pstm;
	public static ArrayList<Receita> lista = new ArrayList<>();
	
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
	public ArrayList<Receita> PesquisarReceita(){
		String sql = "select * from receitas";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Receita objReceita = new Receita();
				 objReceita.setIdreceita(rs.getInt("idreceita"));
				 objReceita.setNomePaciente(rs.getString("nome_paciente"));;
				 objReceita.setMedicoResp(rs.getString("nome_medico"));
				 objReceita.setEmail(rs.getString("email"));
				 objReceita.setMedicamento(rs.getString("medicamento"));;
				 objReceita.setDosagemReceitada(rs.getString("dosagem"));;
				 objReceita.setFrequencia(rs.getString("tomar"));;
				 objReceita.setDias(rs.getString("dias"));
				
				 
				 lista.add(objReceita);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Pesquisar Recita:" + erro);
	 
		 }
		 return lista;
	}
	
	public ArrayList<Receita> PacienteReceita(String email){
		String sql = "select * from receita where email = ?";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Receita objReceita = new Receita();
				objReceita.setMedicoResp(rs.getString("nome_medico"));
				objReceita.setNomePaciente(rs.getString("nome_paciente"));
				objReceita.setEmail(rs.getString("email"));
				objReceita.setMedicamento(rs.getString("medicamento"));
				objReceita.setDosagemReceitada(rs.getString("dosagem"));
				objReceita.setFrequencia(rs.getString("frequencia"));
				objReceita.setDias(rs.getString("dias"));
				
				lista.add(objReceita);
			}
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"Paciente receita" + erro);
		}
		return lista;
		
	}
	public ResultSet autenticacaoReceita(Receita objreceita) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from receita where email = ? "; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objreceita.getEmail()); // primeira ? e o email

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PacienteControl: " + erro);
			return null;
		}
	}
	
	

}
