package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paciente;
import javax.swing.JOptionPane;

//import com.mysql.jdbc.PreparedStatement;



public class ControlPaciente {
	
	  Connection conn;
	  
	  public ResultSet autenticacaoPaciente(Paciente objpacientecontrol) {
		  conn = new ConexaoDAO().conectaBD();
		  
		  try {
			  String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?"; //mesmo q ta no banco
			  
			  java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
			  pstm.setString(1, objpacientecontrol.getEmail());
			  pstm.setString(2, objpacientecontrol.getSenha());
			  
			  ResultSet rs = pstm.executeQuery();  
			  return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "PacienteControl: "+erro);
			return null;
		}
	  }
	
	
	
	
	/*
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	
	public boolean salvar (Paciente m) {
		if(m != null) {
			pacientes.add(m);	
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList <Paciente> retornarTodos(){
		return pacientes;
	}
	
		Validar validar = new Validar();
		

       public boolean cadastrar(ControlDados d, String nome, String email, String senha) {
       	Paciente paciente = new Paciente(email, senha, nome);
       	if(validar.validacriarConta(d, nome, email, senha)) {
       		return true;
       	}
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setSenha(senha);
             
     
       	return Dados.paciente.add(paciente);
        
        	
       }
       
       public boolean logar(ControlDados d, String email,String senha) {
       	Paciente paciente = new Paciente(email, senha);
       	if(validar.validaLoginPacient(d, email, senha)) { 
       		return true;
        	}else {
        }
       	paciente.setPaciente(paciente);
       	return Dados.paciente.add(paciente);
       }
       */
}
