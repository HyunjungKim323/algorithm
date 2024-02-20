import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0)
        		q.offer((100-progresses[i])/speeds[i]);
        	else 
        		q.offer(((100-progresses[i])/speeds[i])+1);
        }
        
        int[] ans = new int[progresses.length]; 
        int index =0;
        
        ans[0] = 1;
        int prev = q.poll();
        
        for(int i=1;i<progresses.length;i++){
            int now = q.poll();
            if(now > prev){
                index++;
                ans[index]=1;
                prev = now; 
            }else{
                ans[index]++;
            }
        }
        int[] real = new int[index+1];
        for(int i=0;i<index+1;i++){
            real[i] =ans[i];
        }
        return real;
    }
}