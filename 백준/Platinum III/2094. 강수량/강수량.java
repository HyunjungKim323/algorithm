import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N,M,X,Y;
	
	static class YearInfo{
		int year;
		int rain;
		public YearInfo(int year, int rain) {
			this.year = year;
			this.rain = rain;
		}
	}
	static YearInfo[] yearArr;
	static int[] tree;
	static int leafPointer;
	
	static class IndexInfo{
		int index;
		int rain;
		public IndexInfo(int index,int rain) {
			this.index = index;
			this.rain = rain;
		} 
	}
	
	static Map<Integer,IndexInfo> indexMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		initTree();
		yearArr = new YearInfo[N];
		
		StringTokenizer st;
		int year,rain;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			year = Integer.parseInt(st.nextToken());
			rain = Integer.parseInt(st.nextToken());
		
			yearArr[i] = new YearInfo(year, rain);
			tree[leafPointer + i] = rain;
			indexMap.put(year, new IndexInfo(i, rain));
		}
		
		initMaxTree();
		
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(question(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))+"\n");
		}
		bw.flush();
		
		
	}
	static String question(int y, int x) {
		String result;
		
		boolean containsY = indexMap.containsKey(y);
		boolean containsX = indexMap.containsKey(x);
		
		if(!containsY && !containsX) {
			result = "maybe";
		}
		else if (!containsY && containsX) {
			int xTreeIndex = indexMap.get(x).index;
			int pyTreeIndex = upperBoundYear(y);
			
			int max = query(pyTreeIndex,xTreeIndex-1);
			if(max>=indexMap.get(x).rain) {
				result="false";
			}else {
				result = "maybe";
			}
		}else if(containsY && !containsX) {
			int yTreeIndex = indexMap.get(y).index;
			int pxTreeIndex = upperBoundYear(x) - 1;
			
			int max = query(yTreeIndex +1 , pxTreeIndex);
			
			if(max<indexMap.get(y).rain) {
				result = "maybe";
			}else {
				result="false";
			}
		}else {
			int yTreeIndex = indexMap.get(y).index;
            int xTreeIndex = indexMap.get(x).index;
            int max = query(yTreeIndex + 1, xTreeIndex - 1);
            if(max >= indexMap.get(x).rain || indexMap.get(y).rain < indexMap.get(x).rain) {
            	result="false";
            }else if((y - x) == (yTreeIndex - xTreeIndex)){
            	result = "true";
            }else {
            	result ="maybe";
            }
		}
		return result;
	
	}
	
	static int query(int left, int right) {
		left = Math.max(left, 0);
		right = Math.min(right, N-1);
		
		left += leafPointer;
		right += leafPointer;
		int result =0;
		
		while(left<= right) {
			if(left %2 ==1) {
				result = Math.max(result,tree[left]);
				left++;
			}
			if(right % 2==0) {
				result = Math.max(result,tree[right]);
				right--;
			}
			
			left/=2;
			right/=2;
		}
		
		return result;
	}
	
	static void initTree() {
		int leafCount =1;
		while(N>leafCount) {
			leafCount <<=1;
		}
		
		tree = new int[2*leafCount];
		leafPointer = leafCount;
	}
	
	static void initMaxTree() {
		for(int i= leafPointer-1; i>0; i--) {
			tree[i] = Math.max(tree[2*i], tree[2*i+1]);
		}
	}
	
	static int upperBoundYear (int target) {
		int low = 0;
		int high = yearArr.length;
		int mid;
		while(low < high) {
			mid =(low+high)/2;
			if(yearArr[mid].year > target) {
				high =mid;
			}else {
				low = mid+1;
			}
		}
		return high;
	}

}
