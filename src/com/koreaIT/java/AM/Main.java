package com.koreaIT.java.AM;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("==프로그램 시작==");
    Scanner sc = new Scanner(System.in);
    int lastArticleId = 0;

    while (true) {
      System.out.println("명령어 )");
      String cmd = sc.nextLine();
      if (cmd.length() == 0) {
        System.out.println("명령어를 입력하세요.");
        continue;
      }
      if (cmd.equals("system exit")) {
        break;
      }
      if (cmd.equals("article write")) {
        int id = lastArticleId + 1;
        System.out.println("제목 : ");
        String title = sc.nextLine();
        System.out.println("내용 : ");
        String body = sc.nextLine();
        System.out.printf("%s, %s\n", title, body);
        System.out.printf("%d 글이 생성되었습니다.", id);
        System.out.println(id);
        lastArticleId = id;
      } else if (cmd.equals("article list")) {
        System.out.println("게시글이 없습니다.");
      } else {
        System.out.println("존재하지 않는 명령어 입니다.");
      }
    }

    sc.close();
    System.out.println("==프로그램 종료==");

  }
}