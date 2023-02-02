package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Funcionario;

public class ControlFuncionario {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<Funcionario> Lista = new ArrayList<>();
	
	public ResultSet autenticacaoSecretaria(Funcionario objsecretaria) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from funcionario where email= ? and senha = ?"; // mesmo q ta no banco

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objsecretaria.getEmail()); // primeira ? e o email
			pstm.setString(2, objsecretaria.getSenha()); // segunda ? e a senha

			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Secretaria Control: " + erro);
			return null;
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
	
	public ArrayList<Funcionario> PesquisarFuncionario() {
		String sql = "select * from funcionario ";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Funcionario objfuncionario = new Funcionario();
				objfuncionario.setIdfuncionario(rs.getInt("idfuncionario"));
				objfuncionario.setNome(rs.getString("nome"));
				objfuncionario.setCpf(rs.getString("cpf"));
				objfuncionario.setDataNascimento(rs.getString("data_nascimento"));
				objfuncionario.setData_admissao(rs.getString("data_admissao"));
				objfuncionario.setFuncao(rs.getString("funcao"));
				objfuncionario.setEmail(rs.getString("email"));
				objfuncionario.setSexo(rs.getString("sexo"));
				objfuncionario.setContato(rs.getString("contato"));
				
				Lista.add(objfuncionario);
			}
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "Secretaria pesquisar Control: " + erro);
		}
		return Lista;
		
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
	public void editar (Funcionario objfuncionario) {
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

}
