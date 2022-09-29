package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 *  회의실 배정
 * 그리디
 */
public class Boj1931 {

  public static class Room implements Comparable<Room> {

    int start;
    int end;

    public Room(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Room o) {
      if (end == o.end) {
        return start - o.start;
      } else {
        return end - o.end;
      }
    }

    @Override
    public String toString() {
      return "[ start:" + start + " end: " + end + "]";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    List<Room> rooms = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      rooms.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    Collections.sort(rooms);
    int result = 1;
    Room currentRoom = rooms.get(0);

    for (int i = 1; i < N; i++) {
      Room room = rooms.get(i);

      if (room.start >= currentRoom.end) {
        currentRoom = room;
        result++;
      }

    }
    System.out.println(result);

  }
}
