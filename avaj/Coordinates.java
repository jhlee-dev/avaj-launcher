public class Coordinates {
	private int	longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	public int getLongitude() {
		return longitude;	
	}
	public int getLatitude() {
		return latitude;
	}
	public int getHeight() {
		return height;
	}
	public void changeLongitude(int change) {
		this.longitude +=  change;
	}
	public void changeLatitude(int change) {
		this.latitude += change;
	}
	public void changeHeight(int change) {
		this.height += change;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
