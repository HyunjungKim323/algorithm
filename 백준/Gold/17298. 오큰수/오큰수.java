import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] ans;
	static Stack<Integer> stk = new Stack<>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[N];
		int index =0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stk.push(0);
		for(int i=1;i<N;i++) {
			while(!stk.isEmpty() && arr[stk.peek()]<arr[i]) {
				ans[stk.pop()] = arr[i];
			}
			stk.push(i);
		}
		while(!stk.isEmpty()) {
			ans[stk.pop()] = -1;
		}
		
		for(int i=0;i<N;i++) {
			bw.write(ans[i]+" ");
		}
        bw.write("\n");
		bw.flush();
		
	
	}
}
