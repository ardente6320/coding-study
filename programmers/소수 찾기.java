class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] prime = new int[n+1];
        
        prime[0] = 0;
        prime[1] = 0;
        
        for(int i =2; i<=n; i++){
            //배수의 경우 소수가 아니기 때문에 1로 설정
            for(int j = 2 * i; j<=n; j+=i){
                prime[j] = 1;
            }
            
            answer += prime[i] == 0?1:0;
        }
        
        return answer;
    }
}
