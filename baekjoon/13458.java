import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer rooms = new StringTokenizer(br.readLine()," ");
        StringTokenizer admins = new StringTokenizer(br.readLine()," ");

        int B = Integer.parseInt(admins.nextToken());
        int C = Integer.parseInt(admins.nextToken());

        long adminCnt = N;

        while(rooms.hasMoreTokens()) {
            int studentCnt = Integer.parseInt(rooms.nextToken());

            if(studentCnt > B) {
                studentCnt -= B;
                adminCnt += (long)studentCnt / C;
                adminCnt += studentCnt % C != 0 ?1:0;
            }

        }
        bw.write(adminCnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
