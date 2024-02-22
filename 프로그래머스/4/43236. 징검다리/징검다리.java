import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int ans = 0;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance /(rocks.length+1-n);
        while(left<=right){
            int mid = (left+right)/2;
            if(numRock(rocks,mid,distance)>= rocks.length-n){
                left = mid+1;
                ans = mid;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
    static int numRock(int[] array, int len,int distance){
        int nowPos = 0;
        int count = 0;
        while(true){
            int toEnd = distance - nowPos;
            nowPos = pos(array,nowPos+len);
            if(nowPos==-1){
                if(toEnd<len)
                    count--;
                break;
            }
            count++;
        }
        return count;
    }
    
    static int pos(int[] array,int target){
        int left = 0;
        int right = array.length -1;
        int ans = -1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(array[mid]>=target){
                ans = array[mid];
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;       
    }
}
