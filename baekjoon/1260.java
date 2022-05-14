import java.io.*;
import java.util.*;

public class Main{

    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph.add(null);
        visited = new boolean[N+1];

        for(int i = 0; i<N; i++) graph.add(new ArrayList<Integer>());

        //정점에 대한 간선 삽입
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //정점에 대한 간선 오름차순 정렬
        for(int i =1; i<=N; i++) Collections.sort(graph.get(i));

        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index){
        //방문 처리
        visited[index] = true;
        sb.append(index+" ");
        
        //깊이 우선 탐색 진행
        for(Integer v : graph.get(index)){
            if(visited[v]) continue;
            dfs(v);
        }
    }

    public static void bfs(int index){
        //방문 처리
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()){
            int i = queue.poll();
            sb.append(i+" ");

            //인접 노드 탐색
            //너비 우선 탐색 진행
            for(Integer v : graph.get(i)){
                if(visited[v]) continue;
                visited[v] = true;
                queue.add(v);
            }
        }
    }
}
