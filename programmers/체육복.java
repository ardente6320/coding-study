import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer =0;
        
        int[] student = new int[n + 2];
        Arrays.fill(student, 1);
        
        Arrays.sort(lost);
        
        for(int i : reserve) student[i] += 1;       
        
        for(int i : lost) student[i] -= 1;
        
        for(int i : lost){      
            if(student[i] == 0){
                if(student[i -1] == 2){
                    student[i -1] -=1;
                    student[i] +=1;
                }else if(student[i +1] == 2){
                    student[i + 1] -=1;
                    student[i] += 1;
                }
            }
            
        }
        
        for(int i =1; i<=n; i++) {
            answer += student[i] > 0? 1:0;
        }
        return answer;
    }
}
