import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,1,0,0}; //상하
    static int[] dc = {0,0,-1,1}; //좌우
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int cnt = 0;
        Map<Integer,Integer> houses = new HashMap<>();

        //지도 셋팅
        for(int i = 0; i<N; i++) {
            String[] str = br.readLine().split("");

            for(int j =0; j<str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        //DFS 탐색
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;

                //해당 동 셋팅
                houses.put(cnt, 0);
                dfs(i,j,cnt,houses);
                cnt++;
            }
        }

        //오름 차순 정렬
        List<Integer> list  = new ArrayList<>(houses.values());
        Collections.sort(list);

        bw.write(Integer.toString(cnt));
        bw.newLine();

        for(int i =0;i<cnt; i++) {
            bw.write(Integer.toString(list.get(i)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int cnt, Map<Integer,Integer> houses) {
        visited[r][c] = true;
        //해당 하는 동에 집 추가
        houses.put(cnt,houses.get(cnt)+1);

        for(int i = 0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >=N || nc <0 || nc >=N) continue;
            if(map[nr][nc] == 0 || visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr,nc,cnt,houses);
        }
    }
}
