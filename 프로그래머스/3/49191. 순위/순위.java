import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] go;
    static ArrayList<Integer>[] back;
    static int goCnt, backCnt;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[] visited = new boolean[n+1];
        go = new ArrayList[n+1];
        back = new ArrayList[n+1];
        for(int i =0;i<=n;i++){
            go[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }
        for(int i=0;i<results.length;i++){
            go[results[i][0]].add(results[i][1]);
            back[results[i][1]].add(results[i][0]);
        }
        
        for(int i=1;i<=n;i++){
            goCnt = 0;
            visited = new boolean[n+1];
            dfsGo(go,i,n,visited);
            backCnt =0;
            visited = new boolean[n+1];
            dfsBack(back,i,n,visited);
            
            if(goCnt+backCnt == n+1)
                answer++;
        }
        
        return answer;
    }
    static void dfsGo(ArrayList<Integer>[] go, int index,int n,boolean[] visited){
        if(!visited[index]){
            visited[index] = true;
            goCnt++;
        }
        for(int i=0;i<go[index].size();i++){
            
            if(!visited[go[index].get(i)]){
                visited[go[index].get(i)] = true;
                goCnt++;
                dfsGo(go,go[index].get(i),n,visited);
            }
        }
    }
    static void dfsBack(ArrayList<Integer>[] go, int index,int n,boolean[] visited){
        if(!visited[index]){
            visited[index] = true;
            backCnt++;
        }
        for(int i=0;i<go[index].size();i++){
            if(!visited[go[index].get(i)]){
                visited[go[index].get(i)] = true;
                backCnt++;
                dfsBack(go,go[index].get(i),n,visited);
            }
        }
    }
    
}