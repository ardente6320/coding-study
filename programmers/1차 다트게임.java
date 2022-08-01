import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = Arrays.stream(dartResult.replaceAll("[^0-9]"," ").replaceAll("\\s{1,}"," ").split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String[] bonus = dartResult.replaceAll("[0-9]"," ")
                                   .replaceAll("\\s{1,}"," ")
                                   .replaceAll("^\\s","").split(" ");
        
        for(int i =0; i<3; i++){
            
            for(char c : bonus[i].toCharArray()){
                if(c == 'S') continue;
                else if(c == 'D') score[i] = (int)Math.pow(score[i],2);
                else if(c == 'T') score[i] = (int)Math.pow(score[i],3);
                else if(c == '#') score[i] *= -1;
                else if(c == '*') {
                    if(i != 0){
                        score[i -1] *=2;
                    }    
                    score[i] *= 2;
                }
            }
        }
        
        for(int num : score) answer += num;
        return answer;
    }
}
