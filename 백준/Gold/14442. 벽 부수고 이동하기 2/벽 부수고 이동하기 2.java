import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static int[][] map;
	static int[][][] distance;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		distance = new int[N][M][K+1];
		q = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j)-'0';
				for(int k=0;k<=K;k++) {
					distance[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		q.offer(new int[] {0,0,1,0});
		for(int i=0;i<=K;i++) {
			distance[0][0][i] = 1;
		}
		bfs();
		
		int ans = Integer.MAX_VALUE;
		
		for(int i=0;i<=K;i++) {
			ans = Math.min(ans,distance[N-1][M-1][i]);
		}
		if(ans == Integer.MAX_VALUE ) {
			bw.write("-1"+"\n");
		}else {
			bw.write(ans+"\n");
		}
		bw.flush();
	}
	static void bfs() {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			int time =t[2];
			int pass = t[3];
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0 && time+1<distance[nx][ny][pass] && pass<=K) {
					
					for(int j=pass;j<=K;j++) {
						if (distance[nx][ny][j]>time+1)
							distance[nx][ny][j] = time+1;
					}
					
					q.offer(new int[] {nx,ny,time+1,pass});
				}
				if (pass+1<=K && nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1 && time+1<distance[nx][ny][pass+1] ) {
					for(int j=pass+1;j<=K;j++) {
						distance[nx][ny][j] = time+1;
					}
					q.offer(new int[] {nx,ny,time+1,pass+1});
				}
			}
		}
	}

}
