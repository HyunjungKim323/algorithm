import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] sea = new int[4][4];
	static int[][] fish;
	static int sharkD;
	static int[] dx = {100,-1,-1,0,1,1,1,0,-1};
	static int[] dy = {100,0,-1,-1,-1,0,1,1,1};
	static int sum=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		fish = new int[17][3];
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(i==0 && j==0) {
					//0,0 처
					sum = a;
					sharkD = b;
					fish[a][0] = -1;
					fish[a][1] = -1;
					fish[a][2] = -1;
				}else {
					sea[i][j] = a;
					fish[a][0] = i;
					fish[a][1] = j;
					fish[a][2] = b;
				}
			}
		}
		//fishMove(0,0);
		//System.out.println(fish[15][0]+","+fish[15][1]+" 방향: "+fish[15][2]);
		
		dfs(0,0,sharkD,sum,fish,sea);
		System.out.println(sum);
		//상어 방향대로 이동 
		// 단 물고기가 없으면 또 이동 
	}
	public static void dfs(int sx,int sy, int sd , int s,int[][] fish, int[][] sea) {
		int[][] newSea = new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				newSea[i][j] = sea[i][j];
			}
		}
		int[][] newFish = new int[17][3];
		for(int i=0;i<17;i++) {
			for(int j=0;j<3;j++) {
				newFish[i][j]= fish[i][j];
			}
		}
		
		fishMove(sx,sy,newFish,newSea);
		sum = Math.max(s,sum);
		//갈길이 없거나 먹을게 없으면 Max 업데이트 후 return
		for(int i=1;i<4;i++) {
			int nx = sx+dx[sd]*i;
			int ny = sy+dy[sd]*i;
			
			//i=1
			if(nx>=0 && nx<4 && ny>=0 && ny<4) {
				if(newSea[nx][ny]!=0) {//물고기가 있는 경우
					int eatNum = newSea[nx][ny]; // 물고기 번호 
					int oriD = newFish[eatNum][2];
					newSea[nx][ny]=0;
					newFish[eatNum][0]=-1;
					newFish[eatNum][1]=-1;
					newFish[eatNum][2]=-1;
					dfs(nx,ny,oriD,s+eatNum,newFish,newSea);
					newSea[nx][ny]=eatNum;
					newFish[eatNum][0]=nx;
					newFish[eatNum][1]=ny;
					newFish[eatNum][2]=oriD;
				}
			}
			
		}
	}
	public static void fishMove(int sx, int sy,int[][] fish,int[][] sea) {
		for(int i=1;i<=16;i++) {
			int x = fish[i][0];
			int y = fish[i][1];
			int d = fish[i][2];
			int rotatecount =0;
			if(x!=-1 && y!=-1) {
				while(x+dx[d]<0 || x+dx[d]>=4 || y+dy[d]<0 || y+dy[d]>=4 || (x+dx[d]==sx && y+dy[d]==sy) || rotatecount>=8) {
					d = d%8+1;
					rotatecount++;
				}
				if(rotatecount<8) {
					//변경
					int nx = x+dx[d];
					int ny = y+dy[d];
					int change = sea[nx][ny];
					if(change>0) {
						//물고기가 있는거 변경
						fish[i][0] = nx;
						fish[i][1] = ny;
						fish[i][2] = d;
						fish[change][0] = x;
						fish[change][1] = y;
						sea[nx][ny] = i;
						sea[x][y] = change;
					}else {
						//물고기가 없는거 그냥 이동
						fish[i][0] = nx;
						fish[i][1] = ny;
						fish[i][2] = d;
						sea[nx][ny]=i;
						sea[x][y]=0;
					}
				}
				
			}
		}
	}
}
