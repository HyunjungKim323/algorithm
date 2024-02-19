import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int T,N;
	static int[] adj;
	static int[] depth;
	static int cnt =0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			adj = new int[N+1];
			depth = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<=N;i++) {
				adj[i] = Integer.parseInt(st.nextToken());
				depth[i] = 0;
			}
			cnt = 0;
			for (int i = 1; i <= N; i++) {
                if (depth[i] == 0) {
                    depth[i] = 1;
                    cnt += dfs(i);
                }
            }
			
			
			bw.write(N-cnt +"\n");
		}
		bw.flush();
		
		
	}
    
     
	
     static int dfs(int now) {
		int next = adj[now];
		int cycleCnt = 0;
		//첫 방문 
		if(depth[next] == 0) {
			depth[next] = depth[now] + 1;
			cycleCnt = dfs(next);
			
		}
		// 재방문 (사이클)
	     else {
	         cycleCnt = depth[now] - depth[next] + 1;
	         
				
	     }
	     // 다음 탐색을 위해 재귀 안에서 초기화
	     depth[now] = 100001; 
	     // 사이클이 아니면(음수) 0을 리턴
	     return cycleCnt < 0 ? 0 : cycleCnt;
     }
}
