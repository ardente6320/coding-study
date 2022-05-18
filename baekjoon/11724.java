import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        visited = new boolean[N+1];

        for(int i = 0; i<=N; i++) graph.add(new ArrayList<>());

        for(int e = 0; e < M; e++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i<=N; i++) {
            if(visited[i]) continue;

            //연결 요소 추가
            DFS(i);
            cnt += 1;
        }

        bw.write(Integer.toString(cnt));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int index) {
        visited[index] = true;

        for(Integer v : graph.get(index)) {
            if(visited[v]) continue;

            visited[v] = true;
            DFS(v);
        }
    }
}
