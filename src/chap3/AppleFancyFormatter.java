package chap3;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		String weightType = apple.getWeight()>150?"heavy":"light";
		return "A "+weightType+" "+apple.getColor()+" apple";
	}

}
