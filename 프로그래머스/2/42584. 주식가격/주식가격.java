import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> s = new Stack<>();
        int[] answer = new int[prices.length];
        int nowTime=0;
        for(int i=0;i<prices.length;i++){
            nowTime++;
            while(!s.isEmpty() && prices[i]<s.peek()[0]){
                int[] info = s.pop();
                answer[info[1]-1] = nowTime - info[1]; 
            }
            s.push(new int[] {prices[i],nowTime});
        }
        while(!s.isEmpty()){
            int[] info = s.pop();
                answer[info[1]-1] = nowTime - info[1]; 
        }
        return answer;
        
    }
}