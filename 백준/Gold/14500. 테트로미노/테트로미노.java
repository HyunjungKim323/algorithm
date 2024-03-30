import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] tetro;
	static int ans = 0;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tetro = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tetro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] block = {
				{{0,0},{0,1},{0,2},{0,3}}, //1
				{{0,0},{1,0},{2,0},{3,0}}, //2
				{{0,0},{0,1},{1,0},{1,1}}, //3
				{{0,0},{1,0},{2,0},{2,-1}}, //4
				{{0,0},{0,1},{0,2},{-1,2}}, //5
				{{0,0},{1,0},{2,0},{2,1}}, //6
				{{0,0},{0,1},{0,2},{1,2}}, //7
				{{0,0},{1,0},{1,1},{1,2}}, //8
				{{0,0},{0,1},{1,0},{2,0}}, //9
				{{0,0},{0,1},{1,1},{2,1}}, //10
				{{0,0},{0,1},{1,0},{0,2}}, //11
				{{0,0},{1,0},{1,1},{2,1}}, //12
				{{0,0},{1,0},{0,1},{1,-1}}, //13
				{{0,0},{0,1},{1,1},{1,2}}, //14
				{{0,0},{1,0},{1,-1},{2,-1}}, //15
				{{0,0},{0,1},{0,2},{1,1}}, //16
				{{0,0},{1,0},{1,-1},{2,0}}, //17
				{{0,0},{1,0},{1,-1},{1,1}}, //18
				{{0,0},{1,0},{1,1},{2,0}} //19
		};
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sum(i,j,block);
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
		
		
	}
	static void sum(int x,int y,int[][][] block) {
		//왼쪽 위로 가는 것도 고려해야 할 듯 
		//visited 처리가 문제 
		for(int i=0;i<19;i++) {
			int sum = 0;
			for(int j=0;j<4;j++) {
				int nx = x+block[i][j][0];
				int ny = y+block[i][j][1];
				if(nx>=0 && nx < N && ny >=0 && ny< M) {
					sum+=tetro[nx][ny];
				}else {
					sum=0;
					break;
				}
			}
			ans = Math.max(ans, sum);
			
		}
		
	}

}
