package dbtest;

import java.util.Scanner;

public class LoginFinish {

  Scanner keyScan = new Scanner(System.in);
  Login login = new Login();
  View view = new View();
  View_F view_f = new View_F();
  View_S view_s = new View_S();
  Edit edit = new Edit();
  Leave leave = new Leave();
  Manager manager = new Manager();

  public void loginfinish() {
    loop : while (true) {
      login.login();
      String id = login.id;
      if (id.equals("0")) { break; }
      if (id.equals("admin")) { manager.manager(); break;}

      while (true) {
        System.out.println("\n---------메뉴----------");
        System.out.println("\n메뉴를 선택하여 주세요.");
        System.out.println("\n1.개인일정\n2.완료일정\n3.공유일정\n4.회원정보수정\n5.회원탈퇴\n0.로그아웃\n");
        System.out.print("메뉴 입력 : ");
        String num = keyScan.nextLine();
        if (num.equals("1")) {view.view(id);}
        else if(num.equals("2")) {view_f.view_f(id);}
        else if(num.equals("3")) {view_s.view_s(id);}
        else if(num.equals("4")) {edit.edit(id);}
        else if(num.equals("5")) {leave.leave(id); break loop;}
        else if(num.equals("0")) {break loop;}
        else {System.out.println("\n잘못 입력하셨습니다. 다시 입력하여 주세요.");}
      }
    }
  }
}