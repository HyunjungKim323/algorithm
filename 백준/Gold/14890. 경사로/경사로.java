import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,L;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count =0;
		
		for(int i=0;i<N;i++) {
			if(check(i,0)) { 
				count++;
			}
			if(check(i,1)) {
				count++;
			}
		}
		bw.write(count+"\n");
		bw.flush();
	}
	
	public static boolean check (int index, int wh) {
		if(wh ==0) {
			int checkIndex = 0;
			int same =1;
			while(checkIndex < N-1) {//N 맞는 지 check
				if(map[index][checkIndex]==map[index][checkIndex+1]) {
					checkIndex++;
					same++;
				}else {
					if(map[index][checkIndex]-map[index][checkIndex+1]==1) {
						//내려가는 경우
						if(checkIndex>=N-L)
							return false;
						else {
							for(int i=0;i<L-1;i++) {
								if(map[index][checkIndex+1+i]!=map[index][checkIndex+2+i])
									return false;
							}
							checkIndex +=L;
							same = 0;
						}	
					}else if(map[index][checkIndex]-map[index][checkIndex+1]==-1) {
						//올라가는 경우 same이 L이상이여야 함
						if(same>=L) {
							checkIndex++;
							same =1;
						}else {
							return false;
						}
					}else {
						return false;
					}
				}
			}
			return true;
		}else {
			int checkIndex = 0;
			int same =1;
			while(checkIndex < N-1) {//N 맞는 지 check
				
				if(map[checkIndex][index]==map[checkIndex+1][index]) {
					checkIndex++;
					same++;
				}else {
					if(map[checkIndex][index]-map[checkIndex+1][index]==1) {
						//내려가는 경우
						if(checkIndex>=N-L)
							return false;
						for(int i=0;i<L-1;i++) {
							if(map[checkIndex+1+i][index]!=map[checkIndex+2+i][index])
								return false;
						}
						checkIndex +=L;
						same = 0;
					}else if(map[checkIndex][index]-map[checkIndex+1][index]==-1) {
						//올라가는 경우 same이 2이상이여야 함
						if(same>=L) {
							checkIndex++;
							same =1;
						}else {
							return false;
						}
					}else {
						return false;
					}
				}
			}
			return true;
		}
	}
}
