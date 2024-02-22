import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        answer = time(n,times);
        return answer;
    }
    static long time(int n , int[] times){
        long left = 1L;
        long right = (long)times[times.length-1] * n ;
        long ans = (long)times[times.length-1] * n;
        
        while(left <= right){
            long mid = (left+right)/2;
            if(people(mid,times)>=n){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    static long people(long time, int[] times){
        long sum= 0;
        for(int i=0;i<times.length;i++){
            sum += time / times[i];
        }
        return sum;
    }
}