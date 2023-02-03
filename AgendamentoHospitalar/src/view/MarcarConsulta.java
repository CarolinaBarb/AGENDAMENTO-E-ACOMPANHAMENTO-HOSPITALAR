package view;

import control.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

import model.Consulta;
import model.Disponibilidade;
import model.Paciente;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.Color;

public class MarcarConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeConsulta;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcarConsulta frame = new MarcarConsulta();
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
	public MarcarConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setBackground(new Color(9, 69, 108));
		comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Dermatolgia", "Nutrição", "Psicologo", "Fonaudiologia", "Fisioterapia", "Terapia Ocupacional"}));
		comboBox_1.setBounds(290, 106, 145, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setForeground(new Color(9, 69, 108));
		lblEspecialidade.setBounds(290, 86, 157, 15);
		contentPane.add(lblEspecialidade);
		
		JDateChooser txtData = new JDateChooser();
		txtData.getCalendarButton().setBackground(new Color(9, 69, 108));
		txtData.setBounds(7, 231, 181, 19);
		contentPane.add(txtData);
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.setBounds(7, 107, 181, 21);
		contentPane.add(txtNomeConsulta);
		txtNomeConsulta.setColumns(10);
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setBackground(new Color(9, 69, 108));
		comboBoxHora.setForeground(new Color(255, 255, 255));
		comboBoxHora.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "8h00", "8h15", "8h30", "8h45", "9h00", "9h15", "9h30", "9h45", "10h00", "10h15", "10h30", "10h45", "11h00", "11h15", "11h30", "11h45", "14h00", "14h15", "14h30", "14h45", "15h00", "15h15", "15h30", "15h45", "16h00", "16h15", "16h30", "16h45", "17h00", "17h15", "17h30", "17h45"}));
		comboBoxHora.setBounds(290, 183, 145, 24);
		contentPane.add(comboBoxHora);
		
		JLabel lblNomeCompleto = new JLabel("Nome do Paciente:");
		lblNomeCompleto.setForeground(new Color(9, 69, 108));
		lblNomeCompleto.setBackground(new Color(9, 69, 108));
		lblNomeCompleto.setBounds(7, 86, 157, 15);
		contentPane.add(lblNomeCompleto);
		
		
		JButton btnMarcar = new JButton("marcar consulta");
		btnMarcar.setBackground(new Color(9, 69, 108));
		btnMarcar.setForeground(new Color(255, 255, 255));
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				VerifData();
				
				
			}

			private void VerifData() {
				try {
					String data = ((JTextField)txtData.getDateEditor().getUiComponent()).getText();
					
					Disponibilidade consult = new Disponibilidade();
					consult.setData(data);
				   
				    ControlDisponibilidade disponibilidadecontrol = new ControlDisponibilidade();
				    ResultSet rsdisponibilidade = disponibilidadecontrol.autenticacaoDisponibilidade(consult); //resultset tipo
				   
				   if(rsdisponibilidade.next()) {
					   JOptionPane.showMessageDialog(null, "data indisponivel");
				   }
				   else {
					    String especialidade = comboBox_1.getSelectedItem().toString();
						String horario = comboBoxHora.getSelectedItem().toString();
						String paciente = txtNomeConsulta.getText();
						
						Consulta consultas = new Consulta();
						
						consultas.setIdPaciente(paciente);
						consultas.setEspecialidade(especialidade);
						consultas.setData(data);
						consultas.setHorario(horario);
			            
						ControlConsulta consultacontrol = new ControlConsulta();
						consultacontrol.cadastrar(consultas);
				   }
				
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null,"FRMMarcarCView" + erro);
				}

				
			}
		});
		btnMarcar.setBounds(143, 354, 181, 25);
		contentPane.add(btnMarcar);
		

		
		JLabel lblHorario = new JLabel("Horário:");
		lblHorario.setForeground(new Color(9, 69, 108));
		lblHorario.setBounds(290, 159, 70, 15);
		contentPane.add(lblHorario);	
		
		JLabel lblNewLabel = new JLabel("Médico:");
		lblNewLabel.setForeground(new Color(9, 69, 108));
		lblNewLabel.setBounds(7, 147, 77, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(7, 170, 181, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setForeground(new Color(9, 69, 108));
		lblNewLabel_1.setBounds(7, 208, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setForeground(new Color(9, 69, 108));
		lblNewLabel_2.setBounds(7, 271, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(7, 294, 181, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBackground(new Color(9, 69, 108));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria tl = new TelaSecretaria();
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(376, 383, 85, 21);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(9, 69, 108));
		panel.setBounds(0, 0, 485, 54);
		contentPane.add(panel);
		
		
	
}
}
