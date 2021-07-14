package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Finish {

  Scanner keyScan = new Scanner(System.in);

  ResultSet RS;
  String msg;
  String number;
  String title;
  String contents;
  String p_date;
  boolean check;

  public void finish(String id) {
    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();


      // 일정 노출
      System.out.println("\n--------------------일정완료처리--------------------");

      // 회원정보 출력
      System.out.println("번호\t날짜\t\t제목\t코드");
      msg = "select rownum, a.p_date, a.title, a.p_id from (select * from seet_"+id+" order by p_date) a";
      RS = ST.executeQuery(msg);
      while (RS.next() == true) {
        int rownum = RS.getInt("rownum");
        java.util.Date p_date = RS.getDate("p_date");
        String title = RS.getString("title");
        String p_id = RS.getString("p_id");

        System.out.printf("%s\t", rownum);
        System.out.printf("%s\t",p_date);
        System.out.printf("%s\t\t",title);
        System.out.printf("%s\n",p_id);
      }

      // 일정 존재 여부
      msg = "select * from seet_"+id;
      RS = ST.executeQuery(msg);
      if (RS.next() == false) {
        System.out.println("\n게시글이 존재하지 않습니다.");
      } else {

        // 일정 번호 입력
        while (true) {
          System.out.println("\n일정완료 처리하실 코드를 입력하여 주세요. (0:뒤로가기)");
          System.out.print("코드 입력 : ");
          number = keyScan.nextLine();
          if (number.isEmpty()) {
            System.out.println("\n코드를 입력하여 주세요."); continue;
          }
          check = Pattern.matches("^[0-9]*$", number);
          if (check != true) {
            System.out.println("\n잘못 입력하셨습니다. 숫자만 입력하여 주세요.");
            continue;}
          msg = "select rownum, p_date, title, contents from seet_"+id+" where p_id ="+number;
          RS = ST.executeQuery(msg);
          if (number.equals("0")) { break; }
          if (RS.next() == false) {
            System.out.println("\n코드를 잘못 입력하셨습니다. 다시 입력하여 주세요."); continue; 
          }

          java.util.Date p_date = RS.getDate("p_date");
          String title = RS.getString("title");
          String contents = RS.getString("contents");
          msg = "insert into f_seet_"+id+" values ('"+p_date+"', '"+title+"', '"+contents+"', seq_f_seet_"+id+".nextval)";
          ST.executeUpdate(msg);
          msg = "delete from seet_"+id+" where p_id = "+ number;
          ST.executeUpdate(msg);
          System.out.println("\n일정완료 처리되었습니다.");

        } // 일정 완료처리 반복문 end


      }
    }catch (Exception e) {System.out.println(e);} // try-catch end
  } // delete method end
} // Finish class end
