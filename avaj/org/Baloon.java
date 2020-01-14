class Baloon extends Aircraft implements Flyable {
	WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.weatherTower = new WeatherTower();
	}
	
	@Override
	public void updateConditions() {
		weatherTower.
	}
	@Override
	public void registerTower(WeatherTower weatherTower) {
		weatherTower.
	}
}
