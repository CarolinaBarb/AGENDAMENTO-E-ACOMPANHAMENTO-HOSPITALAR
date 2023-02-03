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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo de exame");
		lblTipo.setBounds(10, 10, 91, 13);
		contentPane.add(lblTipo);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 167, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMotivo = new JLabel("Motivo para encaminhamento");
		lblMotivo.setBounds(192, 10, 146, 13);
		contentPane.add(lblMotivo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 25, 167, 123);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProfissional = new JLabel("Profissional responsável");
		lblProfissional.setBounds(10, 54, 146, 13);
		contentPane.add(lblProfissional);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 77, 167, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do Paciente");
		lblNewLabel.setBounds(10, 106, 113, 13);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 129, 167, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar encaminhamento");
		btnNewButton.setBounds(10, 201, 181, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar ");
		btnNewButton_1.setBounds(269, 158, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(269, 201, 85, 21);
		contentPane.add(btnNewButton_2);
	}

}
