package net;

public class tryCatchStudy {

  public static void main(String[] args) {
    int intArray[] = new int[5];

    try 
    {
      intArray[3] = 10;
      System.out.println(intArray[3]);
      intArray[6] = 1;
    }
    catch (Exception e) 
    {
      e.printStackTrace(); //컴퓨터에서발생한에러문을출력 어디가틀렸는지 에러원인과 위치를알려줌
      System.out.println("배열 범위 초과");
      System.exit(0); // 강제로 프로그램을 종료하는것
    }

    System.out.println("프로그램이 끝났어요");

  }
}
