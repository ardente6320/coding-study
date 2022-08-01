class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sqrt = (int)Math.sqrt(n);
        
        //제곱근 만큼 루프
        for(int i =1; i<=sqrt; i++){
            if(n % i ==0){
                answer+=i; //작은 수에 대한 값
                if(n / i != i)
                    answer += n / i; //큰수에 대한 값
            }
        }
        return answer;
    }
}
