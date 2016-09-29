package chap3;

public class AppleBasicFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of "+ apple.getWeight()+"g";
	}
}
