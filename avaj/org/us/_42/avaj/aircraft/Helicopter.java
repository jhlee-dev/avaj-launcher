package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
		super.type = "Helicopter";
	}

	@Override
	public void updateConditions() {
		Coordinates c = super.coordinates;
		String weather = this.weatherTower.getWeather(c);
		if (c.getHeight() <= 0) {
            c.setHeight(0);
            this.weatherTower.unregister(this);
            super.landingMessage();
        }
		switch (weather) {
			case "SUN":
				c.changeLongitude(10);
				c.changeHeight(2);
				if (c.getHeight() > 100)
                	c.setHeight(100);
				super.weatherMessage("This is hot.\n");
				break;
			case "RAIN":
				c.changeLongitude(5);
				super.weatherMessage("This is wet.\n");
				break;
			case "FOG":
				c.changeLongitude(1);
				super.weatherMessage("I can't see anything!\n");
				break;
			case "SNOW":
				c.changeHeight(-12);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					this.weatherTower.unregister(this);
					super.landingMessage();
				}
				else
					super.weatherMessage("My rotor is going to freeze!\n");
				break;
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		super.registerMessage();
	}
}
