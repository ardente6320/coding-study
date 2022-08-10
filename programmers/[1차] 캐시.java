import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        for(String city : cities) {
            String lowerCity = city.toLowerCase();
            if(list.contains(lowerCity)) {
                list.remove(lowerCity);
                answer +=1;
            }else {
                if(cacheSize > 0 && list.size() ==cacheSize) {
                    list.remove(0);
                }
                answer +=5;
            }
            if(cacheSize > 0){
                list.add(lowerCity);
            }
        }
        return answer;
    }
}
