package w13;

public class Item {
	private String name;
	private String description;
	private int weight;
	
	Item(String n, String d, int w){
		name = n;
		description = d;
		weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getLongDescription() {
		return name + " (" + weight + "Kg, " + description + ")";
	}
}
