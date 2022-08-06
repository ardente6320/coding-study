class Solution {
    public int solution(int[] arr) {
        
        //두 수의 최소 공배수 lcm = A * B / GCD(max(A,B),min(A,B))
        //N개의 최소공배수를 구할 경우
        //EX) A, B, C의 최소공배수를 구하는 경우는
        //A,B 의 최소공배수 ABLCM을 구하고, ABLCM과 C의 최소공배수를 구하면 된다.
        int lcm = arr[0];
        for(int i =1; i<arr.length; i++){
            lcm = (arr[i] * lcm) / GCD(Math.max(lcm,arr[i]),Math.min(lcm,arr[i]));
        }
        
        return lcm;
    }  
    
    /**
     * 최대 공약수 반환
    **/
    private int GCD(int a,int b){
        if(a % b ==0)
            return b;
        return GCD(b, a % b);
    }
}
