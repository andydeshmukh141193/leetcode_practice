package sliding.window;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q_239_aniket {
    public static void main(String[] args) {
        int[] ans = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3);
        for (int i = 0; i < ans.length;i++)
            System.out.print(ans[i] + "\t");
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        int j = 0;

        // for storing elements in descending order
        // store element and its index
        Queue<int[]> queue = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);

        int[] ans = new int[nums.length- k +1]; // we can use list also. But we can get window array length by using formula
        int index  = 0;
        while( j < nums.length){
            queue.add(new int[]{nums[j],j});

            if( j - i + 1 < k){
                j++;
            } else if ( j - i + 1 == k) {
                // if max element is out of window, remove it, so it will make sure highest element is always in the window size
                while (queue.peek()[1] < i){
                    queue.poll();
                }
                ans[index++] = queue.peek()[0]; // store max element into ans
                i++;
                j++;
            }
        }
        return ans;
    }
}
