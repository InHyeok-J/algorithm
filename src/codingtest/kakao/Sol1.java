package codingtest.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sol1 {


  static HashMap<String, Integer> termsMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    // 모든 달은 28일까지 있음.
//    String today = "2022.05.19";
//    String[] terms = {"A 6", "B 12", "C 3"};
//    String[] privacies = {"2021.05.02 A", "2021.07.01 B","2022.02.19 C", "2022.02.20 C"};
    String today = "2020.01.01";
    String[] terms = {"Z 3", "D 5"};
    String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D",
        "2018.12.28 Z"};
    int[] solution = solution(today, terms, privacies);
    for (int k : solution) {
      System.out.print(k + " ");
    }
  }

  public static int[] solution(String today, String[] terms, String[] privacies) {

    changeTermMap(terms);

    List<Integer> resultList = new ArrayList<>();

    System.out.println(addDate("2019.03.28", 24));

    int[] result = new int[resultList.size()];
    for (int k = 0; k < resultList.size(); k++) {
      result[k] = resultList.get(k);
    }

    return result;
  }

  static boolean isTodayTimeOver(String today, String limitDate) {
    String[] todaySplit = today.split("\\.");
    String[] limitDateSplit = limitDate.split("\\.");
    int tYear = Integer.parseInt(todaySplit[0]);
    int tMonth = Integer.parseInt(todaySplit[1]);
    int tDay = Integer.parseInt(todaySplit[2]);

    int lYear = Integer.parseInt(limitDateSplit[0]);
    int lMonth = Integer.parseInt(limitDateSplit[1]);
    int lDay = Integer.parseInt(limitDateSplit[2]);

    // 보관 가능 날짜 -1 일까지 가능.
    lDay--;
    System.out.println("오늘 날짜 = " + today + " 원본 날짜= " + limitDate);
    if (lDay == 0) {
      lDay = 28;
      lMonth--;
      if (lMonth == 0) {
        lMonth = 12;
        lYear--;
      }
    }
    if (tYear > lYear) {
      return true;
    } else if (tMonth > lMonth && (tYear == lYear)) {
      return true;
    } else if (tDay > lDay && (tMonth == lMonth) && (tYear == lYear)) {
      return true;
    }
    return false;
  }

  static String addDate(String originalDate, int addLimit) {
    String[] split = originalDate.split("\\.");
    int year = Integer.parseInt(split[0]);
    int month = Integer.parseInt(split[1]);
    int day = Integer.parseInt(split[2]);

    int sum = month + addLimit;

    if (sum >= 13 ) {
      // 13 => 12 로 나누고 /해서  1은 year에, + 1(month)는 달에 추가
      // 24 => 2년 추가 달은
      year = year + sum /12;
      if(sum % 12 == 0){
        month = 12;
        year--;
      }else {
        month = sum % 12;
      }
    } else {
      month = sum;
    }
    return String.valueOf(year) + "." + String.valueOf(month) + "." + String.valueOf(day);
  }


  static void changeTermMap(String[] terms) {
    for (int i = 0; i < terms.length; i++) {
      String term = terms[i];
      String[] temp = term.split(" ");
      termsMap.put(temp[0], Integer.parseInt(temp[1]));
    }
  }
}
