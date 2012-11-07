package pl.piwowarek.jpszt.jsudoku;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import pl.piwowarek.jpszt.controller.Controller;
import pl.piwowarek.jpszt.controller.events.PsztEvent;
import pl.piwowarek.jpszt.model.Model;
import pl.piwowarek.jpszt.view.View;

/**
 * @author Adam Papros, Grzegorz Piwowarek, Pawe³ Piekaruœ
 * 
 */
public class JPszt {

	public static void main(String[] args) {
		Controller controller;

		try {
			final Model model = new Model();
			final BlockingQueue<PsztEvent> blockingQueue = new LinkedBlockingQueue<PsztEvent>();
			final View view = new View(blockingQueue);
			controller = new Controller(view, model, blockingQueue);
			controller.run();
		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

}
