package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AircraftFactory {
	
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		if (height > 100 || height < 0) {
			try {
				FileWriter myWriter = new FileWriter("simulation.txt", true);
				myWriter.write("Failed to register " + type + "#" + name + " to weather tower due to the height limit\n");
				myWriter.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			} finally {
				return null;
			}
		}		
		Coordinates c = new Coordinates(longitude, latitude, height);
		switch (type) {
			case "Helicopter":
				return new Helicopter(name, c);
			case "JetPlane":
				return new JetPlane(name, c);
			case "Baloon":
				return new Baloon(name, c);
		}
		return null;
	};
}
