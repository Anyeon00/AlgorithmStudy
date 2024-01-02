package week1;

// 프로그래머스 나머지가 1이 되는 수 찾기
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