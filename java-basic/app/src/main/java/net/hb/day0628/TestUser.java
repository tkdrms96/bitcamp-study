package net.hb.day0628;

public class TestUser {

  public static void main(String[] args) {

    Test LG = new Test();

    int[] ret = LG.input();
    Test.output(ret);

    int value = LG.inputHap();
    System.out.println("숫자합계=" + value);
    System.out.println("숫자합계=" + LG.inputHap());
  }
}
