import java.io.*;
import java.util.*;

public class Main{
   
    static int[] dx = {-1,0,1,0}; //상하
    static int[] dy = {0,-1,0,1}; //좌우

    static int[][] map;
    static boolean[][] visited;

    static int N,M,K;
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int cnt = 0;

            map = new int[M][N];
            visited = new boolean[M][N];

            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            //Map을 돌면서 확인
            for(int i = 0; i<M; i++){
                for(int j =0; j<N; j++){
                    if(map[i][j] == 0 || visited[i][j])continue;

                    cnt++;
                    dfs(i,j);
                }
            }

            bw.write(Integer.toString(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int row, int col){
        visited[row][col] = true;

        //상하좌우 확인
        for(int i = 0; i<4; i++){
            int nRow = row + dy[i];
            int nCol = col + dx[i];

            if(nRow < 0 || nRow >= M || nCol < 0 || nCol >= N) continue;
            if(map[nRow][nCol] == 0 || visited[nRow][nCol])continue;

            dfs(nRow,nCol);
        }
    }
}
