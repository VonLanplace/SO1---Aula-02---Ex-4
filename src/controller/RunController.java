package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunController {

	public RunController(JTextField textPath, JFrame frame) {
		// TODO Auto-generated constructor stub
	}

	private void runPerform() {
		System.out.println(false);
		// TODO
	}

	public ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runPerform();
			}
		};
	}
}
