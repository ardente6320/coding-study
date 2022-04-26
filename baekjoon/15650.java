import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0,N,M,0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index,int N, int M, int depth) {
        if(depth == M) {
            print();
            return;
        }

        for(int i = index; i<N; i++) {
            arr[depth] = i +1;
            dfs(i + 1,N,M,depth+1);
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
