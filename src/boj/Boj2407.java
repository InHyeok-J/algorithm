package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj2407 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    BigInteger up = BigInteger.valueOf(N);

    for (int i = N - 1; i > (N - M); i--) {
      up = up.multiply(BigInteger.valueOf(i));
    }
    BigInteger down = BigInteger.valueOf(M);
    for(int i = M-1 ; i > 0 ; i--){
      down = down.multiply(BigInteger.valueOf(i));
    }
    System.out.println(up.divide(down));
  }

}
