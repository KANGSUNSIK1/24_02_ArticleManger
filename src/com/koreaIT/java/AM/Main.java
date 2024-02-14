package com.koreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("==프로그램 시작==");
    Scanner sc = new Scanner(System.in);
    int lastArticleId = 0;

    List<Article> articles = new ArrayList<>();

    while (true) {
      System.out.println("명령어 )");
      String cmd = sc.nextLine().trim();
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

        Article article = new Article(id, title, body);
        articles.add(article);

        //System.out.printf("%s, %s\n", title, body);
        System.out.printf("%d 글이 생성되었습니다.", id);
        System.out.println(id);
        lastArticleId = id;
      } else if (cmd.equals("article list")) {
        if (articles.size() == 0) {
          System.out.println("게시글이 없습니다.");
          //continue;
        } else {
          System.out.println(" 번호 | 제목 ");
          for (int i = articles.size() - 1; i >= 0; i--) {
            Article article = articles.get(i);
            System.out.printf("  %d   |   %s  \n", article.id, article.title);
          }
        }
      } else if (cmd.startsWith("article detail 1")) {
        String[] cmdBits = cmd.split("");

        int id = Integer.parseInt(cmdBits[2]);
        //boolean found = false; // 발견 여부를 저장하는 변수 found (가정)
        Article foundArticle = null; // 찾은 게시글을 연결하는 변수 foundArticle (가정)

        for (int i = 0; i < articles.size(); i++) { // 게시글의 존재 여부를 확인하는 과정
          Article article = articles.get(i); // 일일이 비교하기 위해 가져옴
          if (article.id == id) { // articles에서 가져온 article 객체의 글번호와 id 비교
            //found = true;
            foundArticle = article;
            break;
          }
        }
        //if (found == false)
        if (foundArticle == null) {
          System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
          //continue;
        } else {
          System.out.printf("번호 : %d\n", foundArticle.id);
          System.out.printf("날짜 : %d\n", "2024-02-14");
          System.out.printf("제목 : %d\n", foundArticle.title);
          System.out.printf("내용 : %d\n", foundArticle.body);
        }
      } else {
        System.out.println("존재하지 않는 명령어 입니다.");
      }
    }

    sc.close();
    System.out.println("==프로그램 종료==");

  }
}

class Article {
  int id;
  String title;
  String body;
  public Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;

  }
}