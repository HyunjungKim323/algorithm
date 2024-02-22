class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int a=0;
        int b=0;
        int c=0;
        for(int i=0;i<answers.length;i++){
            int aAnswer = i%5+1;
            int bAnswer = 0;
            int cAnswer = 0;
            if(i%2==0){
                bAnswer = 2;
            }else{
                if(i%8 ==1)
                    bAnswer = 1;
                else if(i%8 ==3)
                    bAnswer = 3;
                else if(i%8 ==5)
                    bAnswer = 4;
                else if(i%8 ==7)
                    bAnswer = 5;
            }
            if((i/2)%5==0){
                cAnswer = 3;
            } else if((i/2)%5==1){
                cAnswer = 1;
            } else if((i/2)%5==2){
                cAnswer = 2;
            } else if((i/2)%5==3){
                cAnswer = 4;
            } else {
                cAnswer = 5;
            }
            if(answers[i] == aAnswer)
                a++;
            if(answers[i] == bAnswer)
                b++;
            if(answers[i] == cAnswer)
                c++;
        }
        if(a>b && a>c){
            return new int[]{1};
        }else if (b>a && b>c){
            return new int[]{2};
        }else if (c>a && c>b){
            return new int[]{3};
        }else if (a==b && b>c){
            return new int[]{1,2};
        }else if (c==b && b>a){
            return new int[]{2,3};
        }else if (a==c && c>b){
            return new int[]{1,3};
        }else if(a==b && b==c){
            return new int[]{1,2,3};
        }else{
            return answer;
        }   
    }
}