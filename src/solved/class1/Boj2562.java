package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*  최대값
*  link : https://www.acmicpc.net/problem/2562
*/
public class Boj2562 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0 ;
    int maxIndex = 0;
    for(int i = 1 ; i <=9; i++){
      int naturalN = Integer.parseInt(br.readLine());
      if(max < naturalN){
        max = naturalN;
        maxIndex= i;
      }
    }
    System.out.println(max);
    System.out.println(maxIndex);
  }
}
