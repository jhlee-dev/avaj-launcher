class Human {
	protected String type;
	Human() {
		this.type = "animal";
	}
}

class Juno extends Human {

}

class Inherit {
	public static void main(String[] args) {
        Juno j = new Juno();
        System.out.println(j.type);
    }
}
