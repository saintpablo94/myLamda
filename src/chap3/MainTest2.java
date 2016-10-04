package chap3;

import java.util.*;

import chap3.Apple;

public class MainTest2 {

	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(new Apple("red", 100), new Apple("blue", 80), new Apple("green", 250));

		Comparator<Apple> byWeight = new Comparator<Apple>() {
			
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight();
			}
		};

	}
}
