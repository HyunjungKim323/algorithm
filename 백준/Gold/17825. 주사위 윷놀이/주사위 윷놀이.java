import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dice;
	static int[]map = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40, //0번부터 20번
							10,13,16,19,//21번부터 24번
							20,22,24,//25번부터 27번
							30,28,27,26,//28번부터 31번
							25,30,35,40, //32번부터 35번
							0 //36번
	};
						
	static int ans=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for(int i=0;i<10;i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(0,new int[] {0,0,0,0},0);
		System.out.println(ans);
	}
	
	
	static void dfs(int cnt, int[] diceInd, int score) {
		if(cnt>=10) {
			ans = Math.max(ans, score);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int next = diceInd[i] + dice[cnt];
			if(diceInd[i]<20) {
				if(next==5) {
					if(check(21,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= 21;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}else if(next==10) {
					if(check(25,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= 25;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}else if(next==15) {
					if(check(28,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= 28;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}else if(next==20) {
					if(check(35,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= 35;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}
				else if(next>=21) {
					int temp = diceInd[i];
					diceInd[i]= 36;
					dfs(cnt+1,diceInd,score+map[diceInd[i]]);
					diceInd[i] = temp;
				}else {
					if(check(next,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
					
				}
			}else if(diceInd[i]>=21 && diceInd[i]<25) {
				if(next>=25) {
					if(check(next+7,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next+7;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}else {
					if(check(next,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}
			}else if(diceInd[i]>=25 && diceInd[i]<28) { 
				if(next>=28) {
					if(check(next+4,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next+4;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}else {
					if(check(next,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}
			}else if(diceInd[i]>=28 && diceInd[i]<32) {
				if(check(next,diceInd)) {
					int temp = diceInd[i];
					diceInd[i]= next;
					dfs(cnt+1,diceInd,score+map[diceInd[i]]);
					diceInd[i] = temp;
				}
			}else if(diceInd[i]>=32 && diceInd[i]<36){
				if(next>=36) {
					int temp = diceInd[i];
					diceInd[i]= 36;
					dfs(cnt+1,diceInd,score+map[diceInd[i]]);
					diceInd[i] = temp;
				}else {
					if(check(next,diceInd)) {
						int temp = diceInd[i];
						diceInd[i]= next;
						dfs(cnt+1,diceInd,score+map[diceInd[i]]);
						diceInd[i] = temp;
					}
				}
			}
		}
		
	}
	static boolean check(int next, int[] diceNum) {
		boolean exist = true;
		for(int i=0;i<4;i++){
			if(next==diceNum[i]) {
				if(next!=36)
					exist = false;
			}
		}
		return exist;
	}
	
	
}
