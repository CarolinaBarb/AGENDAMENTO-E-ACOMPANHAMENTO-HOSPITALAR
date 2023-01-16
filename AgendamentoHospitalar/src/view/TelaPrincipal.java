package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

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
		contentPane.setForeground(new Color(221, 160, 221));
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCadastrase = new JButton("Cadastra-se");
		btnCadastrase.setBounds(276, 13, 83, 21);
		btnCadastrase.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnCadastrase.setBackground(new Color(128, 0, 128));
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
		btnNewButton.setBounds(152, 13, 95, 21);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(128, 0, 128));
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
		btnNewButton_1.setBounds(22, 13, 111, 20);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMedico lm = new LoginMedico();
				lm.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnCadastrase);
	}

}
