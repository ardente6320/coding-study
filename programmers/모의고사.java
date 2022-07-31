import java.util.*;
class Solution {
    
    public int[] solution(int[] answers) {
        
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
       
        int[] res = {0,0,0};
        for(int i =0; i<answers.length; i++){
            if(answers[i] == person1[i % person1.length]) res[0] ++;
            if(answers[i] == person2[i % person2.length]) res[1] ++;
            if(answers[i] == person3[i % person3.length]) res[2] ++;
        }
        
		int max = Arrays.stream(res).max().getAsInt();
        List<Integer> pList= new ArrayList<>();
        
        for(int i=0; i<res.length; i++){
            if(max ==res[i])pList.add(i+1);
        }
        
        return pList.stream()
                    .sorted()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
