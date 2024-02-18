import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	static int T, h ,w ;
	static char[][] room;
	static Queue<Point> fire;
	static Queue<Point> person;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] check ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			room= new char[w][h];
			
			fire = new ArrayDeque<>();
			person = new ArrayDeque<>();
			boolean finish = false;
			check = new boolean[w][h];
			
			for(int i=0;i<w;i++) {
				String line = br.readLine();
				for(int j=0;j<h;j++) {
					room[i][j] = line.charAt(j);
					if(room[i][j]=='@') {
						person.offer(new Point(i,j));
						check[i][j] = true;
						if(i==0 || i==w-1 || j==0 || j==h-1) finish = true;
					}else if(room[i][j] =='*') {
						fire.offer(new Point(i,j));
					}
				}
			}
			if(finish) bw.write("1"+"\n");
			
			else {
				int time = bfs();
				
				if(time ==-1) {
					bw.write("IMPOSSIBLE"+"\n");
				}else {
					bw.write(time+1+"\n");
				}
			}
		}
		
		bw.flush();
		
	}
	
	static int bfs() {
		int time=0;
		while(!person.isEmpty()) {
			int len = fire.size();
			for(int i=0;i<len;i++) {
				Point f= fire.poll();
				int fx = f.x;
				int fy = f.y;
				for(int j=0;j<4;j++) {
					int nx = fx+dx[j];
					int ny = fy+dy[j];
					if(nx>=0 && nx<w && ny>=0 && ny<h && (room[nx][ny]=='.' || room[nx][ny]=='@')) {
						room[nx][ny]='*';
						fire.offer(new Point(nx,ny));
					}
				}
			}
			
			len = person.size();
			time++;
			for(int i=0;i<len;i++) {
				Point p = person.poll();
				int px = p.x;
				int py = p.y;
				
				for(int j=0;j<4;j++) {
					int nx = px +dx[j];
					int ny = py +dy[j];
					if(nx>=0 && nx<w && ny>=0 && ny<h && room[nx][ny]=='.' && !check[nx][ny]) {
						if(nx==0 || nx==w-1 || ny==0 || ny==h-1)
							return time;
						person.offer(new Point(nx,ny));
						check[nx][ny] = true;
					}
				}
			}	
		}
		return -1;
	}
}
