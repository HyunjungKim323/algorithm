import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	static ArrayList<ArrayList<City>> a;
	static long[][] minDistance;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		minDistance = new long[N+1][K+1];
		
		a = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			a.add(new ArrayList<>());
			for(int j=0;j<=K;j++) {
				minDistance[i][j] = Long.MAX_VALUE/2;
			}
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int startPos = Integer.parseInt(st.nextToken());
			int endPos = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			a.get(startPos).add(new City(endPos,distance,0));
			a.get(endPos).add(new City(startPos,distance,0));
		}
		
		dijkstra(1);
		long ans = Long.MAX_VALUE/2;
		for(int i=0;i<=K;i++) {
			ans = Math.min(ans, minDistance[N][i]);
		}
		bw.write(ans+"\n");
		bw.flush();
	}
	static void dijkstra(int start) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.offer(new City(start,0,0));
		minDistance[start][0] = 0;
		while(!pq.isEmpty()) {
			City now = pq.poll();
			if(minDistance[now.next][now.cnt]<now.distance) continue;
			for (City city : a.get(now.next)) {
				if(minDistance[city.next][now.cnt] > minDistance[now.next][now.cnt]+ city.distance) {
					minDistance[city.next][now.cnt]=  minDistance[now.next][now.cnt]+ city.distance;
					pq.offer(new City(city.next,minDistance[city.next][now.cnt],now.cnt));
				}
				
				if(now.cnt+1<=K && minDistance[city.next][now.cnt+1]>minDistance[now.next][now.cnt]) {
					minDistance[city.next][now.cnt+1] = minDistance[now.next][now.cnt];
					pq.offer(new City(city.next,minDistance[city.next][now.cnt+1],now.cnt+1));
				}
			}
		}
	}

}




class City implements Comparable<City>{
	int next;
	long distance;
	int cnt;
	
	public City(int next,long distance,int cnt) {
		this.next = next;
		this.distance = distance;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(City c) {
		return Long.compare(distance,c.distance);
	}
}