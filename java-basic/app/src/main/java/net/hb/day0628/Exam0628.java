package net.hb.day0628;

import java.util.*;

public class Exam0628 {

  Scanner sc = new Scanner(System.in);
  boolean[] camp = new boolean[5]; 
  int num=0;

  public static void main(String[] args) {
    Exam0628 guest = new Exam0628();
    System.out.println("1차원배열 캠프예매 28일월요일 3:40 ");
    int sel=9;
    guest.map();


    while(true) {
      try {
        System.out.print("\n1.예약  2.퇴실  3.보기  9.종료 : ");
        sel = Integer.parseInt(guest.sc.nextLine());

        if(sel==9) {
          System.out.println("캠프장예약프로그램을 종료합니디");
          break;
        }

        switch(sel) {
          case 1: //입실처리

            guest.input();
            guest.map();
            break;

          case 2: //퇴실은 조별/개인별처리

            guest.output();
            guest.map();
            break;  

          case 3: //전체예약상태
            for(int i=0; i<guest.camp.length; i++) {
              if(guest.camp[i]==true) {
                System.out.println("  "+ (i+1)+"번째 ■캠프사용중입니다 "  );
              }else {
                System.out.println("  "+ (i+1)+"번째 □캠프장은 비어 있습니다 "  ); 
              }
            } //for end
            break;
          default: 
            System.out.println("1~3메뉴를 선택하셔야 합니다");
            break;  
        }//switch end
      }catch (Exception e) {  }
    }//while 

    guest.sc.close();
  }//end
  public void map() {
    //캠핑장 예약상태확인 
    for(int i=0; i<camp.length; i++) {
      if(camp[i]==true) {
        System.out.println("  "+ (i+1)+"번째 ■캠프사용중입니다 "  );
      }else {
        System.out.println("  "+ (i+1)+"번째 □캠프장은 비어 있습니다 "  ); 
      }
    } //for end
  }
  public void input() {
    System.out.print("예약캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //고객이 5입력
    if(num <1 || num >5) { System.out.println(num +"번호를 사용할수 없습니다"); }
    if(camp[num-1]==true) {
      System.out.println("이미 예약된 캠프장 사용할수 없습니다");
    }else {
      System.out.println("camp["+num+"] 캠프장 예약성공");
      camp[num-1]=true; //false대신 진짜true값대입
    }
  }
  public void output() {
    System.out.print("퇴실캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //3입력하면 
    if(camp[num-1]==true) {
      System.out.println("camp["+num+"] 캠프장 퇴실성공했습니다");
      camp[num-1]=false; 
    }else {
      System.out.println("camp["+num+"] 비어있는 캠프장입니다");
    }
  }
}//class END