package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CancelController {
	public CancelController(JFrame frame) {
		// TODO Auto-generated constructor stub
	}

	private void cancelPerform() {
		System.out.println(true);
		// TODO
	}

	public ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelPerform();
			}
		};
	}
}
