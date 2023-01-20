package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import control.*;

public class TelaAdmin extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdmin frame = new TelaAdmin();
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
	public TelaAdmin() {
		
		getContentPane().setBackground(new Color(9, 69, 108));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 529);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 228, 225), 3));
		panel.setForeground(new Color(255, 182, 193));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-47, -20, 1247, 533);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Pacientes ");
		btnNewButton.setBounds(93, 184, 267, 186);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(9, 69, 108));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {	
			MostrarPacientes pa = new MostrarPacientes();
			pa.setVisible(true);
            this.dispose();	             
			}

		private void dispose() {	
		}
	}
		);
		panel.setLayout(null);
		
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Médico");
		btnNewButton_1.setBounds(516, 184, 267, 186);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(9, 69, 108));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarMedicos mm = new MostrarMedicos();
				mm.setVisible(true);
	            this.dispose();	 

			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1247, 106);
		panel_1.setBackground(new Color(9, 69, 108));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor ");
		lblNewLabel.setBounds(483, 35, 260, 39);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(9, 69, 108));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_2 = new JButton("Consultas");
		btnNewButton_2.setBackground(new Color(9, 69, 108));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 22));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarConsultas mc = new MostrarConsultas();
				mc.setVisible(true);
	            this.dispose();	
				
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.setBounds(947, 184, 254, 186);
		panel.add(btnNewButton_2);
		
		JButton btnDisponibilidade = new JButton("Disponibilidade");
		btnDisponibilidade.setBounds(746, 408, 169, 34);
		panel.add(btnDisponibilidade);
	}
}
