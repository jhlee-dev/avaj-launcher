import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		this.observers.add(flyable);
		String type = flyable.getType();
		String name = flyable.name;
		long id = flyable.id;
		String message = "Tower says: " + type + "#" + name + "(" + id + "): registered to weather tower."	
		try {
			FileWriter myWriter = new FileWriter("simulation.txt", true);
			myWriter.write(message);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public void unregister(Flyable flyable) {
		int i = this.observers.indexOf(flyable);
		if (i >= 0)
			this.observers.remove(i);
	}
	protected void conditionsChanged() {
		for (Flyable o : observers) {
			o.updateConditions();
		}
	}
}
