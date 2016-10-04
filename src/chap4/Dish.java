package chap4;

public class Dish {
	private  String name;
	private  int calories;
	private  boolean vegetarian;
	private  Type type;

	public Dish(String name, boolean vegetarian, int calories,  Type type) {
		this.name = name;
		this.calories = calories;
		this.vegetarian = vegetarian;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getCalories() {
		return calories;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + ", vegetarian=" + vegetarian + ", type=" + type + "]";
	}
}
