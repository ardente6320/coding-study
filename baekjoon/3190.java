import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static Object[][] movement;
    static Queue<Point> snake = new LinkedList<>();

    static int direction = 0;
    static int[] xDir = {0,1,0,-1}; //동서남북
    static int[] yDir = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        matrix = new int[n][n];

        //사과 위치 셋팅
        for(int i =0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            matrix[ax - 1][ay - 1] = 1;
        }

        //움직임 정보 저장
        int l = Integer.parseInt(br.readLine());
        movement = new Object[l][2];

        for(int i =0; i<l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            movement[i][0] = Integer.parseInt(st.nextToken());
            movement[i][1] = st.nextToken();
        }

        int time = 0;
        int movePos = 0;
        int x = 0;
        int y = 0;

        while(true) {
            //벽이거나 자기 몸인 경우
            if((x<0 || x>=n) || (y<0 || y>=n) || matrix[x][y] == 2) {
                break;
            }

            //앞으로 진행할 장소가 빈공간인 경우
            if(matrix[x][y]==0) {
                //꼬리 부분 0으로 변경
                Point point = snake.poll();
                if(point != null) matrix[point.x][point.y] = 0;
            }

            //머리 진행
            matrix[x][y] = 2;
            snake.add(new Point(x,y));

            //방향 전환 해야하는 경우인지 판단
            if(movePos < l && time == (Integer)movement[movePos][0]) {
                if("D".equals(movement[movePos][1])){
                    direction +=1;

                    if(direction == xDir.length) direction =0;
                }else {
                    direction -=1;

                    if(direction < 0) direction =xDir.length - 1;

                }
                movePos +=1;
            }

            //다음 장소로 이동
            x += xDir[direction];
            y += yDir[direction];

            time+=1;
        }

        bw.write(time+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
