package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		super.type = "Baloon";
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
				c.changeLongitude(2);
				c.changeHeight(4);
				if (c.getHeight() > 100)
					c.setHeight(100);
				super.weatherMessage("Let's enjoy the good weather and take some pics.\n");
				break;
			case "RAIN":
				c.changeHeight(-5);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					this.weatherTower.unregister(this);
					super.landingMessage();
				}
				else
					super.weatherMessage("Damn you rain! You messed up my baloon.\n");
				break;
			case "FOG":
				c.changeHeight(-3);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					this.weatherTower.unregister(this);
					super.landingMessage();
				}
				else
					super.weatherMessage("Damn you fog! You blinded my sight.\n");
				break;
			case "SNOW":
				c.changeHeight(-15);
				if (c.getHeight() <= 0) {
					c.setHeight(0);
					this.weatherTower.unregister(this);
					super.landingMessage();
				}
				else
					super.weatherMessage("It's snowing. We're  gonna crash.\n");
				break;
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		super.registerMessage();
	}
}
