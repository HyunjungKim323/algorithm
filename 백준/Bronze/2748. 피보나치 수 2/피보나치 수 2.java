import java.util.*;

public class Main {
	static long[] dp = new long[93];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibo(n));
    }
    static long fibo(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    } 

}
