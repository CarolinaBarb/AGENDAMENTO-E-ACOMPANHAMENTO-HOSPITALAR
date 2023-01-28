package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Administrador;


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
}
