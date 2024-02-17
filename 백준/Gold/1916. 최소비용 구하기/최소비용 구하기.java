import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	Node(int end, int weight){
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

public class Main {
	static int N,M;
	static ArrayList<ArrayList<Node>> a;
	static int[] dist;
	static boolean[] check;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter( new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		a = new ArrayList<>();
		dist = new int[N+1];
		check = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
        for(int i=0;i<=N;i++) {
			a.add(new ArrayList<>());
		}
        
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			a.get(start).add(new Node(end,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startPos = Integer.parseInt(st.nextToken());
		int endPos = Integer.parseInt(st.nextToken());
		
		bw.write(dijkstra(startPos,endPos) + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	
	}
	
	public static int dijkstra(int start, int end ) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check= new boolean[N+1];
		pq.offer(new Node(start,0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end; // 현재 노드의 종착지
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Node node:a.get(cur)) {
					if(!check[node.end] && dist[node.end] > dist[cur] + node.weight){
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
                }
			}
		}
		
		return dist[end];
	
	}

}
