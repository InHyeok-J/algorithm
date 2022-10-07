package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj20300 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    List<Long> arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr.add(i, Long.parseLong(st.nextToken()));
    }

    Collections.sort(arr, Collections.reverseOrder());

    if (N % 2 == 1) {
      Long maxValue = arr.get(0);
      Long isMAX = Long.MIN_VALUE;
      for (int i = 1; i < arr.size() / 2 + 1; i++) {
        Long max = arr.get(i);
        Long min = arr.get(arr.size() - i);
        Long sum = max + min;
        if (isMAX < sum) {
          isMAX = sum;
        }
      }
      if (maxValue > isMAX) {
        System.out.println(maxValue);
      } else {
        System.out.println(isMAX);
      }
    } else {
      Long maxValue = 0L;
      for (int i = 0; i < arr.size() / 2; i++) {
        Long max = arr.get(i);
        Long min = arr.get(arr.size() - i - 1);
        Long sum = max + min;
        if (sum >= maxValue) {
          maxValue = sum;
        }
      }
      System.out.println(maxValue);
    }
  }
}
