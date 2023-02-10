package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import com.toedter.components.JLocaleChooser;

import control.ControlConsulta;
import control.ControlDisponibilidade;
import model.Consulta;
import model.Disponibilidade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MarcarDisponibilidade extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcarDisponibilidade frame = new MarcarDisponibilidade();
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
	public MarcarDisponibilidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser DCdata = new JDateChooser();
		DCdata.getCalendarButton().setBackground(new Color(9, 61, 108));
		DCdata.setBounds(80, 127, 186, 19);
		contentPane.add(DCdata);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnAdd.setBackground(new Color(9, 61, 108));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data = ((JTextField)DCdata.getDateEditor().getUiComponent()).getText();
				
				Disponibilidade indisponiveis = new Disponibilidade();
				indisponiveis.setData(data);
				
				ControlDisponibilidade disponibilidadecontrol = new ControlDisponibilidade();
				disponibilidadecontrol.MarcarDisponibilidade(indisponiveis);
				
				JOptionPane.showMessageDialog(null, "adicionado com sucesso");
			}
		});
		btnAdd.setBounds(115, 188, 117, 25);
		contentPane.add(btnAdd);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(9, 61, 108));
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria tl = new TelaSecretaria();
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(249, 279, 85, 21);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 61, 108));
		panel.setBounds(0, 0, 344, 55);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Disponibilidade");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	
}
