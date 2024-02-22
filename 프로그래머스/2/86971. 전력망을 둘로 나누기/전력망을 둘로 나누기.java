import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] adj;
    static Queue<Integer> q;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        adj = new int[n+1][n+1];        
        visited = new boolean[n+1];
        q = new ArrayDeque<>();
        for(int i=0;i<wires.length;i++){
            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i=0;i<wires.length;i++){
            adj[wires[i][0]][wires[i][1]] = 0;
            adj[wires[i][1]][wires[i][0]] = 0;
            answer = Math.max(bfs(n),answer);
            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }
        
        return Math.abs(n-2*answer);
    }
    
    static int bfs(int n){
        visited = new boolean[n+1];
        q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        int count = 1;
        while(!q.isEmpty()){
            int index= q.poll();
            for(int i=1;i<=n;i++){
                if(!visited[i] && adj[index][i]==1){
                    q.offer(i);
                    count++;
                    visited[i] = true;
                }
            }
        }
        if(2*count<=n){
            return count;
        }else{
            return n-count;
        }
    }
}