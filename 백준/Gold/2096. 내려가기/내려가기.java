import java.util.*;

public class Main {
	static int[][] dpMax;
	static int[][] dpMin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dpMax = new int[n][3];
		dpMin = new int[n][3];
		
		dpMax[0][0] = sc.nextInt();
		dpMax[0][1] = sc.nextInt();
		dpMax[0][2] = sc.nextInt();
		dpMin[0][0] = dpMax[0][0];
		dpMin[0][1] = dpMax[0][1];
		dpMin[0][2] = dpMax[0][2];
		
		for(int i=1;i<n;i++) {
			int one = sc.nextInt();
			int two = sc.nextInt();
			int three = sc.nextInt();
			dpMax[i][0] = Math.max(dpMax[i-1][0]+one,dpMax[i-1][1]+one);
			dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0]+two,dpMax[i-1][1]+two),dpMax[i-1][2]+two);
			dpMax[i][2] = Math.max(dpMax[i-1][1]+three,dpMax[i-1][2]+three);
			
			dpMin[i][0] = Math.min(dpMin[i-1][0]+one,dpMin[i-1][1]+one);
			dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0]+two,dpMin[i-1][1]+two),dpMin[i-1][2]+two);
			dpMin[i][2] = Math.min(dpMin[i-1][1]+three,dpMin[i-1][2]+three);
		}
		int max = Math.max(Math.max(dpMax[n-1][0],dpMax[n-1][1]), dpMax[n-1][2]);
		int min = Math.min(Math.min(dpMin[n-1][0],dpMin[n-1][1]), dpMin[n-1][2]);
		System.out.println(max+" "+min);
	}
}
	