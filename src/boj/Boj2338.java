package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 *  긴자리 계산
 *   https://www.acmicpc.net/problem/2338
 */
public class Boj2338 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strA = br.readLine();
    String strB = br.readLine();

    BigInteger bigA = new BigInteger(strA);
    BigInteger bigB = new BigInteger(strB);
    System.out.println(bigA.add(bigB));
    System.out.println(bigA.subtract(bigB));
    System.out.println(bigA.multiply(bigB));
  }
}
