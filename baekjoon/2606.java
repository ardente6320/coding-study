import java.io.*;
import java.util.*;

public class Main{

    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int addicted = 0;
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];

        
        graph.add(null);
        for(int i =1; i<=V; i++)graph.add(new ArrayList<>());
        
        for(int i =0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        bfs();
        bw.write(Integer.toString(addicted));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(){
        //1번 부터 시작
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int i = queue.poll();

            for(Integer v : graph.get(i)){
                if(visited[v]) continue;

                visited[v] = true;
                addicted +=1; //바이러스 감염 추가
                queue.add(v);
            }
        }
    }
}
