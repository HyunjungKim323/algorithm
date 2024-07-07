import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


public class Main {
    static int n;
    static char[][] map;
    static int[][] height;
    static boolean[][] visited;
    static int min = 1000000;
    static int K = 0;
    static int[] dx = {-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,-1,1,1,1,-1,-1};
    static int startRow=0;
    static int startColumn=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        height = new int[n][n];
        
        Set<Integer> allHeight = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<n;j++) {
                map[i][j]= line.charAt(j);
                if(map[i][j]=='P') {
                    startRow = i;
                    startColumn = j;         
                }else if(map[i][j]=='K'){
                    K++;
                }
            }
        
        }
        
        for(int i=0;i<n;i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                height[i][j]= Integer.parseInt(line[j]);        
                allHeight.add(height[i][j]);
            }
        }
        
        int size = allHeight.size();
        int[] arrayHeight = allHeight.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arrayHeight);
        int rightIndex =0;
        
        for(int i=0;i<size;i++) {
        	while(rightIndex<size && !bfs(map,height,arrayHeight[i],arrayHeight[rightIndex])) {	
        		rightIndex++;
        	}
        	if(rightIndex==size)
        		break;
        	min = Math.min(min,arrayHeight[rightIndex]-arrayHeight[i]);
        }
        
        System.out.println(min);

    }
    public static boolean bfs(char[][] map, int[][] height, int minHeight, int maxHeight){
        int N = map.length;
        int visit =0;
        boolean[][] visited = new boolean[N][N];
        visited[startRow][startColumn]=true;
        if(height[startRow][startColumn]<minHeight || height[startRow][startColumn]>maxHeight)
        	return false;
        
        Queue<int[]> goNow = new ArrayDeque<>();
        goNow.add(new int[]{startRow,startColumn});

        while(!goNow.isEmpty()){
            int len = goNow.size();
            for(int i=0;i<len;i++){
                int[] t = goNow.poll();
                int x = t[0];
                int y = t[1];
                for(int j=0;j<8;j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    if(nx>=0 && nx<map.length && ny>=0 && ny< map.length && visited[nx][ny]==false){
                        if(height[nx][ny]>=minHeight && height[nx][ny]<=maxHeight){
                            goNow.add(new int[]{nx,ny});
                            visited[nx][ny]=true;
                            if(map[nx][ny]=='K'){
                                visit++;
                            }
                        }
                    }
                }
            }
            if(visit==K)
                return true;
        }
        return false;
    }
}
