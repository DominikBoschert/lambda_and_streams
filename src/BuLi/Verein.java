package BuLi;

public class Verein {
	private int vereins_ID;
	private String name;
	
	public Verein(int vereins_ID, String name) {
		this.vereins_ID = vereins_ID;
		this.name = name;
	}

	public int getVereins_ID() {
		return vereins_ID;
	}

	public String getName() {
		return name;
	}
	
	
}
