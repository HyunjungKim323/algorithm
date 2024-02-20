import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int nowTime = 0;
        int total = 0;
        Queue<int[]> bridge = new ArrayDeque<>();
        
        for(int i=0;i<truck_weights.length;i++){
            nowTime++;
            
            if(!bridge.isEmpty() && nowTime-bridge.peek()[1]>=bridge_length){
                total-=bridge.peek()[0];
                bridge.poll();
            }
            if(total+truck_weights[i]<=weight){
                //더했는데 안넘으면 nowTime에 맞게 넣기
                bridge.add(new int[]{truck_weights[i],nowTime});
                total+=truck_weights[i];
            }
            else{
                //더했는데 넘으면 다빼고 넣기
                while(total+truck_weights[i]>weight){
                    nowTime++;
                    if(nowTime-bridge.peek()[1]>=bridge_length){
                        total-=bridge.peek()[0];
                        bridge.poll();
                    }
                }
                bridge.offer(new int[]{truck_weights[i],nowTime});
                total+=truck_weights[i];
            }
        }        
        while(!bridge.isEmpty()){
            nowTime++;
            if(nowTime-bridge.peek()[1]>=bridge_length){
                total-=bridge.peek()[0];
                bridge.poll();
            }
        }
        return nowTime;
    }
}