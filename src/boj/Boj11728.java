package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj11728 {

  public static void main(String [] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    ArrayList<Integer> Aarr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < N; i++){
      Aarr.add(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < M; i++){
      Aarr.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(Aarr);
    for(int i : Aarr){
      sb.append(i+" ");
    }
    System.out.println(sb);
  }
}
