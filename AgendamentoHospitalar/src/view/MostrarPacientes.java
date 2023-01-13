package view;

import java.awt.EventQueue;
import java.lang.annotation.Target;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class MostrarPacientes extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarPacientes frame = new MostrarPacientes();
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
	public MostrarPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Especialidade"},
				{"Emanuel", "fisioterapeuta"},
				{"Joao", "psicologo"},
				{"Helena", "pediatra"},
				{"Maria", "fonaudiologa"},
				{"Ana", "dermatologista"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		model = new DefaultTableModel();
		
		
		
		
		
		
		
		
		contentPane.add(table);
	}

}
