import java.util.*;
class Solution {
    
    static Queue<int[]> q;
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        q = new ArrayDeque<>();
        q.offer(new int[] {0,0,1});
        visited =new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        return bfs(maps);
    }
    static int bfs(int[][] maps){
        while(!q.isEmpty()){
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            int time = t[2];
            for(int i=0;i<4;i++){
                int nx= x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,time+1});
                    if(nx==maps.length-1 && ny==maps[0].length-1)
                        return time+1;
                }
            }
            
        }
        return -1;
    }
}