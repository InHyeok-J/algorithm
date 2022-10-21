package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int result = 0;
    for (int i = 0; i < N; i++) {
      int current = arr[i];
      long sum = 0L;
      sum += current;
      if (sum == M) {
        result++;
        continue;
      }

      if (i == N - 1 && sum != M) {
        break;
      }
      for (int j = i + 1; j < N; j++) {
        int addNum = arr[j];
        sum += addNum;
        if (sum == M) {
          result++;
        } else if (sum > M) {
          break;
        }
      }
    }
    System.out.println(result);
  }

}
