import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class NumberCount implements Comparable<NumberCount>{
	int number;
	int count;
	
	public NumberCount(int number, int count) {
		this.number = number;
		this.count = count;
	}
	@Override
	public int compareTo(NumberCount n) {
		if(count==n.count)
			return number-n.number;
		return count-n.count;
	}
}

public class Main {
	
	static int r,c,k;
	static int[][] array = new int[101][101];
	static int Fx = 3;
	static int Fy = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k =Integer.parseInt(st.nextToken());
		for(int i=1;i<=Fx;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=Fy;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans =0;
		while(array[r][c] !=k) {
			rc(Fx,Fy);
			ans++;
			if(ans>100)
				break;
		}
		if(ans==101)
			System.out.println(-1);
		else
			System.out.println(ans);		
		
	}
	public static void rc(int x,int y) {
		if(x>=y) {
			//R연산
			for(int i=1;i<=x;i++) {
				Map<Integer,Integer> nc = new TreeMap<>();
				for(int j=1;j<=y;j++) {
					if(array[i][j]==0)
						continue;
					if(nc.containsKey(array[i][j])) {
						nc.put(array[i][j],nc.get(array[i][j])+1);
					}else {
						nc.put(array[i][j],1);
					}
				}
				int length = nc.size();
				
				NumberCount[] sortArr = new NumberCount[length];
				int index =0;
				for(Map.Entry<Integer, Integer> ncEntry: nc.entrySet()) {
					int num = ncEntry.getKey();
					int cnt = ncEntry.getValue();
					sortArr[index++] = new NumberCount(num,cnt);
				}
				Arrays.sort(sortArr);
				int rcIndex = 1;
				for(int k=0;k<length;k++) {
					array[i][rcIndex++] = sortArr[k].number;
					array[i][rcIndex++] = sortArr[k].count;
				}
				for(int k=rcIndex;k<=Fy;k++) {
					array[i][k]=0; 
				}
				Fy = Math.max(Fy, rcIndex-1);
			}
		}else {
			//C연산
			for(int i=1;i<=y;i++) {
				Map<Integer,Integer> nc = new TreeMap<>();
				for(int j=1;j<=x;j++) {
					if(array[j][i]==0)
						continue;
					if(nc.containsKey(array[j][i])) {
						nc.put(array[j][i],nc.get(array[j][i])+1);
					}else {
						nc.put(array[j][i],1);
					}
				}
				int length = nc.size();
				
				NumberCount[] sortArr = new NumberCount[length];
				int index =0;
				for(Map.Entry<Integer, Integer> ncEntry: nc.entrySet()) {
					int num = ncEntry.getKey();
					int cnt = ncEntry.getValue();
					sortArr[index++] = new NumberCount(num,cnt);
				}
				Arrays.sort(sortArr);
				int rcIndex = 1;
				for(int k=0;k<length;k++) {
					array[rcIndex++][i] = sortArr[k].number;
					array[rcIndex++][i] = sortArr[k].count;
				}
				for(int k=rcIndex;k<=Fy;k++) {
					array[k][i]=0; 
				}
				Fx = Math.max(Fx, rcIndex-1);
			}
		}
	}
}
