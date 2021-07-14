package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class View {

  public void view (String id) {

    Scanner keyScan = new Scanner(System.in);
    Insert insert = new Insert();
    Update update = new Update();
    Delete delete = new Delete();
    Finish finish = new Finish();
    Share share = new Share();

    System.out.println("\n-------개인일정--------");

    try {
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ResultSet RS;

      System.out.println("번호\t날짜\t\t제목\t\t내용");
      String msg = "select rownum, a.p_date, a.title, a.contents from (select * from seet_"+id+" order by p_date) a";
      RS = ST.executeQuery(msg);
      while (RS.next() == true) {
        int rownum = RS.getInt("rownum");
        java.util.Date p_date = RS.getDate("p_date");
        String title = RS.getString("title");
        String contents = RS.getString("contents");

        System.out.printf("%s\t", rownum);
        System.out.printf("%s\t",p_date);
        System.out.printf("%s\t\t",title);
        System.out.printf("%s\t\n",contents);
      }

      while (true) {
        System.out.println("\n메뉴를 선택하여 주세요.");
        System.out.println("\n1.일정추가\n2.일정수정\n3.일정삭제\n4.일정완료처리\n5.일정공유\n0.뒤로가기\n");
        System.out.print("메뉴 입력 : ");
        String num = keyScan.nextLine();
        if (num.equals("1")) {insert.insert(id);}
        else if (num.equals("2")) {update.update(id);}
        else if (num.equals("3")) {delete.delete(id);}
        else if (num.equals("4")) {finish.finish(id);}
        else if (num.equals("5")) {share.share(id);}
        else if (num.equals("0")) {break;}
        else {System.out.println("\n잘못 입력하셨습니다. 다시 입력하여 주세요.");}
      }
    } catch (Exception e) {}
  }
}