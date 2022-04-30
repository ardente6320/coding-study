import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i =0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = arr[0];
        int max = dp[0];
        
        for(int i =1; i<n; i++){
            //이전 누적합과 현재값을 더한 값과 현재 값 중 큰 값
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
        }
        
        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
