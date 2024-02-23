import java.util.*;

class Solution {
    static Queue<int[]> q;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        
        adj = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n+1];
        visited[1] = true;
        for(int i=0;i<edge.length;i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        answer = bfs(edge,n);
        
        return answer;
    }
    static int bfs(int[][] edge, int n){
        int len=0;
        while(!q.isEmpty()){
            len = q.size();
            for(int l=0;l<len;l++){
                int[] t = q.poll();
                int nowPos = t[0];
                int time = t[1];
                for(int i=0;i<adj[nowPos].size();i++){
                    if(!visited[adj[nowPos].get(i)]){
                        visited[adj[nowPos].get(i)] = true;
                        q.offer(new int[]{adj[nowPos].get(i),time+1});
                    }
                }
            }
        }
        return len;
    }
}