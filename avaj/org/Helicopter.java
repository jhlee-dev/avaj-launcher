import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String type;

	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
		type = "Helicopter";
	}
	private void logMessage(String message) {
		String type = this.getType();
		String name = this.name;
		long id = this.id;
		String format = type + "#" + name + "(" + id + "): ";

		FileWriter myWriter = new FileWriter("simulation.txt", true);
		myWriter.write(format + message);
		myWriter.close();
	}
	@Override
	public void updateConditions() {
		Coordinates c = super.coordinates;
		String weather = this.weatherTower.getWeather(c);

		switch (weather) {
			case "SUN":
				c.changeLongitude(10);
				c.changeHeight(2);
				if (c.getHeight() > 100)
                c.setHeight(100);
				this.logMessage("This is hot.");
				break;
			case "RAIN":
				c.changeLongitude(5);
				this.logMessage("This is wet.");
				break;
			case "FOG":
				c.changeLongitude(1);
				this.logMessage("I can't see anything!");
				break;
			case "SNOW":
				c.changeHeight(-12);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					weatherTower.unregister(this);
				}
				else
					this.logMessage("My rotor is going to freeze!");
				break;
		}
	}
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
	public String getType() {
		return this.type;
	}
}
