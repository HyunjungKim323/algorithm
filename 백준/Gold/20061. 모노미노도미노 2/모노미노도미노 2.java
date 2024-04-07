import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[10][10];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move(t,x,y);
	         
		}
		int count =0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(board[i][j]!=0) {
					count++;
				}
			}
		}
		System.out.println(ans);
		System.out.println(count);
	}
	
	public static void move(int t,int x,int y) {
		int b=9;
		int g=9;
		if(t==1) {
			//x,y
			for(int i=4;i<=9;i++) {
				if(board[x][i]==1) {
					b=i-1;
					break;
				}
			}
			board[x][b]=1;
			
			for(int i=4;i<=9;i++) {
				if(board[i][y]==1) {
					g=i-1;
					break;
				}
			}
			board[g][y]=1;
			remove(1,b,g);
		}else if(t==2) {
			//x,y  x,y+1
			
			for(int i=5;i<=9;i++) {
				if(board[x][i]==1 || board[x][i-1]==1) {
					b=i-1;
					break;
				}
			}
			board[x][b]=1;
			board[x][b-1]=1;
			
			for(int i=4;i<=9;i++) {
				if(board[i][y]==1 || board[i][y+1]==1) {
					g=i-1;
					break;
				}
			}
			board[g][y]=1;
			board[g][y+1]=1;
			remove(2,b,g);
		}else {
			//x,y  x+1,y
			for(int i=4;i<=9;i++) {
				if(board[x][i]==1 || board[x+1][i]==1) {
					b=i-1;
					break;
				}
			}
			board[x][b]=1;
			board[x+1][b]=1;
			for(int i=5;i<=9;i++) {
				if(board[i][y]==1 || board[i-1][y]==1) {
					g=i-1;
					break;
				}
			}
			board[g][y]=1;
			board[g-1][y]=1;
			remove(3,b,g);
		}
	}
	public static void blue(int c) {
		for(int i=c;i>=5;i--) {
			board[0][i] = board[0][i-1];
			board[1][i] = board[1][i-1];
			board[2][i] = board[2][i-1];
			board[3][i] = board[3][i-1];
		}
		board[0][4] = 0;
		board[1][4] = 0;
		board[2][4] = 0;
		board[3][4] = 0;
	}
	public static void green(int r) {
		for(int i=r;i>=5;i--) {
			board[i][0] = board[i-1][0];
			board[i][1] = board[i-1][1];
			board[i][2] = board[i-1][2];
			board[i][3] = board[i-1][3];
		}
		board[4][0] = 0;
		board[4][1] = 0;
		board[4][2] = 0;
		board[4][3] = 0;
	}
	public static boolean checkBlue(int c) {
		if(c>=6 && c<=9) {
			if(board[0][c]==1 && board[1][c]==1 && board[2][c]==1 && board[3][c]==1) {
				blue(c);
				ans++;
				return true;
			}
		}else {
			if(board[0][c]==1 || board[1][c]==1 || board[2][c]==1 || board[3][c]==1) {
				blue(9);
				return true;
			}
		}
		return false;
	}
	public static boolean checkGreen(int r) {
		if(r>=6 && r<=9) {
			if(board[r][0]==1 && board[r][1]==1 && board[r][2]==1 && board[r][3]==1) {
				green(r);
				ans++;
				return true;
			}
		}else {
			if(board[r][0]==1 || board[r][1]==1 || board[r][2]==1 || board[r][3]==1) {
				green(9);
				return true;
			}
		}
		return false;
	}
	
	
	public static void remove(int t,int b,int g) {
		
		if(t==1) {
			checkBlue(b);
			checkGreen(g);
		}else if(t==2) {
			if(checkBlue(b)) {
				checkBlue(b);
			}else {
				checkBlue(b-1);
			}
			checkGreen(g);
		}else {
			checkBlue(b);
			if(checkGreen(g)) {
				checkGreen(g);
			}else {
				checkGreen(g-1);
			}
		}
	}
}
