package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*  설탕배달
*/

public class Boj2839 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());

    // 5보다 작은 수중에
    int result = 0;
    while (true) {
      if (count == 0) {
        System.out.println(result);
        break;
      }

      if (count < 0) {
        System.out.println("-1");
        break;
      }

      if (count % 5 == 0) {
        // 5로 나눠지면ㄱㄱ
        int temp = count / 5;
        result += temp;
        count -= temp * 5;
      } else {
        count -= 3;
        result++;
      }

    }
  }

}
