import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for(int i =0; i<T; i++) {
            char[] arr = br.readLine().toCharArray();
            stack.clear();

            for(int j = 0; j<arr.length; j++) {
                String c = Character.toString(arr[j]);
                if(!stack.isEmpty() && (stack.peek()+c).equals("()")) {
                    stack.pop();
                }else{
                    stack.add(c);
                }
            }

            sb.append(stack.isEmpty()? "YES\n":"NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
