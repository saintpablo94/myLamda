package chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class MainTest {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
					new Dish("pork", false, 800, Type.MEAT),
					new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH)
				);
		
		List<Dish> lowCaloricDishes = new ArrayList<Dish>();
		for(Dish d : menu){
			if(d.getCalories()< 400){
				lowCaloricDishes.add(d);
			}
		}
		
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {

			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});
		
		List<String> lowCaloricDishesName = new ArrayList<>();
		for(Dish d : lowCaloricDishes){
			lowCaloricDishesName.add(d.getName());
		}
		
		System.out.println(lowCaloricDishesName);
		
		List<String> lowCaloricDishesNameLamda = 
				menu.stream()
					.filter(d -> d.getCalories() < 400)
					.sorted(comparing(Dish::getCalories))
					.map(Dish::getName)
					.collect(toList());
		System.out.println(lowCaloricDishesNameLamda);
		
		List<String> threeHighCaloricDishNames = 
				menu.stream()
					.filter(d-> d.getCalories() > 300)
					.sorted(comparing(Dish::getCalories))
					.map(Dish::getName)
					.limit(3)
					.collect(toList());
		System.out.println(threeHighCaloricDishNames);
	}

}
