package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj2655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<Stone> arr = new ArrayList<>();
    List<List<Stone>> result = new ArrayList<>();
    int[] sumDp = new int[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int B = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      arr.add(i, new Stone(B, H, W, i + 1));
    }
    Collections.sort(arr);

    sumDp[0] = arr.get(0).height;
    result.add(0, new ArrayList<>(Arrays.asList(arr.get(0))));

    int resultIndex = 0;
    int resultMaxCompare = arr.get(0).height;
    for (int i = 1; i < N; i++) {
      result.add(i, new ArrayList<>(Arrays.asList(arr.get(i))));
      sumDp[i] = arr.get(i).height;

      int maxSum = 0;
      int maxSumIndex = 0;
      for (int j = 0; j < i; j++) {
        if (arr.get(i).weight < arr.get(j).weight) {
          // i의 무게가 j보다 낮아야 j 위에 쌓을 수 있다.
          if (maxSum < sumDp[j]) {
            maxSum = sumDp[j];
            maxSumIndex = j;
          }
        }
      }
      if (maxSum == 0) {
        Stone cur = arr.get(i);
        if (cur.weight < arr.get(0).weight) {
          sumDp[i] += arr.get(0).height;
          result.get(i).addAll(result.get(0));
        }
      } else {
        sumDp[i] += maxSum;
        result.get(i).addAll(result.get(maxSumIndex));
      }
      if (sumDp[i] > resultMaxCompare) {
        resultMaxCompare = sumDp[i];
        resultIndex = i;
      }
//      System.out.println(resultMaxCompare + " === "+ resultIndex);
    }

//    for (int i = 0; i < N; i++) {
//      List<Stone> stones = result.get(i);
//      System.out.println(sumDp[i]);
//      System.out.println(stones);
//    }
//    System.out.println("-----");

    StringBuilder sb = new StringBuilder();
    List<Stone> stones = result.get(resultIndex);
    sb.append(stones.size()).append("\n");

//    List<Stone> sorted = stones.stream().sorted((a, b) -> a.bottom - b.bottom)
//        .collect(Collectors.toList());
    for (Stone s : stones) {
      sb.append(s.number).append("\n");
    }
    System.out.println(sb);
  }

  public static class Stone implements Comparable<Stone> {

    int bottom;
    int height;
    int weight;
    Integer number;

    public Stone(int bottom, int height, int weight, int number) {
      this.bottom = bottom;
      this.height = height;
      this.weight = weight;
      this.number = number;
    }

    @Override
    public int compareTo(Stone o) {
      return o.bottom - bottom;
    }

    @Override
    public String toString() {
      return "Stone{" +
          "bottom=" + bottom +
          ", height=" + height +
          ", weight=" + weight +
          ", number=" + number +
          '}';
    }
  }
}
