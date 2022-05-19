import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    
    static final int MAX_SIZE = 100001;
    static int min = MAX_SIZE;
  
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        BFS();
        
        bw.write(Integer.toString(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_SIZE];
        
        queue.add(new int[]{N,0});
        visited[N] = true;
        
        while(!queue.isEmpty()){
            int[] trace = queue.poll();
            
            //현재위치가 동생의 위치와 같을 경우
            if(K == trace[0]){
                min = Math.min(min,trace[1]);
            }
            
            //왼쪽, 오른쪽, 순간이동 거리 
            int left     = trace[0] - 1;
            int right    = trace[0] + 1;
            int teleport = trace[0] * 2;
            
            if(left     >= 0 && left      < MAX_SIZE && !visited[left]    ){
                queue.add(new int[]{left,trace[1] + 1});
                visited[left] = true;
            }
            if(right    >= 0 && right     < MAX_SIZE && !visited[right]   ){
                queue.add(new int[]{right,trace[1] + 1});
                visited[right] = true;
            }
            if(teleport >= 0 && teleport  < MAX_SIZE && !visited[teleport]){
                queue.add(new int[]{teleport,trace[1] + 1});
                visited[teleport] = true;
            }
        }
    }
}
