package org.us._42.avaj;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
	private static int rand;

	private WeatherProvider() {
		Random r = new Random();
		this.rand = r.nextInt(100);
	}
	public static WeatherProvider getProvider() {
		return weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();

		return this.weather[(longitude * latitude * height + longitude + latitude + height + this.rand) % 4];
	}
	public static void resetProvider() {
		Random r = new Random();
		rand = r.nextInt(100);
	}
}
