package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.Rq;
import org.koreait.motivation.entity.Motivation;
import org.koreait.motivation.service.MotivationService;

import java.util.ArrayList;
import java.util.List;

public class MotivationController {

    // 명령을 받은 App클래스에서 넘겨받아 실행하는 부서.

    private MotivationService motivationService;

//    int lastId;
//    List<Motivation> motivations;   // 저장소 (db)의 역할  하지만, 메모리에 저장되는 특성상.. 영속성은 없다.

    public MotivationController() {
//        lastId = 0;
//        motivations = new ArrayList<>();
        motivationService = new MotivationService();
    }

    public void add() {
//        int id = lastId + 1;
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        int id = motivationService.doAdd(body, source);

//        Motivation motivation = new Motivation(id, body, source);
//
//        motivations.add(motivation);

        System.out.printf("%d번 motivation이 등록 되었습니다.\n", id);
//        lastId++;   // 마지막 번호 증가
    }

    public void list() {
//        if (motivations.size() == 0) {
//            System.out.println("등록된 motivation 없음");
//            return;
//        }
//        System.out.println("== motivation list ==");
//        System.out.printf("    id    //   source   //   body   \n");
//        System.out.println("=".repeat(40));
//
//        for (int i = motivations.size() -1; i >= 0; i--) {
//            Motivation motivation = motivations.get(i);
//
//            // 3. 글자수가 너무 많으면..?
//            // 보여줄때만 보여주고, 인스턴스 변수 자체의 데이터가 훼손 되어서는 안됌.
//            if (motivation.getSource().length() > 7) {
//                System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
//                continue;
//            }
//            System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource(), motivation.getBody());
//        }
        motivationService.showList();
    }

    public void delete(Rq rq) {
        System.out.println("delete 실행");
        int id = motivationService.doDelete(rq);
//        try {
//            id = Integer.parseInt(rq.getParams("id"));
//
//        } catch (NumberFormatException e) {
        if (id == -1) {
            System.out.println("정수 입력 오류");
            return;
        }

//        Motivation motivation = findById(id);
//
//        if (motivation == null) {
        else if (id == -2) {
            System.out.println("해당 motivation은 없습니다.");
            return;
        }
//        System.out.printf("%d번 motivation은 없어\n", id);
//        }
//        motivations.remove(motivation);
        System.out.printf("%d번 motivation을 삭제했습니다.\n", id);
    }

    public void edit(Rq rq) {
        int id = motivationService.doEdit(rq);
//
        if (id == -1) {
            System.out.println("정수 입력 오류");
            return;
        }

        Motivation motivation = findById(id);

        if (motivation == null) {
            System.out.printf("%d번 motivation은 없어\n", id);
            return;
        }

        // 불러온 motivation의 인스턴스변수에 접근.
        System.out.println("body(기존) : " + motivation.getBody());
        System.out.println("source(기존) : " + motivation.getSource());

        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();

        // 불러온 motivation의 인스턴스변수 수정.
        motivation.setBody(body);
        motivation.setSource(source);

        System.out.printf("%d번 motivation을 수정했습니다.\n", id);
    }


    // 입력된 id와 일치하는 motivation 찾기(검색) delete와 edit에서 id를 검색하기위한 "도구"역할.
    private Motivation findById(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }
}
