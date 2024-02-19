import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        Set<Integer> ponketmon = new HashSet<>();
        for(int i=0;i<len;i++){
            ponketmon.add(nums[i]);
        }
        int size = ponketmon.size();
       
        if(size<=len/2)
            return size;
        else
            return len/2;
    }
}