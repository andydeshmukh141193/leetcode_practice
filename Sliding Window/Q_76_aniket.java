package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class Q_76_aniket {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    private static String minWindow(String s, String t) {
        int i = 0;
        int j = 0;

        Map<Character,Integer> map = new HashMap<>();

        for (char c:
             t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int count = map.size();
        int min = Integer.MAX_VALUE;
        String minStr = "";
        while( j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0)
                    count--;
            }

            if(count == 0){
                while(count == 0){
                    if(min > j-i+1){
                        minStr = s.substring(i,j+1);
                        min = j-i+1;
                    }
                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i)) == 1)
                            count++;
                    }
                    i++;
                }
            }
            j++;
        }
        return minStr;
    }
}
