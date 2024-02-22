import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    static Queue<Integer> q ;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        q = new ArrayDeque<>();
        
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                System.out.println(i);
                count++;
                q.offer(i);
            }
            bfs(computers, n);
        }
        return count;
    }
    
    static void bfs(int[][] computers, int n){
        while(!q.isEmpty()){
            int index = q.poll();
            for(int i=0;i<n;i++){
                if(!visited[i] && computers[index][i]==1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
            
        }
    }
}