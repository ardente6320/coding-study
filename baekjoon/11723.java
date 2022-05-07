import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        int set = 0;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            String mode = st.nextToken();

            switch(mode){
                case "add":
                    set |= (1 << Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set &= (~(1 << Integer.parseInt(st.nextToken())));
                    break;
                case "check":
                    int chk = set & (1 << Integer.parseInt(st.nextToken()));
                    sb.append(chk==0 ? "0\n":"1\n");
                    break;
                case "toggle":
                    set ^= (1 << Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    set = (1 << 21) -1;
                    break;
                case "empty":
                    set =0;
                    break;            
            }
        }

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
