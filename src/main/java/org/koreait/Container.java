package org.koreait;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    // 공유 자원을 모아두는 공간 초기화
   public static void init() {
       // static 전역 생성자 - 자바기초 46영상
        sc = new Scanner(System.in);
    }
    // 공유 자원을 모아두는 공간 자원 해제
    public static void close() {
       sc.close();
    }

    public static Scanner getScanner() {
        return sc;
    }


}
