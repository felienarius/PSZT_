package pl.piwowarek.jpszt.view;

import java.util.concurrent.BlockingQueue;


import javax.swing.JFrame;

import pl.piwowarek.jpszt.controller.events.PsztEvent;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public View(BlockingQueue<PsztEvent> blockingQueue) {
		// TODO Auto-generated constructor stub
		
		this.setSize(640, 480);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
}
