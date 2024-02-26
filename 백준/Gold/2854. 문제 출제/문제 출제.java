import java.util.*;

public class Main {
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int MOD = 1000000007;
		int n = sc.nextInt();
		long[] fix = new long[n+1];
		long[] change = new long[n+1];
		dp = new long[3][n+1];
		
		for(int i =1;i<=n;i++) {
			fix[i] = sc.nextInt();
		}
		for(int i=1;i<=n-1;i++) {
			change[i] = sc.nextInt();
		}
		// case1: 난이도가 고정된 문제만 사용
		// case2: 변동되는 난이도 i만 사용
		// case3: 둘다 사용
        dp[0][0] = 1;
		dp[1][0] = 0;
		dp[2][0] = 0;
		dp[0][1] = fix[1];
		dp[1][1] = change[1];
		dp[2][1] = 0;
		
		for(int i=2;i<=n;i++) {
			dp[0][i] = fix[i]*(dp[0][i-1]+ dp[1][i-1]+ dp[2][i-1]);
			dp[0][i]%=MOD;
			dp[1][i] = change[i] *(dp[0][i-1]+ dp[1][i-1]+ dp[2][i-1]); 
			dp[1][i]%=MOD;
			dp[2][i] = (dp[0][i-1] + dp[2][i-1]) * change[i-1] %MOD +
					(change[i-1] *(change[i-1]-1)%MOD) * (dp[0][i-2] + dp[1][i-2]+dp[2][i-2])%MOD;
			
		}
		long sum = dp[0][n]+ dp[1][n]+dp[2][n];
		System.out.println(sum%MOD);
	}
}
	