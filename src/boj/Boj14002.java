package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14002 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    List<Integer>[] result = new List[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      result[i] = new ArrayList<>(Arrays.asList(arr[i]));
    }

    for (int i = 1; i < N; i++) {
      int maxSize = 0;
      int maxIndex = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          if(result[j].size() > maxSize){
            maxSize = result[j].size();
            maxIndex = j;
          }
        }
      }
      if(maxIndex != 0) {
        result[i].addAll(result[maxIndex]);
      }
      if(maxIndex == 0){
        if(arr[i] > arr[maxIndex]){
          result[i].addAll(result[maxIndex]);
        }
      }
    }
    int max = 0;
    int maxIndex = 0;
    for(int i = 0 ; i < N; i++){
      System.out.println(result[i]);
      if(result[i].size() > max){
        maxIndex = i;
        max = result[i].size();
      }
    }
    sb.append(result[maxIndex].size()).append("\n");
    Collections.sort(result[maxIndex]);
    for(int num : result[maxIndex]){
      sb.append(num+" ");
    }
    System.out.println(sb);
  }
}
