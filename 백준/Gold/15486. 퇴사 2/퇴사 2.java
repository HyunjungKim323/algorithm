import java.util.*;

public class Main {
	static int[] dp;
	static int[] [] schedule;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		schedule =new int[n+2][2];
		dp = new int[n+2];
		for(int i=1;i<=n;i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}
		for(int i=1;i<=n+1;i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			if(i+schedule[i][0]>n+1) continue;
			dp[i+schedule[i][0]] = Math.max(dp[i+schedule[i][0]], schedule[i][1] + dp[i]);	
		}
		System.out.println(dp[n+1]);
	}
}
	