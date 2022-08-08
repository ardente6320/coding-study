class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i =0; i<= n; i++){
            for(int j = i; j <= n; j++){
                if(sigma(j) - sigma(i) == n){
                    answer++;
                }else if(sigma(j) - sigma(i) > n){
                    break;
                }
            }
        }        
        return answer;
    }
    
    private int sigma(int a){
        return (a*(a+1)) /2;
    }
}
