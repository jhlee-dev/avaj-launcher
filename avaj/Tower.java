import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tower {

	private Flyable observers;

	public void register(Flyable flyable) {
		this.observers = flyable;
		
		String type = observers.getType();
		String name = observers.name;
		long id = observers.id;
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
		this.observers = null;
	}
	protected void conditionsChanged() {
		observers.updateConditions();
	}
}
