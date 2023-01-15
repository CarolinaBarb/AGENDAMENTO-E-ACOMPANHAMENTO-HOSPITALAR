package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCadastrase = new JButton("Cadastra-se");
		btnCadastrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro lm = new Cadastro();
				lm.container.setVisible(true);
				this.dispose();
				
			}

			private void dispose() {
				
			}
		});
		
		JButton btnNewButton = new JButton("Login Paciente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.container.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("LoginMedico");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMedico lm = new LoginMedico();
				lm.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				
			}
		});
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnCadastrase);
	}

}
