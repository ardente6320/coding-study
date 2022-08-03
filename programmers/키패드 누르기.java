import java.util.*;
class Solution {
    class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    Pos[] keypad = {new Pos(3,1), //0
                    new Pos(0,0),new Pos(0,1),new Pos(0,2), //1,2,3
                    new Pos(1,0),new Pos(1,1),new Pos(1,2), //4,5,6
                    new Pos(2,0),new Pos(2,1),new Pos(2,2)};//7,8,9
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        Pos left = new Pos(3,0);  //*
        Pos right = new Pos(3,2); //#
        
        boolean isLeft = hand.equals("left");
    
        for(int num : numbers){
            switch(num){
                case 1: case 4: case 7:
                    isLeft = true;
                    break;
                case 3: case 6: case 9:
                    isLeft = false;
                    break;
                default:
                    int leftLen = getManhattanDistance(left,keypad[num]);
                    int rightLen = getManhattanDistance(right,keypad[num]);

                    if(leftLen < rightLen){
                        isLeft = true;
                    }else if(leftLen > rightLen){
                        isLeft =false;
                    }else{
                        isLeft = hand.equals("left");
                    }
            }
            
            if(isLeft) left = keypad[num];
            else       right = keypad[num];
            
            sb.append(isLeft?"L":"R");
        }
        return sb.toString();
    }
    
    /**
     * 맨해튼 거리 계산
     **/
    private int getManhattanDistance(Pos pos, Pos target){
        return Math.abs(target.x - pos.x) + Math.abs(target.y - pos.y);
    }
}
