import java.util.*;

class Solution {
    static Queue<String> q ;
    static boolean[] visited;
    static int count =0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        q = new ArrayDeque<>();
        q.offer(begin);
        return bfs(words,target);
    
    }
    
    static int bfs(String[] words, String target){
        while(!q.isEmpty()){
            int len = q.size();
            count++;
            for(int i=0;i<len;i++){
                String now = q.poll();
                for(int j=0;j<words.length;j++){
                    if(change(now,words[j]) && !visited[j]) {
                        visited[j] = true;
                        q.offer(words[j]);
                        if(target.equals(words[j]))
                           return count;
                    }
                }
            }
        }
        return 0;
    }
    
    static boolean change(String begin, String target){
        int count = 0;
        for(int i=0;i<begin.length(); i++){
            if(begin.charAt(i)!=target.charAt(i)){
                count++;
                if(count>=2)
                    return false;
            }
        }
        return true;
    }
}