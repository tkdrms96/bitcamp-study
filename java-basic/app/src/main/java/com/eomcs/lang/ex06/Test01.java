package com.eomcs.lang.ex06;

public class Test01 {


  static int countEvenNumbers(int value) {
    int count = 0;
    int n = value;
    while (n !=0) {
      System.out.println(n%10);
      n = n/10;
    }

    return count;
  }

  public static void main(String[] args) {


    int result = countEvenNumbers(45670434);
    System.out.println(result);
  }
}    
