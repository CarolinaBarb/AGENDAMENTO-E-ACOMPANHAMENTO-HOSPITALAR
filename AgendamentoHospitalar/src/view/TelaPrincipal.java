package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		JButton btnCadastrase = new JButton("Cadastra-se");
		btnCadastrase.setBounds(301, 165, 111, 21);
		btnCadastrase.setForeground(new Color(255, 255, 255));
		btnCadastrase.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCadastrase.setBackground(new Color(9, 69, 108));
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
		btnNewButton.setBounds(155, 165, 111, 21);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.container.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Login Medico");
		btnNewButton_1.setBounds(10, 165, 111, 20);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(-19, -16, 455, 71);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(10, 81, 111, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image imag = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imag.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(155, 81, 111, 63);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(301, 81, 111, 63);
		contentPane.add(lblNewLabel_1_1);
	
	
		
		
	}
}
