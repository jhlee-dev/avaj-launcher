class Aircraft {
	final Coordinates c;
	Aircraft(Coordinates c) {
		this.c = c;
	}
}

public class Coordinates {
    private int longitude;
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
	public static void main(String[] args) {
		Coordinates c = new Coordinates(50, 50, 50);
		c.changeLongitude(-10);
		System.out.println(c.getLongitude());
		Aircraft a = new Aircraft(c);
		System.out.println(a.c.getLatitude());
		a.c.changeLatitude(-15);
		System.out.println(a.c.getLatitude());
	}
}
