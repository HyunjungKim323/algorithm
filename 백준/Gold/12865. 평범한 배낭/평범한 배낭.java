import java.util.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		dp = new int[K+1];
		dp[0] = 0;
		for(int i=0;i<N;i++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			for(int w=K;w>=weight;w--) {
				dp[w] = Math.max(dp[w], dp[w-weight]+value);
			}
		}
		System.out.println(dp[K]);
	}
}
	