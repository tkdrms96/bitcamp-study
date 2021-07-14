package net.hb.day0628;

import java.util.*;

public class CampTest2 {

  Scanner sc=new Scanner(System.in); //전역sc개체변수 
  boolean[] camp = new boolean[5]; //전역 camp배열변수
  int num=0;//input(),output(),map() 

  public static void main(String[] args) {
    CampTest2 guest = new CampTest2();
    System.out.println("  함수응용 캠프배열");
    int sel = 9;
    guest.map(); //전체상태

    while(true) {
      try { 
        sel=guest.menu();
        if(sel==9) {
          guest.myExit();
          break;
        }

        switch(sel) {
          case 1:
            guest.input();
            guest.map();
            break;
          case 2: //퇴실은 조별/개인별처리
            guest.output();
            guest.map();
            break;  
          case 3: //전체예약상태
            guest.map();
            break;
          default: 
            System.out.println("1~3메뉴를 선택하셔야 합니다");
            break;  
        }//switch end
      }catch (Exception e) {  }


    }//while 
  }//main end

  public void myExit() {
    System.out.println("\n캠프장예약프로그램을 종료합니디");
    System.exit(1);
  }

  public int menu( ) { // id지역변수값을 menu()메소드가 id값을기억
    System.out.print("1.예약  2.퇴실  3.보기  9.종료>>> "); //안내문
    int id = Integer.parseInt(sc.nextLine());//지역변수 
    return id;
  }//end

  public void input( ) {//non-static메소드
    System.out.print("예약캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //고객이 5입력
    if(num <1  || num >5) { System.out.println(num +"번호를 사용할수 없습니다"); 
    return ;}
    if(camp[num-1]==true) {
      System.out.println("이미 예약된 캠프장 사용할수 없습니다");
    }else {
      System.out.println("camp["+num+"] 캠프장 예약성공");
      camp[num-1]=true; //false대신 진짜true값대입
    }
  }//end

  public void output( ) {//non-static메소드
    System.out.print("퇴실캠핑번호 입력>>> ");
    num=Integer.parseInt(sc.nextLine()); //3입력하면 
    if(camp[num-1]==true) {
      System.out.println("camp["+num+"] 캠프장 퇴실성공했습니다");
      camp[num-1]=false; 
    }else {
      System.out.println("camp["+num+"] 비어있는 캠프장입니다");
    } 
  }//end

  public void map( ) {//non-static메소드
    for(int i=0; i<camp.length; i++) {
      if(camp[i]==true) {
        System.out.println("  "+ (i+1)+"번째 ■캠프사용중입니다 "  );
      }else {
        System.out.println("  "+ (i+1)+"번째 □캠프장은 비어 있습니다 "  ); 
      }
    } //for end 
    System.out.println(); //의미없는 라인개행enter
  }//end

}// class END