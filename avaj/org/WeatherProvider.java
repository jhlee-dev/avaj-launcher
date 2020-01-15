import java.util.Random;

class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
	private static int rand;

	private WeatherProvider() {
		Random r = new Random();
		this.rand = r.nextInt(100);
	}
	public static WeatherProvider getProvider() {
		return this.weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();

		return this.weather[(longitude * latitude * height + this.rand) % 4];
	}
	public static void resetProvider() {
		Random r = new Random();
		this.rand = r.nextInt(100);
	}
}
