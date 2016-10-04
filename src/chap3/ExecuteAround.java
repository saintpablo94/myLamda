package chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class ExecuteAround {

	public static void main(String[] args) throws IOException {
		
		String line = prcessFile((BufferedReader b) -> {return b.readLine();});
		System.out.println(line);
		
		String oneLine = prcessFile((BufferedReader br)-> br.readLine());
		System.out.println(oneLine);
		
		String twoLine = prcessFile((BufferedReader br)-> br.readLine() + br.readLine());
		System.out.println(twoLine);
		
		forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));
		
		Predicate<String> nonEmptyStringPredicate = (String s) -> s.isEmpty();
		
		IntPredicate eventNum = (int i ) -> i%2 == 0 ;
		System.out.println(eventNum.test(1000));
		
		Predicate<Integer> oddNum = (Integer i ) -> i%2 == 1 ;
		System.out.println(oddNum.test(1000));
	}

	private static String prcessFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			return p.process(br);
		}
	}
	
	private static <T> void forEach(List<T> list, Consumer<T> c){
		for(T t: list){
			c.accept(t);
		}
	}

}
