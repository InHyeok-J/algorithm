package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
*  커트라인
*/
public class Boj25305 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    List<Integer> arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N;i++){
      arr.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(arr, Collections.reverseOrder());

    System.out.println(arr.get(K-1));
  }
}
