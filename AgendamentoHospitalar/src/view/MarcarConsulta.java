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

public class MarcarConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
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
		
		JSpinner txtEspecialidade = new JSpinner();
		txtEspecialidade.setModel(new SpinnerDateModel(new Date(1674010800000L), null, new Date(1705546800000L), Calendar.DAY_OF_YEAR));
		txtEspecialidade.setBounds(261, 28, 201, 63);
		contentPane.add(txtEspecialidade);
		
		txtValor = new JTextField();
		txtValor.setBounds(38, 180, 145, 31);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(37, 150, 70, 15);
		contentPane.add(lblValor);
		
		txtNome = new JTextField();
		txtNome.setBounds(275, 150, 157, 42);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(288, 137, 157, 15);
		contentPane.add(lblNomeCompleto);
		
		JButton btnMarcar = new JButton("marcar consulta");
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String paciente, especialidade, valor;
				
				
				String data = ((JTextField)txtData.getDateEditor().getUiComponent()).getText();
				
				

				paciente = txtNome.getText();
				especialidade = txtEspecialidade.getText();
				valor = txtValor.getText();
				
				Consulta consultas = new Consulta();
				consultas.setIdPaciente(paciente);
				consultas.setEspecialidade(especialidade);
				consultas.setValor(valor);
				consultas.setData(data1);
			
			
				ControlConsulta consultacontrol = new ControlConsulta();
				consultacontrol.cadastrar(consultas);
		
				
			}
		});
		btnMarcar.setBounds(188, 323, 181, 25);
		contentPane.add(btnMarcar);
		
		
		
		
	}
}
