import java.util.*;

public class Main {
	static int[][] dpMin;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dpMin = new int[n+1][3];
		dpMin[1][0] = sc.nextInt();
		dpMin[1][1] = sc.nextInt();
		dpMin[1][2] = sc.nextInt();
		for(int i=2;i<=n;i++) {
			int red = sc.nextInt();
			int green = sc.nextInt();
			int blue = sc.nextInt();
			dpMin[i][0] = Math.min(dpMin[i-1][1]+red,dpMin[i-1][2]+red);
			dpMin[i][1] = Math.min(dpMin[i-1][0]+green,dpMin[i-1][2]+green);
			dpMin[i][2] = Math.min(dpMin[i-1][0]+blue,dpMin[i-1][1]+blue);
		}
		
		int ans = Math.min(dpMin[n][0], dpMin[n][1]);
		ans = Math.min(ans, dpMin[n][2]);
		
		System.out.println(ans);
		
	}
}
	