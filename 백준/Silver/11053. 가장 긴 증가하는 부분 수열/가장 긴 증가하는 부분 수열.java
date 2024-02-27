
import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[2][n];
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			dp[0][i] = a;
			dp[1][i] = 1;
			for(int j=0;j<i;j++) {
				if(dp[0][j]<dp[0][i])
					dp[1][i]= Math.max(dp[1][i],dp[1][j]+1);
			}
		}
		int ans =0;
		for(int i=0;i<n;i++) {
			ans =Math.max(ans, dp[1][i]);
		}
		System.out.println(ans);
	}
}
	