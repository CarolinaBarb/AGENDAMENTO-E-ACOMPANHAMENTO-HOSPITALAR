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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Dermatolgia", "Nutrição", "Psicologo", "Fonaudiologia", "Fisioterapia", "Terapia Ocupacional"}));
		comboBox_1.setBounds(290, 106, 145, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(290, 86, 157, 15);
		contentPane.add(lblEspecialidade);
		
		JDateChooser txtData = new JDateChooser();
		txtData.setBounds(31, 183, 181, 19);
		contentPane.add(txtData);
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.setBounds(31, 55, 407, 21);
		contentPane.add(txtNomeConsulta);
		txtNomeConsulta.setColumns(10);
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "8h00", "8h15", "8h30", "8h45", "9h00", "9h15", "9h30", "9h45", "10h00", "10h15", "10h30", "10h45", "11h00", "11h15", "11h30", "11h45", "14h00", "14h15", "14h30", "14h45", "15h00", "15h15", "15h30", "15h45", "16h00", "16h15", "16h30", "16h45", "17h00", "17h15", "17h30", "17h45"}));
		comboBoxHora.setBounds(290, 183, 96, 24);
		contentPane.add(comboBoxHora);
		
		JLabel lblNomeCompleto = new JLabel("Nome do Paciente");
		lblNomeCompleto.setBounds(31, 30, 157, 15);
		contentPane.add(lblNomeCompleto);
		
		
		JButton btnMarcar = new JButton("marcar consulta");
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
		btnMarcar.setBounds(139, 300, 181, 25);
		contentPane.add(btnMarcar);
		

		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(290, 159, 70, 15);
		contentPane.add(lblHorario);	
		
		JLabel lblNewLabel = new JLabel("Medico");
		lblNewLabel.setBounds(31, 86, 77, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(31, 108, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(31, 160, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(31, 243, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 240, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretaria tl = new TelaSecretaria();
				tl.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(350, 367, 85, 21);
		contentPane.add(btnVoltar);
		
		
	
}
}
