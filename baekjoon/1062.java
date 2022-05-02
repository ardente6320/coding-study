import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static String[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int mask = 0;
        mask |= (1 << 'a'-'a');
        mask |= (1 << 'n'-'a');
        mask |= (1 << 't'-'a');
        mask |= (1 << 'c'-'a');
        mask |= (1 << 'i'-'a');

        arr = new String[N];

        for(int i =0; i<N; i++) {
            arr[i] = br.readLine().replaceAll("[a,n,t,c,i]", "");
        }

        if(K < 5) {
            bw.write("0\n");
        }else if(K==26) {
            bw.write(N+"\n");
        }else {
            DFS(0,0,mask);
            bw.write(max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int alpha, int cnt,int mask) {
        if(cnt == K-5) { //초기 5개를 제외한 나머지 글자
            int word = 0;

            for(int i = 0; i < N; i++) {
                boolean educated = true;
                for(char c : arr[i].toCharArray()) {
                    if((mask & (1 << (c - 'a'))) == 0) {
                        educated = false;
                        break;
                    }
                }
                if(educated) word++;
            }
            max = Math.max(max, word);
            return;
        }

        for(int i = alpha; i < 26; i++) { //알파벳 가르치기 시작
            if((mask & (1 << i)) == 0) { //한번도 가르치지 않은 경우 가르침
                mask |= (1 << i);
                DFS(i,cnt + 1,mask);
                mask &= ~(1 << i);
            }
        }
    }
}
