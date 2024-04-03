import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,h;
	static int[][] line;
	static int answer = 4;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		line = new int[h+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			line[x][y] = 1;
			line[x][y+1] = 2;
		}
		dfs(line,0,1);
		if(answer==4) {
			bw.write(-1+"\n");
		}else {
			bw.write(answer+"\n");
		}
		
		bw.flush();
		
		
	}
	public static void dfs(int[][] map,int count,int x) {
		
		if(count>=answer) {
			return;
		}
		if(check(map)) {
			answer = Math.min(answer, count);
			return;
		}else {
			for(int i=x;i<=h;i++) {
				for(int j=1;j<n;j++) {
					if(map[i][j]==0 && map[i][j+1]==0) {
						map[i][j]=1;
						map[i][j+1]=2;
						dfs(map,count+1,i);
						map[i][j]=0;
						map[i][j+1]=0;
					}
				}
			}
		}	
		//int[][] line2 = new int[h+1][n+1];
		
		//for(int i=1;i<=h;i++) {
		//	for(int j=1;j<=n;j++) {
		//		line2[i][j] = map[i][j];
		//	}
		//}
		
			
		
		
	}
	public static boolean check(int[][] map) {
		for(int y=1;y<=n;y++) {
			int x=1;
			int startIndex = y;
			while(x<=h) {
				if(map[x][y]==1) {
					x++;
					y++;
				}else if(map[x][y]==2) {
					x++;
					y--;
				}else {
					//0
					x++;
				}
			}
			
			if(startIndex!=y) {
				return false;
			}
		}
		
		return true;
	}
}
