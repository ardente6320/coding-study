import java.util.*; 

class Solution {
    private boolean [][] visit;
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,-1,0,1};
    
    public int solution(int[][] maps) {
        int cnt = 10001;
        
        int N = maps.length;
        int M = maps[0].length;
        
        boolean isApproached = false;
        visit = new boolean[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0,0,1});
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            
            if(pos[0] == N -1  && pos[1] == M -1){
                isApproached = true;
                cnt = Math.min(cnt,pos[2]);
            }
            
            for(int i = 0; i<4; i++){
                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];
                
                if(x < 0 || x >= N || y < 0 || y >= M ) continue;
                if(maps[x][y] == 0) continue;
                if(visit[x][y]) continue;
                
                visit[x][y] = true;
                queue.add(new int[]{x,y,pos[2] + 1});
            }
        }
        return isApproached?cnt:-1;
    }
}
