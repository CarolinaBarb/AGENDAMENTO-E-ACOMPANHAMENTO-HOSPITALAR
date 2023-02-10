 package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Consulta;
import model.Disponibilidade;
import model.Medico;
import model.Paciente;

import java.util.*
;
public class ControlConsulta {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	public static ArrayList<Consulta> lista = new ArrayList<>();
	public static ArrayList<Consulta> lista1 = new ArrayList<>();
	


	public ArrayList<Consulta> PesquisarConsulta(){
		String sql = "select * from consultas";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Consulta objconsulta = new Consulta();
				 objconsulta.setID(rs.getInt("idconsulta"));
				 objconsulta.setIdPaciente(rs.getString("paciente"));
				 objconsulta.setIdMedico(rs.getString("medico"));
				 objconsulta.setEspecialidade(rs.getString("especialidade"));
				 objconsulta.setHorario(rs.getString("horario"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setValor(rs.getString("valor"));
				 objconsulta.setEmail(rs.getString("email"));
				 
				 lista1.add(objconsulta);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Pesquisar Consulta:" + erro);
	 
		 }
		 return lista1;
	 
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
				 objconsulta.setEmail(rs.getString("email"));
				 objconsulta.setIdMedico(rs.getString("medico"));
				 objconsulta.setEspecialidade(rs.getString("especialidade"));
				 objconsulta.setHorario(rs.getString("horario"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setValor(rs.getString("valor"));
				 
				 lista.add(objconsulta);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Paciente Consulta:" + erro);
	 
		 }
		 return lista;
	 
	}
	
    public ArrayList<Consulta> PacientePagamento(String id){
		
		String sql = "select * from consultas where idconsulta = ? "; //ColocarNome.getText()
		conn = new ConexaoDAO().conectaBD();
		
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, id);
			
			ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Consulta objconsulta = new Consulta();
				 objconsulta.setID(rs.getInt("idconsulta"));
				 objconsulta.setIdPaciente(rs.getString("paciente"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setValor(rs.getString("valor"));
				 
				 lista.add(objconsulta);
			 }
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Paciente Consulta Pagamento:" + erro);
	 
		 }
		 return lista;
	 
	}
	
    public ArrayList<Consulta> ProntuarioConsulta(String email){
		String sql = "select * from consultas where email = ? "; //ColocarNome.getText()
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, email);
			
			ResultSet rs = pstm.executeQuery();
			 
			 while(rs.next()) {
				 Consulta objconsulta = new Consulta();
				 objconsulta.setIdMedico(rs.getString("medico"));
				 objconsulta.setEspecialidade(rs.getString("especialidade"));
				 objconsulta.setData(rs.getString("data"));
				 objconsulta.setHorario(rs.getString("horario"));
				 objconsulta.setValor(rs.getString("valor"));
				 objconsulta.setDiagnostico(rs.getString("diagnostico"));
				 objconsulta.setObs(rs.getString("observacao"));
				 
				 lista.add(objconsulta);
			 }	 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Paciente Consulta:" + erro); 
		 }
		 return lista;
	 
	}
    public ResultSet autenticacaoAcessoProntuarioC(Consulta objconsulta) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from consultas where email = ? "; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objconsulta.getEmail()); // primeira ? e o email

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ConsultaControl: " + erro);
			return null;
		}
	}
	
}
