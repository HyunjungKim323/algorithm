import java.util.*;

public class Main {
	static long[] dp = new long[1004];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1] +2*dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
