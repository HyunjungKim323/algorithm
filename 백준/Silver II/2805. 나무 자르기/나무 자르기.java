import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        for(int i=0; i<N; i++){
            trees[i] = sc.nextInt();
        }
        int ans = tree(trees,M);
        System.out.println(ans);

    }
    public static int tree(int[] array, int M ){
        int left = 0;
        int right = 1000000000;
        int id = -1;

        while(left <= right){
            long sum = 0;
            int mid = (left+right)/2;
            for(int h : array){
                if(h>mid){
                    sum+=h-mid;
                }
            }
            if(sum>=M){
                id = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return id;
    }
}
