import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i =0; i<n; i++){
            answer[i] = lpad(n,Integer.toBinaryString(arr1[i] | arr2[i])).replaceAll("[1]","#")
                                                                         .replaceAll("[0]"," ");
        }
        return answer;
    }
    
    private String lpad(int n,String str){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n - str.length(); i++){
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }
}
