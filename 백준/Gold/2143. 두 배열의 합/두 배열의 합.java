import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] nNumber;
    static int[] mNUmber;
    static long count=0L;
    static Map<Integer,Long> aMap;
    static Map<Integer,Long> bMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[] nArray = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] mArray = br.readLine().split(" ");
        int[] nNumber = new int[n];
        int[] mNumber = new int[m];
        int[] nSum = new int[n+1];
        int[] mSum = new int[m+1];
        aMap= new HashMap<>();
        bMap = new HashMap<>();

        for(int i=0;i<n;i++) {
            nNumber[i] = Integer.parseInt(nArray[i]);
            nSum[i+1]= nSum[i]+nNumber[i];
        }
        for(int i=0;i<m;i++) {
            mNumber[i] = Integer.parseInt(mArray[i]);
            mSum[i+1]= mSum[i]+mNumber[i];
        }

        for(int i=0;i<n+1;i++) {
            for(int j=i+1;j<n+1;j++) {
                int value = nSum[j]-nSum[i];
                aMap.put(value,aMap.getOrDefault(value, 0L)+1);
            }
        }

        for(int i=0;i<m+1;i++) {
            for(int j=i+1;j<m+1;j++) {
                int value = mSum[j]-mSum[i];
                bMap.put(value,bMap.getOrDefault(value, 0L)+1);
            }
        }

        for(Map.Entry<Integer,Long> am : aMap.entrySet()) {
            Integer intKey = am.getKey();
            Long countN = am.getValue();
            Long countM = bMap.get(T-intKey);
            if(countM!=null)
                count+=countN*countM;
        }

        System.out.println(count);
    }
}

