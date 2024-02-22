class Solution {
    static boolean[] visited ;
    static int count = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return count;
    }
    
    static void dfs(int k, int[][] dungeon,int depth){
        if(depth==dungeon.length) return;
        for(int i=0;i<dungeon.length;i++){
            if(!visited[i] && k>= dungeon[i][0]){
                
                visited[i] = true;
                dfs(k-dungeon[i][1],dungeon,depth+1);
                count = Math.max(count,depth+1);
                visited[i] = false;
            }    
        }
    }
}