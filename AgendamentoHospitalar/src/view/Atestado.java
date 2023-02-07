package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Atestado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atestado frame = new Atestado();
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
	public Atestado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Justificativa:");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 116, 122, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 139, 230, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Paciente:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(9, 64, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 61, 177, 16);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de dias:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(9, 88, 154, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(136, 88, 177, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Recomendações:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setBounds(10, 192, 113, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(8, 215, 227, 43);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar Atestado");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(8, 283, 155, 21);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.setBackground(new Color(9, 69, 108));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(243, 283, 85, 21);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 338, 43);
		contentPane.add(panel);
		
		JLabel lblAtestado = new JLabel("Atestado");
		lblAtestado.setForeground(new Color(255, 255, 255));
		panel.add(lblAtestado);
		lblAtestado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtestado.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}

}
