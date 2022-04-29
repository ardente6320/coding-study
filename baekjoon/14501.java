import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] checked;
    static int max= 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        checked = new boolean[n];

        for(int i =0; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,n);

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index, int sum, int n) {

        for(int i = index; i<n; i++) {
            if(checked[i]) continue;

            //남은 일을 지나지 않는 경우 진입
            //현재일 + 상담일 <= 남은 일
            if(i + arr[i][0] <= n) {
                checked[i] = true;
                dfs(i + arr[i][0], sum + arr[i][1],n);
                checked[i] = false;
            }
        }

        max = max < sum ? sum : max;
    }
}
