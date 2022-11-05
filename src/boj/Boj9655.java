package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9655 {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    boolean[] arr = new boolean[1002];
    arr[1] = true;
    arr[2] = false;
    arr[3] = true;
    for(int i = 4 ; i <= N ; i++){
      arr[i] = !arr[i-1];
    }
    if(arr[N]){
      System.out.println("SK");
    }else{
      System.out.println("CY");
    }
  }

}
