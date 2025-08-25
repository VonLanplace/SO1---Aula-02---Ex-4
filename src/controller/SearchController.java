package controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchController {
	private String diretorioBase;
	private JTextField caminhoArquivo;

	public SearchController(JTextField textPath) {
		this.caminhoArquivo = textPath;
		diretorioBase = textPath.getText();

	}

	public void actionPerformed() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "sh");

		if (diretorioBase.isEmpty()) {
			diretorioBase = System.getProperty("user.home") + "/Desktop";
		}

		File dir = new File(diretorioBase);

		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";

		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			this.caminhoArquivo.setText(caminhoArquivo);
		}
	}

	public String getDiretorioBase() {
		return diretorioBase;
	}

	public void setDiretorioBase(String diretorioBase) {
		this.diretorioBase = diretorioBase;
	}

	public JTextField getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(JTextField caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
}
