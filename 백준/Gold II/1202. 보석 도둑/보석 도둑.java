import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static int N,K;
	static Jewel[] bosuks;
	static int[] bags;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] firstLine = br.readLine().split(" ");
		
		N = Integer.parseInt(firstLine[0]);
		K = Integer.parseInt(firstLine[1]);
		bosuks = new Jewel[N];
		bags = new int[K];
		for(int i =0;i<N;i++) {
			String[] line = br.readLine().split(" ");
			bosuks[i] = new Jewel(Integer.parseInt(line[0]),Integer.parseInt(line[1]));	
		}
		for(int i=0;i<K;i++) {
			String line = br.readLine();
			bags[i] = Integer.parseInt(line);
		}
		
		Arrays.sort(bosuks,(j1,j2)->{
			return j1.M-j2.M;
		});
		
		Arrays.sort(bags);
		
		// 가격이 높은 보석 순으로 정렬
		PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>(){
			@Override
			public int compare(Jewel j1,Jewel j2) {
				return Integer.compare(j2.V, j1.V);
			}
		});
		int jewelArrIndex = 0;
		for(int i=0;i<K;i++) {
			while(jewelArrIndex<N && bosuks[jewelArrIndex].M <= bags[i]) {
				pq.add(bosuks[jewelArrIndex++]);
			}
			if(!pq.isEmpty()){
                ans += pq.poll().V;
            }
			
		}
		System.out.println(ans);
		
		
	}
}	
class Jewel {
	public int M;
	public int V;
	
	public Jewel() {
		
	}
	public Jewel(int M, int V) {
		this.M = M;
		this.V = V;
	}
	
	
}