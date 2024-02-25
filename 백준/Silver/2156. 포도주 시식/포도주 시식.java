import java.util.*;

public class Main {
	static int[][] dp;
	static int[] grape;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		grape = new int[n+1];
		dp = new int[3][n+1];
		
		for(int i=1;i<=n;i++) {
			grape[i] = sc.nextInt();
		}
		// 0: n 없음 , 1: n-1 , n 있음 2: n-1 없고 n 있음
		dp[0][1] = 0;
		dp[1][1] = grape[1];
		dp[2][1] = grape[1];
		
		for(int i=2;i<=n;i++) {
			dp[0][i] = Math.max(Math.max(dp[0][i-1],dp[1][i-1]),dp[2][i-1]);
			dp[1][i]= dp[2][i-1] + grape[i];
			dp[2][i] = dp[0][i-1] + grape[i];
			
		}
		
		long ans = Math.max(dp[0][n], dp[1][n]);
		ans = Math.max(ans, dp[2][n]);
		
		System.out.println(ans);
		
	}
}
	