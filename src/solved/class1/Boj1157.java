package solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  BOJ 단어 공부
 */

public class Boj1157 {

  public static class CharAndCount {

    char type;
    int count;

    public CharAndCount(char type, int count) {
      this.type = type;
      this.count = count;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toUpperCase();

    ArrayList<CharAndCount> strCounts = new ArrayList<>();

    while (str.length() > 0) {
      char charType = str.charAt(0);
      int count = str.length() - str.replace(String.valueOf(charType), "").length();

      strCounts.add(new CharAndCount(charType, count));
      //remove
      str = str.replace(String.valueOf(charType), "");
    }
    //sort
    List<CharAndCount> charAndCounts = strCounts.stream().sorted((a, b) -> b.count - a.count)
        .collect(
            Collectors.toList());
    if (charAndCounts.size() >= 2 && (charAndCounts.get(0).count == charAndCounts.get(1).count)) {
      System.out.println("?");
    } else {
      System.out.println(charAndCounts.get(0).type);
    }
  }

}
