import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        Map<Character, Integer> alpha = new HashMap<>();
        alpha.put('A',0);
        alpha.put('E',1);
        alpha.put('I',2);
        alpha.put('O',3);
        alpha.put('U',4);
        
        if(word.length()==5){
            answer = alpha.get(word.charAt(0))*781 + 1+ alpha.get(word.charAt(1))*156 + 1+ alpha.get(word.charAt(2))*31+ 1 + alpha.get(word.charAt(3))*6 +1+ alpha.get(word.charAt(4)) +1;
        }else if(word.length()==4){
            answer = alpha.get(word.charAt(0))*781 + 1 + alpha.get(word.charAt(1))*156 + 1 + alpha.get(word.charAt(2))*31+ 1+  alpha.get(word.charAt(3))*6 +1;
        }else if(word.length()==3){
            answer = alpha.get(word.charAt(0))*781 + 1 + alpha.get(word.charAt(1))*156 +1 + alpha.get(word.charAt(2))*31 + 1;
        }else if(word.length()==2){
            answer = alpha.get(word.charAt(0))*781 + 1 + alpha.get(word.charAt(1))*156 + 1;
        }else {
            answer = alpha.get(word.charAt(0))*781 + 1;
        }
        
        return answer;
    }
}
//
