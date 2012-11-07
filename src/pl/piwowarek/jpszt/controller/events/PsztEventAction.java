package pl.piwowarek.jpszt.controller.events;

public interface PsztEventAction {
	abstract public void action(PsztEvent e);
}