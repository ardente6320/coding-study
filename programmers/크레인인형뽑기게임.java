import java.util.*;

class Solution {
    private int getDoll(int[][] board, int pos){
        int doll = -1;
        for(int i =0; i<board.length; i++){
            if(board[i][pos] != 0){
                doll = board[i][pos];
                board[i][pos] = 0;
                break;
            }
        }    
        return doll;
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();

        for(int move : moves){
            int doll = getDoll(board,move -1);

            if(doll != -1){
                if(basket.empty() || basket.peek() != doll){
                    basket.push(doll);
                }else{
                    basket.pop();
                    answer+=2;
                }
            }
        }
        return answer;
    }
}
