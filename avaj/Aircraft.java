public class Aircraft {
	protected long id;
	protected String name;
	protected final Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}
	private long nextId() {
		return idCounter++;
	}
}
