class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxMax = 0;
        int minMax = 0;
        for (int i =0;i<sizes.length;i++){
            if(sizes[i][0]>=sizes[i][1]){
                if(sizes[i][0] >= maxMax)
                    maxMax = sizes[i][0];
                if(sizes[i][1]>= minMax)
                    minMax = sizes[i][1];
            }else{
                if(sizes[i][1] >= maxMax)
                    maxMax = sizes[i][1];
                if(sizes[i][0]>= minMax)
                    minMax = sizes[i][0];
            }
        }
        return maxMax * minMax;
    }
}