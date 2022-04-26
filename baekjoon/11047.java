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

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int mok = 0;
        int[] num = new int[n];

        for(int i =0; i<n; i++) num[i] = Integer.parseInt(br.readLine());

        for(int i = n-1; i>=0; i--) {
            mok = k / num[i];
            if(mok > 0) {
                cnt += mok;
                k %= num[i];
            }
        }

        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
