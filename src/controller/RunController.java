package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.MainScreen;

public class RunController {
	private JTextField textPath;
	private MainScreen frame;

	public RunController(JTextField textPath, MainScreen frame) {
		this.textPath = textPath;
		this.frame = frame;
		// TODO Auto-generated constructor stub
	}

	private void runPerform() throws Exception {
		try {
			frame.setVisible(false);
			String[] command = textPath.getText().split(" ");
			Runtime.getRuntime().exec(command);
			frame.dispose();

		} catch (Exception e) {
			String msg = e.getMessage();

			if (msg.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(textPath.getText());
				runPerform();

			} else {
				throw e;
			}
		}
	}

	public ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					runPerform();
				} catch (Exception e1) {
					frame.showErr(e1.getMessage());
					frame.setVisible(true);
				}
			}
		};
	}
}
