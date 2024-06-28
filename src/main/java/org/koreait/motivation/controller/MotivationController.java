package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationController {

    int lastId;
    List<Motivation> motivations;   // 저장소 (db)의 역할


    public MotivationController() {
        lastId = 0;
        motivations = new ArrayList<>();
    }

    public void add() {
        int id = lastId + 1;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        Motivation motivation = new Motivation(id, body, source);

        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록 되었습니다.\n", id);
        lastId++;   // 마지막 번호 증가
    }

    public void list() {

        if (motivations.size() == 0) {
            System.out.println("등록된 motivation 없음");
            return;
        }
        System.out.println("== motivation list ==");
        System.out.printf("    id    //   source   //   body   \n");
        System.out.println("=".repeat(40));

        for (int i = motivations.size() -1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            // 3. 글자수가 너무 많으면..?
            // 보여줄때만 보여주고, 인스턴스 변수 자체의 데이터가 훼손 되어서는 안됌.
            if (motivation.getSource().length() > 7) {
                System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                continue;
            }
            System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }
    }

    public void del() {
        System.out.print("id =");
        int delId = Container.getScanner().nextInt();
        motivations.remove(delId-1);
        System.out.println(delId + "번 motivation이 삭제되었습니다.");


    }
}
