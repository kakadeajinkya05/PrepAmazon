package LongestSubstringWithMUniqueCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMUniqueCharacters {

	public static void main(String[] args) {
		String str = "karappannnn";
		int maxSize = 3;
		findSubString(str,maxSize);
	}
	
	public static void findSubString(String str, int maxSize ){
		Map<Character,Integer> hm = new HashMap<>();
		int start=0,end=0,windowSize =0,windowStart=0;
		hm.put(str.charAt(0), 1);
		for(int i=1;i<str.length();i++){
			char ch = str.charAt(i);
			if(hm.containsKey(ch)){
				hm.put(ch, hm.get(ch)+1);
			}
			else{
				hm.put(ch, 1);
			}
			end++;
			while(!isLessThanMAx(hm, maxSize)){
				int temp = hm.get(str.charAt(start));
				if(temp ==1){
					hm.remove(str.charAt(start));
				}else{
					hm.put(str.charAt(start), temp-1);
				}
				start++;
			}
			if(end-start+1> windowSize){
				windowSize = end - start +1;
				windowStart = start;
			}
		}
		System.out.println(" " + str.substring(windowStart,windowStart+windowSize));
	}

	private static boolean isLessThanMAx(Map<Character, Integer> hash, int maxSize) {
		if (hash.size() > maxSize)
			return false;
		else
			return true;
	}

}
