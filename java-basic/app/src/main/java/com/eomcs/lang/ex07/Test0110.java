package com.eomcs.lang.ex07;

//# 메서드 : 사용 전
//
public class Test0110 {

  static void printSpaces(int len) {
    java.util.Date today = new java.util.Date();

    System.out.printf("%1$tY, %1$ty\n", today);
    System.out.printf("%1$tB, %1$tb", today);
    System.out.printf("%1$tm\n", today);
    System.out.printf("%1$A",today);
  }
}

