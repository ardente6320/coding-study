import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer nst = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(br.readLine());
        StringTokenizer mst = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];
        int[] target = new int[M];

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(nst.nextToken());
        for(int i = 0; i < M; i++) target[i] = Integer.parseInt(mst.nextToken());

        //오름 차순 정렬
        Arrays.sort(arr);

        for(int val : target) {

            //이분 탐색 진행
            int start = 0;
            int end = N-1;
            int result = 0;
            while(start <= end) {
                int mid = (start + end) / 2;

                if(arr[mid] == val) {
                    result = 1;
                    break;
                }

                start = arr[mid] < val ? mid + 1 : start  ;
                end   = arr[mid] < val ? end     : mid -1 ;
            }
            sb.append(result+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
