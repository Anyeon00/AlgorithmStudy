package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//설탕 배달
public class Backjoon2839Try2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int dividedBy5;

        if (n >= 5) {    // 일반적인 경우, N >= 5 인 경우

            while (true) {
                int restBy5 = n % 5;
                if (restBy5 == 0) {  // Case 1 : 5로 나눈 나머지가 0
                    result = n / 5;
                }else {
                    if (restBy5 % 3 == 0) { // Case 2 : 5로 나눈 나머지를 3으로 나눴을 때 0
                        result = n / 5 + restBy5/3;
                    } else {    // Case 3 : 5로 나눈 나머지를 3으로 나눴는데 나머지가 존재

                    }
                }
            }

        } else {    // 예외, N < 5인 경우
            if (n == 3) {
                result = 1;
            } else {
                result = -1;
            }
        }

        System.out.println(result);
    }
}
