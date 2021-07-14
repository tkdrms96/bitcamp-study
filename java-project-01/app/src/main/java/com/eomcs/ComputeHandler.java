package com.eomcs;

import java.util.*;

public class ComputeHandler implements Handler {
  static Scanner keyScan;
  //규칙에 따라 만든 메서드는 스태틱을 못붙이고 public붙여야함
  public void execute() {
    while(true) {
      System.out.print("계산식: (이전메뉴: back) (예 : 100 * 4) "); 
      String expression = keyScan.nextLine();
      //계산식에 따라 문자를 받음

      if (expression.equals("back")) { //문자열을 입력할때는 ==쓰면안됌 equals
        break;
      }
      String[] arr = expression.split(" "); 
      //문자열을 분리시켜야함 공백을 기준으로 짤라내는것(split)을 arr 배열에 담아 리턴
      //100 * 4 일경우 100, * , 3으로 배열에 담아서 리턴해줌
      if (arr.length != 3) { 
        System.out.println("계산식의 입력이 잘못되었습니다."); 
        // arr의 갯수 3개가 아닐경우에는 이거실행함
        continue; // 다시 이전메뉴로 돌려놓는것
      }
      int a = Integer.parseInt(arr[0]); // arr[0][2]의 값을 인트로 바꿔줘야 연산이가능하니 바꿔줌
      int b = Integer.parseInt(arr[2]);
      switch(arr[1]) { //arr[1]의 값은 연산자가 들어가는값 배열3개를만들때 숫자, 연산자, 숫자 중 연산자
        case "+":
          System.out.printf("%d + %d = %d\n",a,b, a + b); 
          break;
        case "-":
          System.out.printf("%d - %d = %d\n",a,b, a - b);
          break;
        case "*":
          System.out.printf("%d * %d = %d\n",a,b, a * b);
          break;
        case "/":
          System.out.printf("%d / %d = %d\n",a,b, a / b);
          break;
        case "%":
          System.out.printf("%d %% %d = %d\n",a,b, a % b); 
          // %d % %d중 %는명령어를 가르키는거라 %를쓰면 오류 %한개 더적어줌
          break;
        default:
          System.out.println("이 연산은 지원하지 않습니다.");
      }
    }
  }
}