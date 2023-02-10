package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Privado;
import model.Consulta;
import model.Convenio;
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
	
	public void cadastrarConsulta(Consulta consultas) {
		String sql = "insert into consultas (paciente,medico, especialidade, data, horario, valor,email) " + "values (?,?, ?, ?, ?, ?,?)";

		conn = new ConexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, consultas.getIdPaciente());
			pstm.setString(2, consultas.getIdMedico());
			pstm.setString(3, consultas.getEspecialidade());
			pstm.setString(4, consultas.getData());	
			pstm.setString(5, consultas.getHorario());	
			pstm.setString(6, consultas.getValor());
			pstm.setString(7, consultas.getEmail());
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ControlConsulta" + erro);
		}

	}	
	public void RegistrarPagamentoPriv(Privado objPrivado) {
		String sql = "insert into pagamentopriv (nome, data, valor, tipo, parcelas) values (?,?,?,?,?)" ;
		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objPrivado.getNome());
			pstm.setString(2, objPrivado.getDataPagamento());
			pstm.setString(3, objPrivado.getValor());
			pstm.setString(4, objPrivado.getTipo());
			pstm.setString(5, objPrivado.getParcelas());
			
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Pagamento Registrado");
			pstm.close();
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, "Pagameto priv" + erro);
		}
	}
	public void RegistrarPagamentoConv(Convenio objConvenio) {
		
	}


}
