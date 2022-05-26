import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node{
    public String value;
    public Node left;
    public Node right;

    public Node(String value) {
        this.value = value;
    }
}
public class Main {

    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            
            int N = Integer.parseInt(br.readLine());

            tree = new Node[N];
            Arrays.fill(tree, null);
            
            for(int i =0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String cur   = st.nextToken();
                String left  = st.nextToken();
                String right = st.nextToken();
                insertNode(cur,left.equals(".")?null:new Node(left),right.equals(".")?null:new Node(right));
            }

            preOrderTraversal(0);
            sb.append("\n");
            inOrderTraversal(0);
            sb.append("\n");
            postOrderTraversal(0);
            sb.append("\n");

            bw.write(sb.toString());
            bw.flush();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertNode(String cur, Node left, Node right) {
        int index = cur.charAt(0) - 'A';

        if(tree[index] == null) {
            Node node = new Node(cur);
            node.left = left;
            node.right = right;
            tree[index] = node;
        }
    }

    //전위 순회
    public static void preOrderTraversal(int index) {
        sb.append(tree[index].value);
        if(tree[index].left != null) preOrderTraversal(tree[index].left.value.charAt(0) - 'A');
        if(tree[index].right != null) preOrderTraversal(tree[index].right.value.charAt(0) - 'A');

    }
    
    //중위 순회
    public static void inOrderTraversal(int index) {
        if(tree[index].left != null) inOrderTraversal(tree[index].left.value.charAt(0) - 'A');
        sb.append(tree[index].value);
        if(tree[index].right != null) inOrderTraversal(tree[index].right.value.charAt(0) - 'A');

    }
    
    //후위 순회
    public static void postOrderTraversal(int index) {
        if(tree[index].left != null) postOrderTraversal(tree[index].left.value.charAt(0) - 'A');
        if(tree[index].right != null) postOrderTraversal(tree[index].right.value.charAt(0) - 'A');
        sb.append(tree[index].value);
    }
}
