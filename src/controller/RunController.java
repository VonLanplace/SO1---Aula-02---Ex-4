package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunController {
	JTextField textPath;

	public RunController(JTextField textPath, JFrame frame) {
		this.textPath = textPath;
		// TODO Auto-generated constructor stub
	}

	private void runPerform() {
		try {
			String[] command = textPath.getText().split(" ");
			Process process = Runtime.getRuntime().exec(command);

		} catch (Exception e) {
			String msg = e.getMessage();

			if (msg.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(textPath.getText());
				runPerform();

			} else {
				System.err.println(msg);
			}
		}
	}

	public ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					runPerform();
				} catch (Exception er) {
					// TODO: handle exception
				}
			}
		};
	}
}
