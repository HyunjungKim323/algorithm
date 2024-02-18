import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	static int T,I;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {			
			I = Integer.parseInt(br.readLine());
			distance = new int[I][I];
			for(int j=0;j<I;j++) {
				for(int k=0;k<I;k++) {
					distance[j][k] = Integer.MAX_VALUE;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			bfs(startX,startY);
			bw.write(distance[endX][endY]+"\n");
		}
		
		bw.flush();
	}
	
	static void bfs(int startX,int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX,startY,0});
		distance[startX][startY]=0;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			int time = t[2];
			
			for(int i=0;i<8;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<I && ny>=0 && ny<I && time+1<distance[nx][ny]) {
					distance[nx][ny] = time+1;
					
					q.offer(new int[] {nx,ny,time+1});
				}
			}
		}
		
		
	}
	
}
