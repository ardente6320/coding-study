import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        dfs(N,M,0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            print();
            return;
        }

        for(int i = 0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i +1;
                dfs(N,M,depth+1);
                visit[i] = false;
            }
        }
    }

    public static void print(){
        for(int val : arr) {
            sb.append(val);
            sb.append(" ");
        }
        sb.append("\n");
    }
}
