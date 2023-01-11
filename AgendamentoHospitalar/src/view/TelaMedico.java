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

import control.*;

public class TelaMedico extends JFrame {
	private static ControlDados d = new ControlDados();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico frame = new TelaMedico();
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
	public TelaMedico() {
		
		getContentPane().setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 529);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 228, 225), 3));
		panel.setForeground(new Color(255, 182, 193));
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(10, 10, 892, 472);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Dashboard");
		lblNewLabel.setBounds(296, 31, 308, 61);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 33));
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setBackground(new Color(128, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pacientes Agendados");
		btnNewButton.setBounds(97, 156, 267, 186);
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setBackground(new Color(255, 240, 245));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {	
			PacientesAgendados pa = new PacientesAgendados();
			pa.setVisible(true);
            this.dispose();	             
			}

		private void dispose() {
			
		}
		}
		

		);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agenda");
		btnNewButton_1.setForeground(new Color(153, 50, 204));
		btnNewButton_1.setBounds(546, 156, 267, 186);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(255, 240, 245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
	}
}
