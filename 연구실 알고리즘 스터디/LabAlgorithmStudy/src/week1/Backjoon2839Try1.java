package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달
public class Backjoon2839Try1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        int tmp = 0;

        if (n % 5 == 0) {
            System.out.println("case1");
            result = n / 5;
        } else if (n % 5 != 0) {
            result = n / 5;
            tmp = n % 5;
            if (tmp % 3 == 0) {
                System.out.println("case2");
                result += tmp / 3;
            } else if (tmp % 3 != 0) {
                System.out.println("case3");
                result = -1;
            }
        }

        System.out.println(result);
    }
}
