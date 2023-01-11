package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacientesAgendados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacientesAgendados frame = new PacientesAgendados();
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
	public PacientesAgendados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Detalhes dos Pacientes");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setForeground(new Color(255, 182, 193));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(463, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addGap(439))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 156, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nomes");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(10, 10, 136, 13);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(176, 10, 116, 168);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 96, 13);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(302, 10, 58, 168);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 10, 58, 13);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(370, 10, 89, 168);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Data");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 10, 69, 13);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(469, 10, 179, 168);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 10, 159, 13);
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(658, 10, 156, 168);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 10, 136, 13);
		panel_6.add(lblNewLabel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(824, 10, 168, 168);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Prontuário");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 10, 148, 13);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(1002, 10, 187, 218);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Ações");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 10, 155, 13);
		panel_8.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Adicionar Receita/Atestado");
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 34, 187, 82);
		panel_8.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adicionar encaminhamento");
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(0, 127, 189, 78);
		panel_8.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
	}
}
