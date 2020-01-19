package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
		super.type = "JetPlane";
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
				c.changeLatitude(10);
				c.changeHeight(2);
				if (c.getHeight() > 100)
					c.setHeight(100);
				super.weatherMessage("OMG! Summer is coming!\n");
				break;
			case "RAIN":
				c.changeLatitude(5);
				super.weatherMessage("It's raining. Better watch out for lightings.\n");
				break;
			case "FOG":
				c.changeLatitude(1);
				super.weatherMessage("It's foggy. Better watch out for crash.\n");
				break;
			case "SNOW":
				c.changeHeight(-7);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					this.weatherTower.unregister(this);
					super.landingMessage();
				}
				else
					super.weatherMessage("OMG! Winter is coming!\n");
				break;
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		super.registerMessage();
	}
}
