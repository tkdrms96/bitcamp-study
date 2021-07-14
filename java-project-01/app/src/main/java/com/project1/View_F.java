package dbtest;

import java.sql.*;
import java.util.*;
import java.util.Date;

//완료일정을 누르면 노출시켜주고 삭제기능을 누르면 번호를 받아 특정데이터를 삭제할수있음
public class View_F {
  Scanner sc = new Scanner(System.in);
  ResultSet rs = null;
  int i = 0;

  /* 이테이블은 로그인을 하게되면  // 최종메뉴 System.out.println("1.개인일정 2.완료일정 3.공유일정 4.회원정보관리 0.로그아웃");
  여기서 완료일정을 누르면 보여지는 것임 

  들어오면 먼저 리스트를 보여주고 삭제할수있고 뒤로가기할수있고 ( 삭제하기, 뒤로가기(0) )*/

  public void view_f(String id){
    System.out.println(id +"님 안녕하세요 일정 완료 목록을 출력합니다");
    f_view(id);//f_view 값을 불러옴 login id 값을줌
    loop:while(true) {
      System.out.println("완료 일정 테이블 입니다. 1.완료일정삭제 0. 뒤로가기 ");
      i = sc.nextInt();
      if (i == 1 || i == 0){} else {System.out.println("올바르지 않은 번호입니다."); return;}
      switch(i) {
        case 1 : f_delete(id); continue;
        case 0 : break loop;
      }

    }

  }


  public void f_delete(String id){

    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      System.out.println("삭제하실 테이블 번호를 적어주세요 ");
      i = sc.nextInt();
      String msg = "delete from f_seet_"+id+" where f_id = "+i+"";
      System.out.println(msg);
      i = ST.executeUpdate(msg);
      if(i > 0 || i < 3) {
        System.out.println(i + "테이블 삭제 성공");
      }else{System.out.println("올바른 테이블 번호를 입력해주세요");}
    }catch(Exception e) {System.out.println(e);}
  }

  public void f_view(String id) {
    System.out.println("회원 목록을 출력합니다.");
    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      String msg ="select * from f_seet_"+id+" ";
      rs = ST.executeQuery(msg);
      while(rs.next() == true) {
        Date a = rs.getDate("f_date");//날짜
        String b = rs.getString("title");//제목
        String c = rs.getString("contents");//내용
        String d = rs.getString("f_id");
        System.out.printf(String.format("%-10s",a));
        System.out.printf(String.format("%15s",b));
        System.out.printf(String.format("%20s",c));
        System.out.printf(String.format("%25s",d));
        System.out.println();
      } 

    }catch(Exception e) {System.out.println(e);}
  }
}
