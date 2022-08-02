import java.util.*;

class Solution {
    
    class Stage{
        public int stage;
        public int clear = 0;
        public int challenger = 0;
        public double failRate = 0.0;
        
        public Stage(int stage){
            this.stage = stage;
        }
        
        public void setFailRate(){
            failRate = (double)(challenger - clear) / challenger;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] arr = new Stage[N];
        for(int i =0; i< N; i++) arr[i] = new Stage(i +1);
        
        for(int stage : stages){
            for(int i =0; i<stage -1;i++)arr[i].clear+=1;
            for(int i =0; i<(stage > N? N: stage);i++)arr[i].challenger+=1;
        }
        
        for(int i =0; i< N; i++) arr[i].setFailRate();
        
        Arrays.sort(arr, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o2.failRate > o1.failRate) return 1;
                else if (o2.failRate < o1.failRate) return -1;
                return 0;
            }
        });
        
        for(int i =0; i< arr.length; i++){
            answer[i] = arr[i].stage;
        }
        
        return answer;
    }
}
