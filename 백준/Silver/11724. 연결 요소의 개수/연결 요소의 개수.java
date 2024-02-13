import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N,M;
	static int[][] adj;
	static int count =0;
	static boolean[] visited ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		adj = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0;i<M;i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			adj[a-1][b-1] = 1;
			adj[b-1][a-1] = 1;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i])
				count++;
			dfs(i);
		}
		System.out.println(count);
		
	}
	static void dfs(int node) {
		visited[node]=true;
		for(int i=0;i<N;i++) {
			if(adj[node][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
