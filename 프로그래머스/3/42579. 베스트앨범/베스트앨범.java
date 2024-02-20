import java.util.*;

class Type implements Comparable<Type>{

    int sum;
    int size;
	int[] first;
    int[] second;
	    
	public Type( int sum, int size,int[] first, int[] second){
	    this.sum = sum;
        this.size = size;
        this.first = first;
	    this.second = second;
    }
	    
	@Override
	public int compareTo(Type t){
        return t.sum-sum;   
	}
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Type> tp = new HashMap<>();
        for(int i =0;i<genres.length;i++){
            if(tp.containsKey(genres[i])){
                Type tpOri = tp.get(genres[i]);
                tpOri.sum+= plays[i];
                tpOri.size++;
                if(plays[i]>tpOri.first[0]){
                    tpOri.second = tpOri.first;
                    tpOri.first = new int[] {plays[i],i};
                }
                else if(plays[i]<=tpOri.first[0] && plays[i]>tpOri.second[0]){
                    tpOri.second = new int[] {plays[i],i};
                }
                tp.put(genres[i],tpOri);
            }else{
                Type tpNew = new Type(plays[i],1,new int[]{plays[i],i},new int[]{-1,-1});
                tp.put(genres[i],tpNew);
            }
        }
        
        int len = tp.size();
        Type[] ans = new Type[len];
        int index =0;
        for(Map.Entry<String,Type> map : tp.entrySet()){
            ans[index++] = map.getValue();
        }
        Arrays.sort(ans);
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<ans.length;i++) {
        	if(ans[i].size==1){
                answer.add(ans[i].first[1]);
            }else{
                answer.add(ans[i].first[1]);
                answer.add(ans[i].second[1]);
            }
        }
        int[] real = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            real[i] = answer.get(i);
        }
        return real;
        
        
    }
}