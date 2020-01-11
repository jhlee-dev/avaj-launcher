class JetPlane extends Aircraft implements Flyable {

	WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {}
	@Override
	public void updateConditions() {}
	@Override
	public void registerTower(WeatherTower weatherTower) {}
}
