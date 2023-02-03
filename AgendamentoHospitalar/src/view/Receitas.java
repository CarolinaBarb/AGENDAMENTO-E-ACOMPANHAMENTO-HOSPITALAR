package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Receitas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receitas frame = new Receitas();
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
	public Receitas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReceita.setBounds(10, 10, 130, 47);
		contentPane.add(lblReceita);
		
		JLabel lblMedicamento = new JLabel("Medicamento");
		lblMedicamento.setBounds(10, 79, 90, 13);
		contentPane.add(lblMedicamento);
		
		textField = new JTextField();
		textField.setBounds(126, 76, 232, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dosagem receitada: ");
		lblNewLabel.setBounds(10, 99, 116, 13);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 96, 42, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"mg", "ml"}));
		comboBox.setBounds(154, 95, 42, 21);
		contentPane.add(comboBox);
		
		JLabel lblTomar = new JLabel("Tomar");
		lblTomar.setHorizontalAlignment(SwingConstants.LEFT);
		lblTomar.setBounds(10, 122, 45, 13);
		contentPane.add(lblTomar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(58, 118, 40, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Vezes ao dia");
		lblNewLabel_1.setBounds(110, 122, 116, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(10, 145, 45, 13);
		contentPane.add(lblHorario);
		
		textField_2 = new JTextField();
		textField_2.setBounds(58, 142, 42, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(": ");
		lblNewLabel_2.setBounds(113, 145, 13, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 142, 42, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDias = new JLabel("Dias");
		lblDias.setBounds(236, 122, 45, 13);
		contentPane.add(lblDias);
		
		JCheckBox Segunda = new JCheckBox("Segunda");
		Segunda.setBounds(287, 118, 93, 21);
		contentPane.add(Segunda);
		
		JCheckBox Terca = new JCheckBox("Terça");
		Terca.setBounds(287, 141, 93, 21);
		contentPane.add(Terca);
		
		JCheckBox Quarta = new JCheckBox("Quarta");
		Quarta.setBounds(287, 164, 93, 21);
		contentPane.add(Quarta);
		
		JCheckBox Quinta = new JCheckBox("Quinta");
		Quinta.setBounds(287, 187, 93, 21);
		contentPane.add(Quinta);
		
		JCheckBox Sexta = new JCheckBox("Sexta");
		Sexta.setBounds(287, 210, 93, 21);
		contentPane.add(Sexta);
		
		JCheckBox Sabado = new JCheckBox("Sabado");
		Sabado.setBounds(287, 233, 93, 21);
		contentPane.add(Sabado);
		
		JCheckBox Domingo = new JCheckBox("Domingo");
		Domingo.setBounds(287, 256, 93, 21);
		contentPane.add(Domingo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 187, 208, 112);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton GerarReceita = new JButton("Gerar Receita");
		GerarReceita.setBounds(130, 311, 127, 31);
		contentPane.add(GerarReceita);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico tm = new TelaMedico();
				tm.setVisible(true);
				dispose();
			}
		});
		Voltar.setBounds(295, 345, 85, 21);
		contentPane.add(Voltar);
		
		JLabel lblNome = new JLabel("Nome do paciente");
		lblNome.setBounds(10, 56, 90, 13);
		contentPane.add(lblNome);
		
		textField_5 = new JTextField();
		textField_5.setBounds(126, 53, 232, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
