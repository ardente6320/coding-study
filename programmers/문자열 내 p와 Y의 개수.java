class Solution {
    boolean solution(String s) {
        String p = s.replaceAll("[^pP]*","");
        String y = s.replaceAll("[^yY]","");
        
        return p.length() == y.length();
    }
}
