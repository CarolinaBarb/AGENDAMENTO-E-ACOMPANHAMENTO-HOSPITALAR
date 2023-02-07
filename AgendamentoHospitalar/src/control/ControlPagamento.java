package control;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.Privado;

public class ControlPagamento {
	Connection conn;
	PreparedStatement pstm;
	
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
}
