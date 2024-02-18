import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N;
	static int[][] tomato;
	
	static int day;
	static Queue<int[]> q;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		
		int time =0;
		q= new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] ==-1) cnt++;
				else if(tomato[i][j] ==1) {
					q.offer(new int[] {i,j,0});
					cnt++;
				}
			}
		}
		if(cnt!=N*M)
			day = bfs();
		bw.write(day+"\n");
		bw.flush();
	}
	static int bfs() {
		int ans =0;
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			int time = t[2];
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<N & ny>=0&&ny<M && tomato[nx][ny]==0 ) {
					tomato[nx][ny] = 1;
					cnt++;
					q.offer(new int[] {nx,ny,time+1});
				}
			}
			if(cnt==N*M) {
				ans = time+1;
				break;
			}
		}
		if(cnt!=N*M) {
			return -1;
		}
		return ans;
	}
}
