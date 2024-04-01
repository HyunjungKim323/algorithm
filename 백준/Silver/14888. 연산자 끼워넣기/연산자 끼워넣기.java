import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] a;
	
	static int max = -1000000001;
	static int min = 1000000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		a= new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		dfs(0,a[0],plus,minus,mul,div);
		
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		
		
	}
	
	static void dfs(int step, int now,int plus,int minus,int mul, int div) {
		if(step==N-1) {
			max = Math.max(now, max);
			min = Math.min(now, min);
			return;
		}
			
	
		if(plus>0) {
			dfs(step+1,now+a[step+1],plus-1,minus,mul,div);
		}
		if(minus>0) {
			dfs(step+1,now-a[step+1],plus,minus-1,mul,div);
		}
		if(mul>0) {
			dfs(step+1,now*a[step+1],plus,minus,mul-1,div);
		}
		if(div>0) {
			dfs(step+1,now/a[step+1],plus,minus,mul,div-1);
		}
	}
}
