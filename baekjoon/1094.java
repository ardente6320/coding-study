import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        int len = 64;
        int cnt = 0;
        while(len != 0) {
            //구하고자 하는 값과 같은 비트가 있으면 개수에 추가
            cnt += Integer.bitCount(len & x);
            //우측으로 비트마스킹(빈칸은 0으로 채우기)
            len = len >>> 1;
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
