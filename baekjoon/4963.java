import java.io.*;
import java.util.*;

public class Main {

    //8방향 확인
    static int[] dw = {-1,-1,-1,0,0,1,1,1};
    static int[] dh = {-1,0,1,-1,1,-1,0,1};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) break;

            int land = 0;
            map = new int[H][W];
            visited = new boolean[H][W];

            for(int i = 0 ; i< H; i++) {
                st = new StringTokenizer(br.readLine()," ");

                for(int j = 0; j<W; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < H; i++) {
                for(int j = 0; j< W; j++) {
                    if(map[i][j] == 0 || visited[i][j]) continue;
                    
                    //땅이면서 방문하지 않으면 탐색시작
                    DFS(i,j,W,H);
                    land += 1;
                }
            }
            sb.append(Integer.toString(land) + "\n");
        }
        
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int r, int c, int W,int H) {
        visited[r][c] = true;

        //8방향 탐색 시작
        for(int i =0; i<8; i++) {
            int nr = r + dh[i];
            int nc = c + dw[i];

            if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if(map[nr][nc] == 0 || visited[nr][nc]) continue;

            visited[nr][nc] = true;

            DFS(nr,nc,W,H);
        }
    }
}
