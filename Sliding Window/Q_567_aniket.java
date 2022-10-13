package sligingwindow;

import java.util.HashMap;
import java.util.Map;

public class Q_567_aniket {

	public static void main(String[] args) {
		System.out.println(checkInclusion("abc","aaaaabbbbbbc"));

	}
	
	 private static boolean checkInclusion(String s1, String s2) {
	
		int i = 0;
		int j = 0;
		
		Map<Character,Integer> map = new HashMap<>();
		
		for(char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int count = map.size();
		int k = s1.length();
		
		while(j < s2.length()) {
			
			if(map.containsKey(s2.charAt(j))) {
				map.put(s2.charAt(j), map.get(s2.charAt(j))-1);
				if(map.get(s2.charAt(j)) == 0)
					count--;
			}
			if(j-i+1 < k) {
				j++;
			}else {
				if(count == 0)
					return true;
				
				if(map.containsKey(s2.charAt(i))) {
					map.put(s2.charAt(i), map.get(s2.charAt(i))+1);
					if(map.get(s2.charAt(i)) == 1)
						count++;
				}
				i++;
				j++;
			}
		}
		
		if(count == 0 && j-i == k)
			return true;
		
		return false;
	 }

}
