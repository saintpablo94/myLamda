package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		
		List<Apple> inventory = Arrays.asList(new Apple("red",100),
											  new Apple("blue",80),
											  new Apple("green",250)
				);
		
		System.out.println(filterGreenApple(inventory));
		System.out.println(filterAppleByColor(inventory, "blue"));
		System.out.println(filterApple(inventory, new AppleHeavyWeightPredicate()));
		prettyPrintApple(inventory, new AppleBasicFormatter());
		prettyPrintApple(inventory, new AppleFancyFormatter());
		
		List<Apple> readApples = filterApple(inventory, new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});
		
		System.out.println(readApples);
			
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter p ){
		for(Apple apple : inventory){
			String output = p.accept(apple);
			System.out.println(output);
		}
	}
	
	public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterGreenApple(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterAppleByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

}
