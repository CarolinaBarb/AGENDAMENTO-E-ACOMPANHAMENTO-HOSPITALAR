package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

import control.ControlConsulta;
import control.ControlPaciente;
import model.Consulta;
import model.Paciente;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class MarcarConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

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
		setBounds(100, 100, 968, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Dermatolgia", "Nutrição", "Psicologo", "Fonaudiologia", "Fisioterapia", "Terapia Ocupacional"}));
		comboBox_1.setBounds(38, 49, 145, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(68, 12, 157, 15);
		contentPane.add(lblEspecialidade);
		
		JDateChooser txtData = new JDateChooser();
		txtData.setBounds(31, 102, 181, 19);
		contentPane.add(txtData);
		
		txtNome = new JTextField();
		txtNome.setBounds(275, 150, 157, 42);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "8h00", "8h15", "8h30", "8h45", "9h00", "9h15", "9h30", "9h45", "10h00", "10h15", "10h30", "10h45", "11h00", "11h15", "11h30", "11h45", "14h00", "14h15", "14h30", "14h45", "15h00", "15h15", "15h30", "15h45", "16h00", "16h15", "16h30", "16h45", "17h00", "17h15", "17h30", "17h45"}));
		comboBoxHora.setBounds(31, 188, 96, 24);
		contentPane.add(comboBoxHora);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(288, 137, 157, 15);
		contentPane.add(lblNomeCompleto);
		
		JButton btnMarcar = new JButton("marcar consulta");
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
				String data = ((JTextField)txtData.getDateEditor().getUiComponent()).getText();
				String especialidade = comboBox_1.getSelectedItem().toString();
				String horario = comboBoxHora.getSelectedItem().toString();
				

				String paciente = txtNome.getText();
			
				
				Consulta consultas = new Consulta();
				consultas.setIdPaciente(paciente);
				consultas.setEspecialidade(especialidade);
				consultas.setData(data);
				consultas.setHorario(horario);
			
			
				ControlConsulta consultacontrol = new ControlConsulta();
				consultacontrol.cadastrar(consultas);
		
				
			}
		});
		btnMarcar.setBounds(188, 323, 181, 25);
		contentPane.add(btnMarcar);
		

		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(38, 150, 70, 15);
		contentPane.add(lblHorario);
		
		
		
		
	}
}
