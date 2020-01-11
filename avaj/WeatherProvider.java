class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String weather;

	WeatherProvider() {
		this.weatherProvider = new WeatherProvider();
	}
	public static WeatherProvider getProvider() {
		return this.weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates) {
		return this.weather;
	}
}
