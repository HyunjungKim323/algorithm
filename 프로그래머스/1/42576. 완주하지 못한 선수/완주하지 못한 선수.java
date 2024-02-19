import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> part = new HashMap<>();
        String answer = "";
        for(int i=0;i<participant.length;i++){
            if(!part.containsKey(participant[i]))
                part.put(participant[i],1);
            else
                part.put(participant[i],part.get(participant[i])+1);
        }
        for(int i=0;i<completion.length;i++){
            part.put(completion[i],part.get(completion[i])-1);
        }
        for(Map.Entry<String,Integer> entry: part.entrySet()){
            if(entry.getValue()==1)
                answer = entry.getKey();
        }
        
        return answer;
        
    }
}