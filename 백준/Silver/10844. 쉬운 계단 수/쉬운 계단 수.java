import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1][10];
		final int MOD = 1000000000;
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=n;i++) {
			dp[i][0] = dp[i-1][1]% MOD;
			for(int j=1;j<9;j++) {
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%MOD;
			}
			dp[i][9] = dp[i-1][8]% MOD;
		}
		int sum = 0;
		for(int i=1;i<=9;i++) {
			sum = (sum+dp[n][i])% MOD;
		}
	
		System.out.println(sum);
	}
}
	