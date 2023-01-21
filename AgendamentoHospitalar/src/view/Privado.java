package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Privado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Privado frame = new Privado();
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
	public Privado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 103, 29);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(61, 88, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 137, 52, 19);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(61, 139, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Parcelamento");
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(277, 60, 127, 29);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(9, 69, 108));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1x", "2x", "3x", "4x", "5x", "6x"}));
		comboBox.setBounds(277, 100, 103, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Forma de Pagamento");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(277, 140, 188, 13);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setBackground(new Color(9, 69, 108));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"cartão de crédito", "cartão de débito", "dinheiro"}));
		comboBox_1.setBounds(276, 163, 114, 21);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Gerar Recibo");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(112, 223, 173, 50);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 431, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Privado");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
	}
}
