class Solution {
    private int[] primeMap = new int [10000000];
    private boolean[] primeCheck = new boolean[10000000];
    private char[] numChars;
    private boolean[] checked;
    private int primeCnt =0;
    
    public int solution(String numbers) {
        
        //소수 셋팅
        primeMap[0] = 1;
        primeMap[1] = 1;
        for(int i = 2; i<primeMap.length; i++){
            for(int j = 2* i; j< primeMap.length; j+=i){
                primeMap[j] = 1;
            }
        }
        
        numChars = numbers.toCharArray();
        checked = new boolean[numChars.length];
        
        for(int i =0; i<numChars.length; i++){
            checked[i] = true;
            dfs(""+numChars[i],i);
            checked[i] = false;
        }
        return primeCnt;
    }
    
    private void dfs(String numStr, int index){
        int num = Integer.parseInt(numStr);
        if(primeMap[num] == 0 && !primeCheck[num]){
            System.out.println(num);
            primeCnt += 1;
            primeCheck[num] = true;
        }
        
        for(int i = 0; i < numChars.length; i++){
            if(checked[i]) continue;
            
            checked[i] = true;
            dfs(numStr + numChars[i],i+1);
            checked[i] = false;
        }
    }
}
