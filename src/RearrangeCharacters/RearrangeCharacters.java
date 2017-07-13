package RearrangeCharacters;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RearrangeCharacters {
	
	static class CharCount implements Comparable<CharCount>{
		char c;
		int count;
		CharCount(char c , int count ){
			this.c = c;
			this.count = count;
		}
		@Override
		public int compareTo(CharCount o) {
			return  o.count - this.count;
		}
		
		@Override
		public String toString() {
			return c + " "+ count;
		}
	}
	public static void main(String[] args) {
		String str = "aaabbcccccccd";
		Stream<Character> charStream = str.chars().mapToObj(i->(char)i);
		Map<Character, Long> countByChar =   charStream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		PriorityQueue<CharCount> pq = new PriorityQueue<>();
		countByChar.forEach((key,value) -> {
			int count = value.intValue();
			pq.add(new CharCount(key, count));
		});
		System.out.println(pq);
		CharCount prev = new CharCount('$', -1);
		StringBuilder result = new StringBuilder();
		while(!pq.isEmpty()){
			CharCount cc = pq.remove();
			result.append(cc.c);
			System.out.print(cc.c + " ");
			if(prev.count>0){
				pq.add(prev);
			}
			cc.count --;
			prev = cc;
		}
		if(str.length() == result.length()){
			System.out.println("Solution found");
		}else{
			System.out.println("Not possible");
		}
		
	}
}
