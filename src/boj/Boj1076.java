package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1076 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] values = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    String A = br.readLine();
    String B = br.readLine();
    String C = br.readLine();
    String resistValue = getValue(A) + getValue(B);
    long result = (long) (values[Integer.parseInt(getValue(C))] * Integer.parseInt(resistValue));
    System.out.println(result);
  }

  public static String getValue(String str) {
    String value = "";
    switch (str) {
      case "black":
        value = "0";
        break;
      case "brown":
        value = "1";
        break;
      case "red":
        value = "2";
        break;
      case "orange":
        value = "3";
        break;
      case "yellow":
        value = "4";
        break;
      case "green":
        value = "5";
        break;
      case "blue":
        value = "6";
        break;
      case "violet":
        value = "7";
        break;
      case "grey":
        value = "8";
        break;
      case "white":
        value = "9";
        break;
    }

    return value;
  }


}
