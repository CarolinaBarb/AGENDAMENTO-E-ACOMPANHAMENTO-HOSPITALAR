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
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class MarcarConsulta extends JFrame {

	private JPanel contentPane;

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
		lblEspecialidade.setBounds(50, 12, 157, 15);
		contentPane.add(lblEspecialidade);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(31, 102, 181, 19);
		contentPane.add(dateChooser);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1674010800000L), null, new Date(1705546800000L), Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(260, 28, 201, 63);
		contentPane.add(spinner_1);
		
		
		
		
	}
}
