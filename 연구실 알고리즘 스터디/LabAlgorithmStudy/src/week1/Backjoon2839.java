package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 문제
public class Backjoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result;

        result = caculate(n);
        System.out.println(result);

    }

    private static int caculate(int n) {
        int result;
        int fiveN;
        if (n >= 5) {
            if (n % 5 == 0) {   // Case 1 : 5보다 큰데 5로 나눠 떨어지는 경우
                result = n / 5;
            }else {
                fiveN = n / 5;
                for (int i = fiveN; i >= 0; i--) {
                    int tmpResult = 0;
                    int five = i * 5;
                    int threeN = 0;
                    while (tmpResult < n) {
                        tmpResult = five + threeN * 3;
                        if (tmpResult == n) {
                            return i + threeN;
                        } else {
                            threeN++;
                        }
                    }
                }
                result = -1;
                return result;
            }
        }else{
            if (n == 3) {
                result = 1;
            } else {
                result = -1;
            }
        }
        return result;
    }
}
