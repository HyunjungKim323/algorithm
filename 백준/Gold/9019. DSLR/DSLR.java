import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int T;
	static Queue<int[]> q;
	static int[] count;
	static String[] dslr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			q = new ArrayDeque<>();
			count = new int[10000];
			Arrays.fill(count, Integer.MAX_VALUE);
			dslr = new String[10000];
			q.offer(new int[] {A,0});
			dslr[A] = "";
			count[A]=0;
			String ans = bfs(B);
			bw.write(ans+"\n");
		}
		bw.flush();
		
	}
	static String bfs(int B) {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int num = t[0];
			int time = t[1];
			for(int i=0;i<4;i++) {
				if(i==0) {
					int num2 = (2*num)%10000;
					
					if(time+1<count[num2]) {
						count[num2]= time+1;
						dslr[num2] = dslr[num]+"D";
						q.offer(new int[] {num2,time+1});
					}
				}else if(i==1) {
					int num2 = num-1;
					if (num==0) num2 =9999;
					if(time+1<count[num2]) {
						count[num2] = time+1;
						dslr[num2] = dslr[num]+"S";
						q.offer(new int[] {num2,time+1});
					}
				}else if(i==2) {
					int one = num/1000; 
					int two = (num/100)%10;
					int three = (num%100)/10;
					int four = num%10;
					int num2 = two*1000+three*100+four*10+one;
					if(time+1<count[num2]) {
						count[num2] = time+1;
						dslr[num2] = dslr[num]+"L";
						q.offer(new int[] {num2,time+1});
					}
				}else {
					int one = num/1000; 
					int two = (num/100)%10;
					int three = (num%100)/10;
					int four = num%10;
					int num2 = four*1000+one*100+two*10+three;
					if(time+1<count[num2]) {
						count[num2] = time+1;
						dslr[num2] = dslr[num]+"R";
						q.offer(new int[] {num2,time+1});
					}
				}
			}
		}
		return dslr[B];
	}
}
