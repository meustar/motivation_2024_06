package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.system.controller.SystemController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public App() {

    }
    public void run() {
        System.out.println("== motivation execution ==");


        SystemController systemController = new SystemController();
        MotivationController motivationControlle = new MotivationController();


        while (true) {
            System.out.print("command) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {   // String 끼리의 비교는 서로 주소값을 비교하기 때문에 무한루프에 빠짐.
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명력어를 입력해주세요. :)");
                continue;
            }

            if (cmd.equals("add")) {
                motivationControlle.add();
            } else if (cmd.equals("list")) {
                motivationControlle.list();
            } else if (cmd.equals("del")) {
                motivationControlle.delete();
            } else if (cmd.startsWith("delete")) {
                // parsing
                String[] cmdBits = cmd.split("\\?", 2);

                String actionMethod = cmdBits[0]; // delete
                Map<String, String> params = new HashMap<>();
                String[] paramBits = cmdBits[1].split("&");

                for (String paramStr : paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];
                    System.out.println("paramStr: " + paramStr + " key: " + key + " value: " + value);
                    params.put(key, value);
                }

                System.out.println("Arrays.toString(cmdBits) : " + Arrays.toString(cmdBits));
                System.out.println("actionMethod: " + actionMethod);
                System.out.println("params: " + params);
                System.out.println("paramBits: " + Arrays.toString(paramBits));

//                motivationController.delete();
            } else {
                System.out.println("사용할 수 없는 명령어입니다");
            }
        }
    }
}

