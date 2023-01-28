package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import com.toedter.components.JLocaleChooser;

import control.ControlConsulta;
import control.ControlDisponibilidade;
import model.Consulta;
import model.Disponibilidade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarcarDisponibilidade extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcarDisponibilidade frame = new MarcarDisponibilidade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarcarDisponibilidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser DCdata = new JDateChooser();
		DCdata.setBounds(64, 72, 186, 19);
		contentPane.add(DCdata);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data = ((JTextField)DCdata.getDateEditor().getUiComponent()).getText();
				
				Disponibilidade indisponiveis = new Disponibilidade();
				indisponiveis.setData(data);
				
				ControlDisponibilidade disponibilidadecontrol = new ControlDisponibilidade();
				disponibilidadecontrol.cadastrar(indisponiveis);
				
				JOptionPane.showMessageDialog(null, "adicionado com sucesso");
			}
		});
		btnAdd.setBounds(94, 126, 117, 25);
		contentPane.add(btnAdd);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria tl = new TelaSecretaria();
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(249, 232, 85, 21);
		contentPane.add(btnVoltar);
	}
	
	
}
