import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,1,0,0}; //상하
    static int[] dc = {0,0,-1,1}; //좌우
    static int[][] map;
    static boolean[][] visited;
    static int N,M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i< N; i++) {
            String[] row = br.readLine().split("");
            for(int j = 0; j< row.length; j++) map[i][j] = Integer.parseInt(row[j]);
        }


        bw.write(Integer.toString(BFS()));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int trace = 0;

        if(map[0][0] == 0) {
            return trace;
        }

        queue.add(new int[] {0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            if(point[0] == N -1 && point[1] == M-1) {
                trace = point[2];
                break;
            }

            for(int i =0; i<4; i++) {
                int r = point[0] + dr[i]; //행
                int c = point[1] + dc[i]; //열
                int cnt = point[2] + 1;   //이전까지 지나온 길이 + 1

                if(r < 0 || r >= N || c < 0 || c >= M) continue;
                if(map[r][c] == 0 || visited[r][c]) continue;
                visited[r][c] = true;
                queue.add(new int[] {r,c,cnt});
            }
        }
        return trace;
    }
}
