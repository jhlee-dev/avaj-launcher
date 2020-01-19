package org.us._42.avaj;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		WeatherProvider wp = WeatherProvider.getProvider();
		return (wp.getCurrentWeather(coordinates));
	}
	void changeWeather() {
		WeatherProvider.resetProvider();
		super.conditionsChanged();
	}
}
