import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0}; //상하
    static int[] dc = {0,0,-1,1}; //좌우
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int N,M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int greenTomato = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i< N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int size = st.countTokens();
            for(int j =0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    queue.add(new int[] {i,j,0});
                    visited[i][j] = true;
                }else if(map[i][j] == 0) {
                    greenTomato += 1;
                }
            }
        }

        bw.write(Integer.toString(BFS(greenTomato)));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS(int greenTomato) {
        int day = 0;
        int curTomato = 0;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int i =0; i<4; i++) {
                int r = point[0] + dr[i];
                int c = point[1] + dc[i];

                if(r < 0 || r >= N || c < 0 || c >= M) continue;
                if(map[r][c] != 0 || visited[r][c]) continue;

                visited[r][c] = true;

                day = point[2] + 1;
                queue.add(new int[] {r,c,day});

                curTomato +=1;
            }
        }

        //현재 익어갔던 수와 안익었던 수 비교하여 날짜 출력
        return  curTomato>= greenTomato? day : -1 ;
    }
}
