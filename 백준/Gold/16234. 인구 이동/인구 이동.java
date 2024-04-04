import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,l,r;
	static int[][] people;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		people = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int fin =0;
		int count =0;
		while(fin!=1) {
			fin = move();
			count++;
			//for(int i=0;i<n;i++) {
				//for(int j=0;j<n;j++) {
					//System.out.print(people[i][j]+" ");
				//}
				//System.out.println();
			//}
			//System.out.println();
		}
		bw.write((count-1)+"\n");
		bw.flush();
		
		
	}
	public static int move() {
		boolean[][] visited = new boolean[n][n];
		int maxMoveCount =1;
		int[][] change = new int[n*n][2];
		int index =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					visited[i][j]=true;
					int moveCount =1;
					int sum =people[i][j];
					change[index][0] = i;
					change[index][1] = j;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] t = q.poll();
						int x = t[0];
						int y = t[1];
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<n && ny <n && !visited[nx][ny]) {
								if(Math.abs(people[nx][ny]-people[x][y])>=l && Math.abs(people[nx][ny]-people[x][y])<=r) {
									visited[nx][ny] = true;
									change[index+moveCount][0] = nx;  
									change[index+moveCount][1] = ny;
									sum+=people[nx][ny];
									moveCount++;
									q.offer(new int[] {nx,ny});
								}
							}
						}
					}
					maxMoveCount = Math.max(maxMoveCount, moveCount);
					
					for(int k=0;k<moveCount;k++) {
						people[change[index+k][0]][change[index+k][1]] = sum/moveCount;
					}
					index+=moveCount;
					
				}
			}
		}
		return maxMoveCount;
	}
}
