package view;
import control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.*;
import model.*
;public class Cadastro implements ActionListener {
	public JFrame container;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel emailLabel;
	private JLabel senhaLabel;
	private JButton criarConta;
	private JTextField txtNome;
	private JTextField txtCadastrar;
	private JTextField txtSexo;
	private JTextField txtAltura;
	private JTextField txtDataNascimento;
	private JTextField txtObservacao;
	private JTextField txtPeso;
	private JLabel lblObservacao;
	private JTextField txtCpf;
	private JLabel lblCpf;
	
	public Cadastro(){
		container = new JFrame("Cadastro");
		criarConta = new JButton("Criar Conta");
		criarConta.addActionListener(new ActionListener() {
					
			
	//botao cadastrar
			public void actionPerformed(ActionEvent e) {
				String nome, email, senha, sexo, observacao, cpf;
				String altura, peso;
				
				nome = txtNome.getText();
				email = txtEmail.getText();
				senha = txtSenha.getText();
				sexo = txtSexo.getText();
				//dataNascimento = txtDataNascimento.getText();
				altura = txtAltura.getText();
				peso = txtPeso.getText();
				observacao = txtObservacao.getText();
				cpf = txtCpf.getText();
				
				
				Paciente pacientes = new Paciente();
				pacientes.setNome(nome);
				pacientes.setEmail(email);
				pacientes.setSenha(senha);
				pacientes.setSexo(sexo);
				//pacientes.setDataNascimento(null);
				pacientes.setAltura(altura);
				pacientes.setPeso(peso);
				pacientes.setObservacao(observacao);
				pacientes.setCpf(cpf);
				
			
				ControlPaciente pacientecontrol = new ControlPaciente();
				pacientecontrol.cadastrar(pacientes);
			}

		});

		emailLabel = new JLabel ("Email");

    
          
            
    

          
    
    
  
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLabel = new JLabel("Senha");
		senhaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail = new JTextField(25);
		txtSenha = new JPasswordField(25);
		
		container.getContentPane().setBackground(new Color(255, 228, 225));
		container.setTitle("Cadastro");
		container.setSize(500, 500);
		container.setLocation(500, 300);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.getContentPane().setLayout(null);
		
		criarConta.setFont(new Font("Arial", Font.BOLD, 14));
		criarConta.setForeground(new Color(0, 0, 0));
		criarConta.setBounds(167, 393, 139, 30);
		
		txtEmail.setBounds(6, 147, 149, 30);
		emailLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		emailLabel.setBounds(6, 106, 300, 30);
		
		txtSenha.setBounds(6, 245, 154, 30);
		senhaLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		senhaLabel.setBounds(6, 189, 300, 30);
		
		container.getContentPane().add(emailLabel);
		container.getContentPane().add(txtEmail);
		container.getContentPane().add(senhaLabel);
		container.getContentPane().add(txtSenha);
		container.getContentPane().add(criarConta);
		
		txtNome = new JTextField(25);
		txtNome.setBounds(12, 85, 187, 30);
		container.getContentPane().add(txtNome);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompleto.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		lblNomeCompleto.setBounds(6, 20, 300, 30);
		container.getContentPane().add(lblNomeCompleto);
		
		JLabel lblCadastroMedico = new JLabel("Cadastro");
		lblCadastroMedico.setBackground(new Color(72, 209, 204));
		lblCadastroMedico.setForeground(new Color(153, 50, 204));
		lblCadastroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMedico.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblCadastroMedico.setBounds(89, 1, 300, 30);
		container.getContentPane().add(lblCadastroMedico);
		
		txtSexo = new JTextField(25);
		txtSexo.setBounds(6, 353, 149, 30);
		container.getContentPane().add(txtSexo);
		
		txtAltura = new JTextField(25);
		txtAltura.setBounds(319, 317, 149, 30);
		container.getContentPane().add(txtAltura);
		
		txtDataNascimento = new JTextField(25);
		txtDataNascimento.setBounds(319, 224, 149, 30);
		container.getContentPane().add(txtDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(12, 317, 70, 15);
		container.getContentPane().add(lblSexo);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento");
		lblNewLabel.setBounds(318, 189, 170, 15);
		container.getContentPane().add(lblNewLabel);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(319, 279, 70, 15);
		container.getContentPane().add(lblAltura);
		
		txtObservacao = new JTextField();
		txtObservacao.setBounds(324, 147, 114, 19);
		container.getContentPane().add(txtObservacao);
		txtObservacao.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(354, 22, 114, 30);
		container.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(319, 22, 70, 15);
		container.getContentPane().add(lblPeso);
		
		lblObservacao = new JLabel("Observacao");
		lblObservacao.setBounds(331, 115, 70, 15);
		container.getContentPane().add(lblObservacao);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(179, 302, 114, 30);
		container.getContentPane().add(txtCpf);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(194, 279, 70, 15);
		container.getContentPane().add(lblCpf);
		

		
		container.setVisible(true);
		criarConta.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new Cadastro();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}