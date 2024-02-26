import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		final int MOD = 9901;
		for(int i=2;i<=n;i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%MOD;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%MOD;
		}
		int ans = 0;
		ans = (dp[n][0]+dp[n][1])%MOD;
		ans = (ans +dp[n][2])%MOD;
		System.out.println(ans);
	}
}
	