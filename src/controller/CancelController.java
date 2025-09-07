package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainScreen;

public class CancelController {
	private MainScreen frame;

	public CancelController(MainScreen frame) {
		this.frame = frame;
		// TODO Auto-generated constructor stub
	}

	private void cancelPerform() throws Exception {
		try {
			frame.dispose();
		} catch (Exception e) {
			throw e;
		}
	}

	public ActionListener getListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cancelPerform();
				} catch (Exception e1) {
					frame.showErr(e1.getMessage());
				}
			}
		};
	}
}
