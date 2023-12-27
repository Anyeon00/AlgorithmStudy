package week1;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = 0;
        for(;;){
            x++;
            if(n % x == 1){
                answer = x;
                break;
            }
        }
        return answer;
    }
}