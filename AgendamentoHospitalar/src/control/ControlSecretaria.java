package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Secretaria;

public class ControlSecretaria {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<Secretaria> Lista = new ArrayList<>();
	
	public ResultSet autenticacaoSecretaria(Secretaria objsecretaria) {
		conn = new ConexaoDAO().conectaBD();

		try {
			String sql = "select * from secretaria where email= ? and senha = ?"; // mesmo q ta no banco

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
	
	public void CadastrarSecretaria (Secretaria objsecretaria) {
		conn = new ConexaoDAO().conectaBD();
		
		String sql = "insert into secretaria (nome, cpf, data_nascimento, email, senha, data_admissao, funcao, sexo, contato) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objsecretaria.getNome());
			pstm.setString(2, objsecretaria.getCpf());
			pstm.setString(3, objsecretaria.getDataNascimento());
			pstm.setString(4, objsecretaria.getEmail());
			pstm.setString(5, objsecretaria.getSenha());
			pstm.setString(6, objsecretaria.getData_admissao());
			pstm.setString(7, objsecretaria.getFuncao());
			pstm.setString(8, objsecretaria.getSexo());
			pstm.setString(9, objsecretaria.getContato());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cadastro Concluido");
			pstm.close();

		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Secretaria cadastro aaa Control: " + erro);
		}
		
		
		
	}
	
	public ArrayList<Secretaria> PesquisarSecretaria () {
		String sql = "select * from secretaria ";
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Secretaria objsecretaria = new Secretaria();
				objsecretaria.setIdSscretaria(rs.getInt("idsecretaria"));
				objsecretaria.setNome(rs.getString("nome"));
				objsecretaria.setCpf(rs.getString("cpf"));
				objsecretaria.setDataNascimento(rs.getString("data_nascimento"));
				objsecretaria.setData_admissao(rs.getString("data_admissao"));
				objsecretaria.setFuncao(rs.getString("funcao"));
				objsecretaria.setEmail(rs.getString("email"));
				objsecretaria.setSexo(rs.getString("sexo"));
				objsecretaria.setContato(rs.getString("contato"));
				
				Lista.add(objsecretaria);
			}
			
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "Secretaria pesquisar Control: " + erro);
		}
		return Lista;
		
	}
	
	public void excluirFuncionario (Secretaria objSecretaria) {
		String sql = "delete from secretaria where idsecretaria = ? ";
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, objSecretaria.getIdSscretaria() );
			 
			 pstm.execute();
			 pstm.close();
			
			 
		 }catch(SQLException erro) {
		    JOptionPane.showMessageDialog(null, "Secretaria Excluir:" + erro);
	 
		 }
	}

}
