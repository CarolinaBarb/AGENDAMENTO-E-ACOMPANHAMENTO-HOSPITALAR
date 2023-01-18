package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Paciente;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.mysql.jdbc.PreparedStatement;

public class ControlPaciente {

	Connection conn;
	PreparedStatement pstm;

	public void cadastrar(Paciente pacientes) {
		String sql = "insert into paciente (nome_usuario, email_usuario, senha_usuario, sexo_usuario, DataNascimento, cpf, altura, peso, observacao) "
				      + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
		
			

			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlPaciente" + erro);
		}

	}

	public ResultSet autenticacaoPaciente(Paciente objpacientecontrol) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from paciente where email_usuario = ? and senha_usuario = ?"; // mesmo q ta no banco

			java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objpacientecontrol.getEmail()); // primeira ? e o email
			pstm.setString(2, objpacientecontrol.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PacienteControl: " + erro);
			return null;
		}
	}

	/*
	 * private ArrayList<Paciente> pacientes = new ArrayList<>();
	 * 
	 * public boolean salvar (Paciente m) { if(m != null) { pacientes.add(m); return
	 * true; } else { return false; } }
	 * 
	 * public ArrayList <Paciente> retornarTodos(){ return pacientes; }
	 * 
	 * Validar validar = new Validar();
	 * 
	 * 
	 * public boolean cadastrar(ControlDados d, String nome, String email, String
	 * senha) { Paciente paciente = new Paciente(email, senha, nome);
	 * if(validar.validacriarConta(d, nome, email, senha)) { return true; }
	 * paciente.setNome(nome); paciente.setEmail(email); paciente.setSenha(senha);
	 * 
	 * 
	 * return Dados.paciente.add(paciente);
	 * 
	 * 
	 * }
	 * 
	 * public boolean logar(ControlDados d, String email,String senha) { Paciente
	 * paciente = new Paciente(email, senha); if(validar.validaLoginPacient(d,
	 * email, senha)) { return true; }else { } paciente.setPaciente(paciente);
	 * return Dados.paciente.add(paciente); }
	 */
}
