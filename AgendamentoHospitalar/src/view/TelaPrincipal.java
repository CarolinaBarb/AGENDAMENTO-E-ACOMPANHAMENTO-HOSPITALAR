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
//import java.awt.Frame;
import java.awt.Image;
//import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
//import imagem.*;


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
		setBounds(100, 100, 626, 280);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(221, 160, 221));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Login Paciente");
		btnNewButton.setBounds(155, 165, 127, 21);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPaciente lo = new LoginPaciente();	
				lo.setVisible(true);
				dispose();
			}

		});
		
		JButton btnNewButton_1 = new JButton("Login Médico");
		btnNewButton_1.setBounds(10, 165, 127, 20);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMedico lm = new LoginMedico();
				lm.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 612, 54);
		contentPane.add(panel);
		
		JLabel lblClinic = new JLabel("Clínica");
		panel.add(lblClinic);
		lblClinic.setForeground(Color.WHITE);
		lblClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinic.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/imagem/doctor.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(26, 81, 111, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image imag = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imag.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(165, 81, 111, 63);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(321, 81, 111, 63);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        Image image2 = new ImageIcon(this.getClass().getResource("/imagem/user.png")).getImage();
        lblNewLabel_2.setIcon(new ImageIcon(image2.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        lblNewLabel_2.setBounds(479, 81, 96, 63);
        contentPane.add(lblNewLabel_2);
        
		JButton btnNewButton_2 = new JButton("Login Administrador");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(9, 69, 108));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin ta = new LoginAdmin();
				ta.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(301, 165, 143, 21);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Login Secretária(o)");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(9, 69, 108));
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginSecretaria ls = new LoginSecretaria();
				ls.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(464, 165, 138, 21);
		contentPane.add(btnNewButton_3);
		
		
	
	
		
		
	}
}
