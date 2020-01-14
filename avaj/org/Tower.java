import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tower {

	private ArrayList<Flyable> observers;

	public void register(Flyable flyable) {
		if (this.observers == null)
			this.observers = new ArrayList<Flyable>();
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
			this.observers.remove(flyable);
	}
	protected void conditionsChanged() {
		for (Flyable f : observers) {
			f.updateConditions();
		}
	}
}
