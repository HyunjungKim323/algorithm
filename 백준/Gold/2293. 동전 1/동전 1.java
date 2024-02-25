import java.util.*;

public class Main {
	static long[] dp;
	static int[] coin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		dp = new long[k+1];
		coin= new int[n];
		
		for(int i=0; i<n; i++) {
			coin[i]= sc.nextInt();
			
		}
		dp[0]=1;
		
		for(int i=0;i<n;i++) {
			for (int j=0;j+coin[i]<=k;j++) {
				dp[j+coin[i]]+= dp[j];
			}
		}
		
	
		
		System.out.println(dp[k]);
		
		
		
	}
}
	