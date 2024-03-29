import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static int[][] board;
	//우 하 좌 상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int direc = 0;
	static int tailDirec = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1]; // 1,1  N,N 까지만 다루기 
		board[1][1] = 2;
		
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;
		}
		
		
		L = Integer.parseInt(br.readLine());
		
		int headX = 1;
		int headY = 1;
		int tailX = 1;
		int tailY = 1;
		int[][] change = new int[L][2];
		// 여기서부터 방향에 관한 내용
		
		for(int i=0; i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			if(direction.equals("D")) {
				change[i][0] = t;
				change[i][1] = 0;
			}else {
				change[i][0] = t;
				change[i][1] = 1;
			}
		}
		// 0은 오른쪽 90도 1은 왼쪽 90도
		
		
		boolean end = true;
		int time = 0;
		int timeIndex = 0;
		int timeTailIndex =0;
		int length = 1;
		
		while(end) {
			//배열 자체를 time 별로 매번 업데이트 해줘야 할듯? 꼬리와 tail 기준 
			// tail 먼저 없애고 머리 추가-> 머리 생기는 곳이 1이면 다시 tail 그대로 2면 끝 0이면 그대로 or 머리 생기는 곳 벽 쪽 end
			if(timeIndex<L && time==change[timeIndex][0]) {
				int dir = change[timeIndex][1];
				if(dir ==0)
					direc = (direc+1)%4; 
				else
					direc = (direc+3)%4;
				timeIndex++;
			}
			
			
			headX +=dx[direc];
			headY +=dy[direc];
			
			if(headX>0 && headX<=N && headY>0 && headY<=N ) {
				if(board[headX][headY] ==2) {
					end = false;
				}else if(board[headX][headY] ==1) {
					board[headX][headY] = 2;
					length++;
				}else {
					board[headX][headY] = 2;
					board[tailX][tailY] = 0;
					if(timeTailIndex<L && time-length+1 == change[timeTailIndex][0]) {
						int dir = change[timeTailIndex][1];
						if(dir ==0)
							tailDirec = (tailDirec+1)%4; 
						else
							tailDirec = (tailDirec+3)%4;
						timeTailIndex++;
					}
					tailX+= dx[tailDirec];
					tailY+= dy[tailDirec];
					
				}
			}else {
				end = false;
			}
			
			time++;
		}
		
		bw.write(time+"\n");
		bw.flush();
	}

}
