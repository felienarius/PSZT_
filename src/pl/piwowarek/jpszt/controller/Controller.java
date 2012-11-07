package pl.piwowarek.jpszt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.swing.Timer;

import pl.piwowarek.jpszt.controller.events.*;
import pl.piwowarek.jpszt.model.Model;
import pl.piwowarek.jpszt.view.View;


public class Controller {

	private final View view;
	private final Model model;
	private final BlockingQueue<PsztEvent> blockingQueue;

	/** for mapping custom event classes with their corresponding actions */
	private final Map<Class<? extends PsztEvent>, PsztEventAction> eventActionMap;
	private final Timer timer;

	/**
	 * Initializes application by connecting View and Model with a
	 * BlockingQueue. Initializes timer
	 * 
	 * @param view
	 * @param model
	 * @param blockingQueue
	 */
	public Controller(final View view, final Model model,
			final BlockingQueue<PsztEvent> blockingQueue) {
		this.view = view;
		this.model = model;
		this.blockingQueue = blockingQueue;

		/*puts TimeEvent into blockingQueue every second*/
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				try {
					blockingQueue.put(new TimeEvent());
				} catch (final Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		});

		eventActionMap = new HashMap<Class<? extends PsztEvent>, PsztEventAction>();
		mapActionEvents();
	}

	/**
	 * Starts the application
	 * 
	 */
	public void run() {
		while (true) {
			try {
				final PsztEvent event = blockingQueue.take();
				final PsztEventAction sudoAction = eventActionMap.get(event
						.getClass());
				sudoAction.action(event);
			} catch (final Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	
	/**
	 * Maps custom event classes with their corresponding actions
	 */
	private void mapActionEvents() {

		
	}

	}


