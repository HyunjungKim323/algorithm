
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static int[] parents;
	static int[] depths;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		parents = new int[N+1];
		depths = new int[N+1];
		Arrays.fill(depths,-1);
		
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1,1,0);
		
		int N2 = Integer.parseInt(br.readLine());
		for(int i=0;i<N2;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = LCA(a,b);
			
			bw.write(String.valueOf(result)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int current,int depth, int parent) {
		//depths와 parents 설정
		depths[current] = depth;
		parents[current] = parent;
		
		for(int child:tree[current]) {
			if(child != parent) {
				dfs(child,depth+1,current);
			}
		}
	}
	public static int LCA(int a,int b) {
		int aDepth = depths[a];
        int bDepth = depths[b];
        while(aDepth>bDepth){
            a = parents[a];
            aDepth--;
        }
        while(bDepth>aDepth){
            b = parents[b];
            bDepth--;
        }
        while(a!=b){
            a = parents[a];
            b = parents[b];
        }
        return a;
	}
}
