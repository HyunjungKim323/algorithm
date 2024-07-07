import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static int N, homeNum=0;
	static char[][] home;
	static int[][] tired;
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> queue;
	static int px=0,py=0;
	static int minHeight=1000000,maxHeight=0;
	static int[] dx = {0,0,1,-1,1,1,-1,-1};
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	static Set<Integer> heightSet;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		queue = new LinkedList<>(); // 우선 순위 큐로 했을 떄 차이점
		//queue = new PriorityQueue<>();
		heightSet = new TreeSet<>();
		home = new char[N][N];
		tired = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				home[i][j] = line.charAt(j);
				if(home[i][j]=='P') {
					px = i;
					py = j;
				}
			}
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				tired[i][j] = Integer.parseInt(st.nextToken());	
				heightSet.add(tired[i][j]);
				
				if(home[i][j]=='K') {
					homeNum++;
					if(tired[i][j]<minHeight)
						minHeight = tired[i][j];
					if(tired[i][j]>maxHeight)
						maxHeight = tired[i][j];
				}
				if(home[i][j]=='P') {
					if(tired[i][j]<minHeight)
						minHeight = tired[i][j];
					if(tired[i][j]>maxHeight)
						maxHeight = tired[i][j];
				}
			}
		}
		
		Integer[] hArray = new Integer[heightSet.size()];
        heightSet.toArray(hArray);
        int rightIndex = 0;
        for(int i=0;i<heightSet.size();i++) {
        	if(maxHeight==hArray[i])
        		rightIndex= i;
        }
        
        
        for(int i=0;i<heightSet.size();i++) {
        	while(rightIndex<heightSet.size()) {
        		
        		if(travel(hArray[i],hArray[rightIndex])) {
        			min = Math.min(min, hArray[rightIndex]-hArray[i]);
        			break;
        		}else {
        			
        			rightIndex++;
        		}
        	}
        }   
		System.out.println(min);
	}
	
	//minHeight, maxHeight 가 주어졌을때 가능한지
	public static boolean travel(int min, int max) {
		queue.add(new int[] {px,py});
		visited = new boolean[N][N];
		visited[px][py] = true;
		int visitHome =0;
        if(tired[px][py]<min || tired[px][py]>max)
			return false;
		
		while(!queue.isEmpty()) {
			int[] t = queue.poll();
			for(int i=0;i<8;i++) {
				int nx = t[0]+dx[i];
				int ny = t[1]+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && tired[nx][ny]>=min && tired[nx][ny]<=max) {
					visited[nx][ny]= true;
					queue.add(new int[] {nx,ny});
					if(home[nx][ny]=='K') {
						visitHome++;
					}
				}
			}
		}
		
		if(visitHome==homeNum) {
			return true;
		}
		return false;
	}
	 
}
