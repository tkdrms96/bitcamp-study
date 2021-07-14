package dbtest;

import java.sql.*;
import java.util.*;
import java.util.Date;

//완료일정을 누르면 노출시켜주고 삭제기능을 누르면 번호를 받아 특정데이터를 삭제할수있음
public class View_S {
  Scanner sc = new Scanner(System.in);
  ResultSet rs = null;
  int i = 0;

  /* 이테이블은 로그인을 하게되면  // 최종메뉴 System.out.println("1.개인일정 2.완료일정 3.공유일정 4.회원정보관리 0.로그아웃");
  여기서 완료일정을 누르면 보여지는 것임 

  들어오면 먼저 리스트를 보여주고 삭제할수있고 뒤로가기할수있고 ( 삭제하기, 뒤로가기(0) )*/

  public void view_s(String id){
    System.out.println(id +"님 안녕하세요 공유 일정 목록을 출력합니다");
    s_view(id);//f_view 값을 불러옴 login id 값을줌
    while(true) {
      System.out.println("공유 일정 테이블 입니다. 1.공유일정삭제 0. 뒤로가기 ");
      i = sc.nextInt();
      if (i == 1 || i == 0){} 
      else {
        System.out.println("올바르지 않은 번호입니다."); 
        System.out.println("공유 일정 테이블 입니다. 1.공유일정삭제 0. 뒤로가기 ");
        i = sc.nextInt();
      }
      switch(i) {
        case 1 : s_delete(id); continue;
        case 0 : return;
      }

    }

  }


  public void s_delete(String id){

    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      while(true) {
        System.out.println("삭제하실 일정 번호를 적어주세요 0:뒤로가기");
        i = sc.nextInt();
        if(i == 0) {
          break;
        }
        String msg = "select s_id from s_seet_"+id+"" ;
        rs = ST.executeQuery(msg);
        if (rs.next() == false) {
        }else {System.out.println("올바른 삭제코드를 입력해주세요");}
        msg = "delete from s_seet_"+id+" where s_id ="+i+"";
        ST.executeUpdate(msg);
        s_view(id);
      }
    }catch(Exception e) {System.out.println(e);}
  }

  public void s_view(String id) {
    System.out.println("공유 일정 목록을 출력합니다.");
    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      String msg ="select * from s_seet_"+id+" ";
      rs = ST.executeQuery(msg);
      while(rs.next() == true) {
        Date a = rs.getDate("s_date");//날짜
        String b = rs.getString("title");//제목
        String c = rs.getString("contents");//내용
        String d = rs.getString("s_id");//삭제코드
        System.out.print("날짜  :   ");
        System.out.printf(String.format("%5s",a));
        System.out.print("   일정 title  :");
        System.out.printf(String.format("%5s",b));
        System.out.print("   일정 contents  :");
        System.out.printf(String.format("%5s",c));
        System.out.print("   삭제 코드  :");
        System.out.printf(String.format("%5s",d));
        System.out.println();
      } 

    }catch(Exception e) {System.out.println("공유일정이 없습니다.");}
  }
}