import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] board;
	static boolean[] alpha;
	static int max =1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		alpha = new boolean[26];
		
		for(int i=0;i<R;i++) {
			String sent = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j] = sent.charAt(j);
			}
		}
		
		dfs(alpha,0,0,1);
		
		System.out.println(max);
		
		
	}
	
	static void dfs(boolean[] alpha,int x,int y,int cnt) {
		if(cnt>max)
			max = cnt;
		char alp = board[x][y];
		alpha[alp-'A'] = true;
		if(x+1<R && !alpha[board[x+1][y]-'A']) {
			dfs(alpha,x+1,y,cnt+1);
		}
		if(y+1<C && !alpha[board[x][y+1]-'A']) {
			dfs(alpha,x,y+1,cnt+1);
		}
		if(x-1>=0 && !alpha[board[x-1][y]-'A']) {
			dfs(alpha,x-1,y,cnt+1);
		}
		if(y-1>=0 && !alpha[board[x][y-1]-'A']) {
			dfs(alpha,x,y-1,cnt+1);
		}
		alpha[alp-'A'] = false;
	}
}
