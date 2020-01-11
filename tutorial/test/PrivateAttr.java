class Dog {
	private String name;
	Dog(){
		this.name = "Somee";
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class PrivateAttr {
	public static void main (String []args) {
		Dog d = new Dog();
		d.setName("Juno");
		System.out.println(d.getName());
	}
}
