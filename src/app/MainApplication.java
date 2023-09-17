package app;

import java.awt.EventQueue;

import views.MenuPrincipal;

public class MainApplication {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
