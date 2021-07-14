package com.eomcs.lang.ex06;

import java.util.*;

// # 흐름 제어문 - for 반복문과 컬렉션
//
public class Exam0461 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("one");
    list.add("two");
    list.add("three");

    for(int i=0; i<list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}


