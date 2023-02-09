package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Encaminhamento extends JFrame {

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
					Encaminhamento frame = new Encaminhamento();
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
	public Encaminhamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 269);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de exame:");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblTipo.setForeground(new Color(9, 61, 108));
		lblTipo.setBounds(10, 28, 91, 13);
		contentPane.add(lblTipo);
		
		textField = new JTextField();
		textField.setBounds(10, 51, 158, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMotivo = new JLabel("Motivo para Encaminhamento:");
		lblMotivo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblMotivo.setForeground(new Color(9, 61, 108));
		lblMotivo.setBounds(187, 28, 182, 13);
		contentPane.add(lblMotivo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 50, 167, 98);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProfissional = new JLabel("Profissional Responsável:");
		lblProfissional.setForeground(new Color(9, 61, 108));
		lblProfissional.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblProfissional.setBounds(10, 80, 146, 13);
		contentPane.add(lblProfissional);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 106, 158, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do Paciente:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel.setForeground(new Color(9, 61, 108));
		lblNewLabel.setBounds(10, 135, 113, 13);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 159, 158, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar encaminhamento");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 61, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton.setBounds(10, 201, 181, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar ");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(9, 61, 108));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_1.setBounds(269, 158, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnNewButton_2.setBackground(new Color(9, 61, 108));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(269, 201, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 61, 108));
		panel.setBounds(0, 0, 369, 20);
		contentPane.add(panel);
	}

}
