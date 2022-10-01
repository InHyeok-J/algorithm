package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
*  부호
*/

public class Boj1247 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    BigInteger integer = new BigInteger("0");
    for (int i = 0; i < 3; i++) {
      int N = Integer.parseInt(br.readLine());
      BigInteger result = new BigInteger(br.readLine());

      for (int j = 0; j < N - 1; j++) {
        BigInteger bigInteger = new BigInteger(br.readLine());
        result = result.add(bigInteger);
      }

      if(result.compareTo(integer) == 0){
        sb.append("0"+"\n");
      }else if (result.compareTo(integer) == -1){
        sb.append("-"+"\n");
      }else{
        sb.append("+"+"\n");
      }
    }
    System.out.println(sb);
  }
}
