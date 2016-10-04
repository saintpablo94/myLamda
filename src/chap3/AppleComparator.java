package chap3;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple o1, Apple o2) {
		return (new Integer(o1.getWeight())).compareTo(o2.getWeight());
	}
	
}
