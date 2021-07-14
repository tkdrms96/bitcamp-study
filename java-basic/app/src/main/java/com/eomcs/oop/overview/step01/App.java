package com.eomcs.oop.overview.step01;

import java.util.*;
import java.util.Scanner;
//main() : 프로그램의 entry point
public class App {
  static class Board{
    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;
  }
  static final int BOARD_LENGTH = 100;
  static Board[] board = new Board[BOARD_LENGTH];
  static int size = 0;

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("게시판 관리");

    loop: while (true) {
      System.out.print("명령");
      String command = keyScan.nextLine();

      switch (command) {
        case "list": list(); break;
        case "add": add(); break;
        case "update": update(); break;
        case "delete": delete(); break;
        case "view": view(); break;
        case "quit":
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
    }
    keyScan.close();

    System.out.println("안녕히가세요!");
  }
  static void list() {
    System.out.println("게시글 목록");

  }










}



















}
}
