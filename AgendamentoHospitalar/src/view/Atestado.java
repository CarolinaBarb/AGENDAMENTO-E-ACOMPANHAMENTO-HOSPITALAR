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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtestado = new JLabel("Atestado");
		lblAtestado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtestado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtestado.setBounds(0, 10, 338, 13);
		contentPane.add(lblAtestado);
		
		JLabel lblNewLabel = new JLabel("Justificativa");
		lblNewLabel.setBounds(11, 84, 122, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(11, 101, 230, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Paciente");
		lblNewLabel_1.setBounds(10, 33, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 30, 197, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidadde de dias");
		lblNewLabel_2.setBounds(11, 56, 154, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 59, 39, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Recomendações");
		lblNewLabel_3.setBounds(10, 153, 113, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(11, 170, 227, 57);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar Atestado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 269, 155, 21);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(243, 269, 85, 21);
		contentPane.add(btnVoltar);
	}

}
