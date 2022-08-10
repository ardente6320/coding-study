mport java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("^[\\{]+|[\\}]+$", "").split("\\}\\,\\{");

        String[][] tuple = new String[arr.length][];

        for(int i =0; i<arr.length; i++) {
            tuple[i] = arr[i].split(",");
        }

        Arrays.sort(tuple, (String[] arg0, String[] arg1) -> arg0.length - arg1.length);

        Set<String> set = new LinkedHashSet<>();
        for(String[] row : tuple) {
            for(String col : row) {
                if(!set.contains(col)) {
                    set.add(col);
                }
            }
        }

        int[] answer = new int[set.size()];
        
        Iterator<String> iter = set.iterator();
        for(int i =0; iter.hasNext(); i++) {
            answer[i] = Integer.parseInt(iter.next());
        }
        
        return answer;
    }
}
