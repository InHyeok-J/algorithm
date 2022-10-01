package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 *  수 정렬하기 3
 *  카운팅 정렬 활용.
 */
public class Boj10989 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] count = new int[10001];
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      int Number = Integer.parseInt(br.readLine());
      arr[i] = Number;
      count[Number] = count[Number] + 1;
    }

    for(int i = 1 ; i< 10001; i++){
      count[i] += count[i-1];
    }

    for(int i = arr.length- 1 ; i>= 0; i--){
      int value  = arr[i];
      count[value]--;
      result[count[value]] = value;
    }

    for (int i : result){
      sb.append(i).append("\n");
    }
    System.out.println(sb);
  }
}
