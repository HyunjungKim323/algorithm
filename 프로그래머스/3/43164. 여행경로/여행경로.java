import java.util.*;

class Solution {
    static String[] airArray;
    static boolean[] visited;
    static int first =0;
    static Map<Integer,String[]> map;
    public String[] solution(String[][] tickets) {
        Set<String> airport = new HashSet<>();
        map = new HashMap<>();
        for (int i=0; i<tickets.length; i++){
            airport.add(tickets[i][0]);
            airport.add(tickets[i][1]);
        }
        airArray = airport.toArray(new String[airport.size()]);
        Arrays.sort(airArray);
        Arrays.sort(tickets,(o1,o2)->{
            if(o1[0].compareTo(o2[0])==0)
                return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        
        
        String[] answer = {};
        
        for(int i=0;i<airArray.length;i++){
            visited = new boolean[tickets.length];
            answer = new String[tickets.length+1];
            dfs(tickets,i,0,answer);
        } 
        for(Map.Entry<Integer,String[]> entry : map.entrySet()){
            int num = entry.getKey();
            String[] please = entry.getValue();            
        }
        
        return map.get(0);
    }
    
    static void dfs(String[][] tickets, int index,int depth,String[] answer){
        if(depth ==0){
            if(!airArray[index].equals("ICN"))
                return;
        }
        answer[depth] = airArray[index];
        if(depth == tickets.length ){
            map.put(first++,Arrays.copyOf(answer, answer.length));
            return; 
        }
        for(int i=0;i<airArray.length;i++){
            for(int j=0;j<tickets.length;j++){
                if (!visited[j] && airArray[index].equals(tickets[j][0]) &&  airArray[i].equals(tickets[j][1])){
                    visited[j] = true;
                    dfs(tickets,i,depth+1,answer);
                    visited[j] = false;
                }
            }    
        }
    }
}