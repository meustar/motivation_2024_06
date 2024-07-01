package org.koreait.motivation.service;

import org.koreait.Rq;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationService {

    private int lastId;
    private List<Motivation> motivations;   // 저장소 (db)의 역할  하지만, 메모리에 저장되는 특성상.. 영속성은 없다.


    public MotivationService() {
        lastId = 0;
        motivations = new ArrayList<>();
    }

    public int doAdd(String body, String source) {
        int id = lastId + 1;

        Motivation motivation = new Motivation(id, body, source);
        motivations.add(motivation);

        lastId = id; // 방금 만들어진 새 motivation의 id로 갱신

        return id;
    }

    public void showList() {
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

    public int doDelete(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParams("id"));
        } catch (NumberFormatException e) {
            return -1;
        }

        Motivation motivation = findById(id);

        if (motivation == null) {
            return -2;
        }

        motivations.remove(motivation);

        return id;
    }

    public int doEdit(Rq rq) {
    }
}
