package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*  숫자의 개수
* link : https://www.acmicpc.net/problem/2577
*/
public class Boj2577 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    int result = a * b * c;
    String str = String.valueOf(result);

    for(int i = 0; i<=9 ; i++){
      String index = String.valueOf(i);
      if(str.contains(index)){
        sb.append(str.length()- str.replace(index,"").length());
      }else{
        sb.append(0);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
