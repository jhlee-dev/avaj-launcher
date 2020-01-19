package org.us._42.avaj.aircraft;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

public interface Flyable {

	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}
