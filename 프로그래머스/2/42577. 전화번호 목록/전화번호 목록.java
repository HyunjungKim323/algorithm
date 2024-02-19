import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String,Integer> hash = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            String s =phone_book[i];
            
            if(!hash.containsKey(s)){
                hash.put(s,1);
            }
        }
        
        for(int i=0;i<phone_book.length;i++){
            String phone_num = phone_book[i];
            
            for(int j=0;j<phone_num.length();j++){
                String prefix = phone_num.substring(0,j);
                
                if(hash.containsKey(prefix) )
                    return false;
            }
        }
        return true;
    }
}