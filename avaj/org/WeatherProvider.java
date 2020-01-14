import java.util.Random;

class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {
	}
	public static WeatherProvider getProvider() {
		return this.weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();

		Random r = new Random();
		return this.weather[(longitude * latitude * height + r.nextInt(100)) % 4];
	}
}
