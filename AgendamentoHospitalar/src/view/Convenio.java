package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Convenio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Convenio frame = new Convenio();
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
	public Convenio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Convênio: ");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 68, 244, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 103, 101, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Associação: ");
		lblNewLabel_3.setForeground(new Color(9, 69, 108));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 143, 101, 13);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Titular");
		rdbtnNewRadioButton.setBackground(new Color(9, 69, 108));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(8, 168, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Dependente");
		rdbtnNewRadioButton_1.setBackground(new Color(9, 69, 108));
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(8, 191, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(156, 72, 188, 16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 107, 96, 13);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor: ");
		lblNewLabel_4.setForeground(new Color(9, 69, 108));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(1, 238, 123, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(46, 237, 96, 14);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Parcelamento");
		lblNewLabel_5.setForeground(new Color(9, 69, 108));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(0, 273, 101, 13);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(9, 69, 108));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1x", "2x", "3x", "4x", "5x", "6x"}));
		comboBox.setBounds(99, 270, 101, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Gerar Recibo");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(226, 302, 123, 37);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 402, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Convênio");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
	}
}
