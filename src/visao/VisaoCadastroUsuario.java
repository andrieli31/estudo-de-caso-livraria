package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.LivroDAO;
import controle.PessoaDAO;
import modelo.Livro;
import modelo.Pessoa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class VisaoCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private static DefaultTableModel modelo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroUsuario frame = new VisaoCadastroUsuario();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisaoCadastroUsuario() {
		setTitle("Cadastro Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 1144);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		PessoaDAO daoPessoa = PessoaDAO.getInstancia();

		JLabel lblNewLabel = new JLabel("Dados dos Usuários");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);

		MaskFormatter mascaraCpf = null;

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setForeground(new Color(255, 255, 255));

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSobrenome.setForeground(new Color(255, 255, 255));

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setForeground(new Color(255, 255, 255));

		JButton btnNewButton = new JButton("Cadastrar Usuário");

		btnNewButton.addActionListener(new ActionListener() {
			/// colocar anos de edição dos livros e diminuir 1
//int ano= LocalDate.now().getYear();
			// for(int i = 0; i<ano; i++) {
			// cbNomes.addItem(String.valueOf(ano));
			// }

			@Override
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				PessoaDAO dao = PessoaDAO.getInstancia();

				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				Long cpf = Long.parseLong(txtCpf.getText());

				pessoa.setNome(nome);
				pessoa.setSobrenome(sobrenome);
				pessoa.setCpf(cpf);
				pessoa.setEmail(txtEmail.getText());
				pessoa.setSenha(txtSenha.getText());

				txtNome.setText(null);
				txtSobrenome.setText(null);
				txtCpf.setText(null);
				txtSenha.setText(null);
				txtEmail.setText(null);
				dao.cadastrarPessoa(pessoa);
			}

		});

		btnNewButton.setForeground(new Color(0, 64, 128));

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnListaUsuario = new JButton("Listar Usuários");
		btnListaUsuario.setForeground(new Color(0, 64, 128));

		btnListaUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				atualiza();
			}

		});
		btnListaUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_2 = new JButton("Excluir Usuário");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		btnNewButton_2.setForeground(new Color(0, 64, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_3 = new JButton("Alterar Usuário");
		btnNewButton_3.setForeground(new Color(0, 64, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnNewButton_4 = new JButton("Voltar a Tela Inicial");
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisaoTelaInicial frame = new VisaoTelaInicial();
				frame.setVisible(true);
				dispose();
			}

		});
		btnNewButton_4.setForeground(new Color(0, 64, 128));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel("email:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtSenha = new JPasswordField();

		JScrollPane scrollPane = new JScrollPane();
		modelo = new DefaultTableModel();
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		table.setModel(modelo);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCpf, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnNewButton)
												.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
												.addComponent(btnListaUsuario, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblSobrenome, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
													.addComponent(lblNewLabel_6)
													.addComponent(lblNewLabel_5))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(txtSobrenome, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
													.addComponent(txtNome, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
													.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
													.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
													.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
											.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
										.addGap(197)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
									.addGap(273)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)))
							.addGap(28))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome)
									.addGap(24)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSobrenome)
										.addComponent(txtSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(21)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCpf)
										.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6))
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnListaUsuario)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(114)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(317))
		);
		contentPane.setLayout(gl_contentPane);

		modelo.addColumn("Nome");
		modelo.addColumn("Sobrenome");
		modelo.addColumn("CPF");

	}

	public static void atualiza() {

		PessoaDAO dao = PessoaDAO.getInstancia();
		ArrayList<Pessoa> listaPessoas = dao.listarPessoas();

		modelo.getDataVector().removeAllElements();

		for (int i = 0; i < listaPessoas.size(); i++) {
			Pessoa p = listaPessoas.get(i);
			modelo.addRow(new Object[] { p.getNome(), p.getSobrenome(), p.getCpf() });
		}
	}
}