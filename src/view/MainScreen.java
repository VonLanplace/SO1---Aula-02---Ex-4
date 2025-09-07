package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CancelController;
import controller.RunController;
import controller.SearchController;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPath;
	private JLabel lblTitle, lblAbrir;
	private JButton btnOk, btnCancel, btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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

	public MainScreen() {
		setTitle("Executar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Digite o caminho do executável ou clique em procurar");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(143, 12, 341, 17);
		contentPane.add(lblTitle);

		btnOk = new JButton("Ok");
		btnOk.setBounds(142, 85, 106, 27);
		contentPane.add(btnOk);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(260, 85, 106, 27);
		contentPane.add(btnCancel);

		btnSearch = new JButton("Procurar");
		btnSearch.setBounds(378, 85, 106, 27);
		contentPane.add(btnSearch);

		textPath = new JTextField();
		textPath.setText(System.getProperty("user.home") + "/Desktop");
		textPath.setBounds(184, 52, 300, 21);
		contentPane.add(textPath);
		textPath.setColumns(10);

		lblAbrir = new JLabel("Abrir:");
		lblAbrir.setBounds(144, 54, 40, 17);
		contentPane.add(lblAbrir);

		SearchController busca = new SearchController(textPath);
		btnSearch.addActionListener(busca.getListener());

		RunController run = new RunController(textPath, this);
		btnOk.addActionListener(run.getListener());

		CancelController cancel = new CancelController(this);
		btnCancel.addActionListener(cancel.getListener());
	}

	public void showErr(String e) {
		String[] e1 = e.split(":");
		StringBuffer message = new StringBuffer();
		for (String linha : e1) {
			message.append(linha).append(":\n").append("\t");
		}
		JOptionPane.showMessageDialog(this, message.toString(), "Erro de Processamento", JOptionPane.ERROR_MESSAGE);
	}
}
