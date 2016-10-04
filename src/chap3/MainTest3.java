package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainTest3 {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("red",100),
											  new Apple("blue",120),
											  new Apple("black",140));
		
		Predicate<Apple> redAppleFilter = (Apple a) -> "red".equals(a.getColor());
		Predicate<Apple> notredAppleFilter = redAppleFilter.negate();
		Predicate<Apple> redAndHeavyFilter = redAppleFilter.and( a -> a.getWeight() > 100);
		
		
		
		System.out.println("before : \n"+ inventory);
		List<Apple> redApple = filter(inventory, redAppleFilter);
		System.out.println("redApple after :\n"+ redApple);
		List<Apple> notRedApple = filter(inventory, notredAppleFilter);
		System.out.println("notRedApple after :\n"+ notRedApple);
		List<Apple> redAndHeavy = filter(inventory, redAndHeavyFilter);
		System.out.println("notRedApple after :\n"+ redAndHeavy);
	}

	private static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T e : list){
			if(p.test(e)){
				result.add(e);
			}
		}
		return result;
	}
	
}

