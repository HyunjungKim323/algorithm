class Solution {
    static int count = 0;
    static int[] multiple = new int[]{1,-1};
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,target);
        return count;
    }
    static void dfs(int[] numbers,int depth, int target){
        
        if(depth == numbers.length-1){
            if(target == numbers[numbers.length-1]){
                count++;
                return;
            }
            else if(target ==-numbers[numbers.length-1]){
                count++;
                return;
            }
            return;
        }
        for(int i=0;i<2;i++){
           dfs(numbers,depth+1,target+numbers[depth] * multiple[i]); 
        }
    }
}