package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1193 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int crossCount = 1;
    int pre_count_sum = 0;
    while (true) {
      if (N <= crossCount + pre_count_sum) {
        if (crossCount % 2 == 1) {
          // 위에서 아래로
          // 분자는 현재 대각선의 수 -  입력값 - 이전까지 합( = N번재 순서) -1
          System.out.println((crossCount - (N - pre_count_sum - 1)) + "/" + (N - pre_count_sum));
          break;
        } else {
          // 아래에서 위로
          System.out.println(N - pre_count_sum + "/" + (crossCount - (N - pre_count_sum - 1)));
          break;
        }
      } else {
        pre_count_sum += crossCount;
        crossCount++;
      }
    }
  }
}
