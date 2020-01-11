class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		Coordinates c = new Coordinates(longitude, latitude, height);
		if (type == "Helicopter")
			return new Helicopter(name, c);
		else if (type == "JetPlane")
			return new JetPlane(name, c);
		else if (type == "Baloon")
			return new Baloon(name, c);
	};
}
