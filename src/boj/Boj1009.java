package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  분산 처리
 */
public class Boj1009 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int r = 1;
      for (int j = 0; j < b; j++) {
        r = (r * a) % 10;
      }
      if(r==0){
        sb.append(10+"\n");
      }else{
        sb.append(r).append("\n");
      }
    }

    System.out.println(sb);
  }
}
