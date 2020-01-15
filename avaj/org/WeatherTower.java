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
