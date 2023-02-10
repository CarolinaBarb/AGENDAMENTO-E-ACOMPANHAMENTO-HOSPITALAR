package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Administrador;
import model.Consulta;
import model.Funcionario;
import model.Medico;
import model.Paciente;


public class ControlAdministrador {
	Connection conn;
	PreparedStatement pstm;
	
	public ResultSet autenticacaoAdministrador(Administrador objadministrador) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from administrador where email= ? and senha = ?"; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objadministrador.getEmail());
			pstm.setString(2, objadministrador.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Administrador Control: " + erro);
			return null;
		}
	}
	
	public void cadastrarAdm (Administrador objadm) {
		conn = new ConexaoDAO().conectaBD();
		
		String sql = "insert into administrador (email,senha, nome, cpf, Data_nascimento, sexo) values (?, ?, ?, ?, ?, ?) ";
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objadm.getEmail());
			pstm.setString(2, objadm.getSenha());
			pstm.setString(3, objadm.getNome());
			pstm.setString(4, objadm.getCpf());
			pstm.setString(5, objadm.getDataNascimento());
			pstm.setString(6, objadm.getSexo());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cadastro concuido com sucesso!");
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Administrador cadastro Control: " + erro);

		}
		 
	}
	public void cadastrarPaciente(Paciente pacientes) {
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
	public void editarPaciente(Paciente Paciente) {
		String sql = "update paciente set nome_usuario = ?, email = ?, senha_usuario = ?, "
				+ "sexo_usuario = ?, DataNascimento = ?, cpf = ?, altura = ?, peso = ?, observacao = ?, idade = ? where idpaciente = ?";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, Paciente.getNome()); 
			pstm.setString(2, Paciente.getEmail());
			pstm.setString(3, Paciente.getSenha());
			pstm.setString(4, Paciente.getSexo());
			pstm.setString(5, Paciente.getDataNascimento());
			pstm.setString(6, Paciente.getCpf());
			pstm.setString(7, Paciente.getAltura());
			pstm.setString(8, Paciente.getPeso());
			pstm.setString(9, Paciente.getObservacao());
			pstm.setString(10, Paciente.getIdade());
			pstm.setInt(11, Paciente.getIdpaciente());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "editado!");
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlPaciente editar" + erro);
		}
	
  }
	public void cadastrarMedico(Medico medicos) {
		String sql = "insert into medicos (idmedico, nome, email_medicos ,crm,especialidade, senha_medico) "
			      + "values (?, ?, ?, ?, ?, ?)";

	conn = new ConexaoDAO().conectaBD();

	try {
		
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, medicos.getIdmedico());
		pstm.setString(2, medicos.getNome()); 
		pstm.setString(3, medicos.getEmail());
		pstm.setString(4, medicos.getCrm());
		pstm.setString(5, medicos.getEspecialidade());
		pstm.setString(6, medicos.getSenha());
	
		

		pstm.execute();
		JOptionPane.showMessageDialog(null, "cadastro concluido!");
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
	public void editar(Medico medicos) {
	String sql = "update medicos set nome = ?, email_medicos = ?, crm = ?, especialidade = ?, senha_medico = ? where idmedico = ?";

	conn = new ConexaoDAO().conectaBD();

	try {
		
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, medicos.getNome()); 
		pstm.setString(2, medicos.getEmail());
		pstm.setString(3, medicos.getCrm());
		pstm.setString(4, medicos.getEspecialidade());
		pstm.setString(5, medicos.getSenha());
		pstm.setInt(6, medicos.getIdmedico());
	
		
		pstm.execute();
		JOptionPane.showMessageDialog(null, "editado!");
		pstm.close();
		
	} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, "ControlMedico" + erro);
	}
		
	

}
	public void CadastrarFuncionario (Funcionario objfuncionario) {
		conn = new ConexaoDAO().conectaBD();
		
		String sql = "insert into funcionario (nome, cpf, data_nascimento, email, senha, data_admissao, funcao, sexo, contato) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objfuncionario.getNome());
			pstm.setString(2, objfuncionario.getCpf());
			pstm.setString(3, objfuncionario.getDataNascimento());
			pstm.setString(4, objfuncionario.getEmail());
			pstm.setString(5, objfuncionario.getSenha());
			pstm.setString(6, objfuncionario.getData_admissao());
			pstm.setString(7, objfuncionario.getFuncao());
			pstm.setString(8, objfuncionario.getSexo());
			pstm.setString(9, objfuncionario.getContato());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cadastro Concluido");
			pstm.close();

		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Secretaria cadastro aaa Control: " + erro);
		}
		
		
		
	}
	public void excluirFuncionario (Funcionario objSecretaria) {
		String sql = "delete from funcionario where idfuncionario = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, objSecretaria.getIdfuncionario() );
			 
			 pstm.execute();
			 pstm.close();
			
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Secretaria Excluir:" + erro);
	 
		 }
	}
	public void editarFuncionario (Funcionario objfuncionario) {
		String sql = "update funcionario set nome = ?,cpf = ?, data_nascimento = ?, "
				+ "data_admissao = ?, funcao = ?, email = ?, sexo = ?, contato = ?, senha = ? where idfuncionario = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objfuncionario.getNome());
			pstm.setString(2, objfuncionario.getCpf());
			pstm.setString(3, objfuncionario.getDataNascimento());
			pstm.setString(5, objfuncionario.getData_admissao());	
			pstm.setString(4, objfuncionario.getFuncao());	
			pstm.setString(6, objfuncionario.getEmail());
			pstm.setString(7, objfuncionario.getSexo());
			pstm.setString(8, objfuncionario.getContato());
			pstm.setString(9, objfuncionario.getSenha());
			pstm.setInt(10, objfuncionario.getIdfuncionario());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "editado");
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Control Editar" + erro);
		}

	}
	public void excluirconsultas(Consulta objconsulta) {
		String sql = "delete from consultas where idconsulta =  ?";
		
		conn = new ConexaoDAO().conectaBD();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, objconsulta.getID());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "deletado");
			pstm.close();
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "consulta excluir" + erro);
		}
		
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
