## 24_06_28 17일차
#### 1.
- 번호 구현.
- 목록 구현.
- 목록창 콘솔출력.


#### 2.
- 입력받은 정보를 불러오려면 "저장"을 해야하는데..
- 관련 영상 "자바기초 57강 인력관리소" 참고
- motivation 앱만들기 "4강 링크" 참고 - 컬렉션 프레임워크
> motivation class 생성.
> 
> add해서 list에 저장
 

#### 3.
- source의 글자수가 너무 많아서 밀리면 어떻게하지?
```java
for (int i = motivations.size() -1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);

                    // 3. 글자수가 너무 많으면..?
                    // 보여줄때만 보여주고, 인스턴스 변수 자체의 데이터가 훼손 되어서는 안됌.
                    if (motivation.getSource().length() > 7) {
                        System.out.printf("    %d    //   %s   //   %s   \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                        continue;
                    }
```

- 유지보수 및 협업을 위한 모듈 분리, 패키지 이동(리팩토링)

#### 4.
구조적 프로그래밍.

- 구현
- 리팩토링 (코드정리)

#### 5.
Main 메소드에 Scanner가 필요가 있나?
실질적으로 사용하는 곳은 App과 M.C인데..
결국 전역에서 사용하기 때문에
따로 별도의 공간에 만들어놓고 사용한다면?

- 전역에서 가져다 쓸수있는 공간을 따로 Container 클래스를 만든다.

- static 전역 생성자 - 자바기초 46강 영상 참고
--- 

## 24_07_01 18일차
#### 1.
- d

#### 2.
- 요청받은 명령어를 어느곳으로 가야할지 길안내를 해주는 "라우터" 역할을 하는 switch문
  - Rq 파싱을 모든 명령어에 도입, 라우팅 코드 간결화.

#### 3.
Rq 클래스에 대한 설명을 할 수 있어야 함. 구현은 못해도 상관없음. 사용법은 익히자

여러가지 경우를 생각하여 시나리오 적용 및 데이터 흐름 따라가기

1~9강 / 10~15강(삭제가 있는 과정) 나눠서 학습

 - 수정기능 만들어보자.
#### 4.
- 수정기능 구현
```java
public void edit(Rq rq) {
        int id;
        try {
            id = Integer.parseInt(rq.getParams("id"));

        } catch (NumberFormatException e) {
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

```

- 이전까지는 "구현"에 초점..
- 이후부터는 "구조"에 초점...
- 16강 강의로 clone해서 반복 연습.

#### 5.
- 앞으로 할 단기 목표.
1. motivation 앱 (오늘 완료)
2. 똑같은거 한번 더 + 회원가입 기능
3. DBMS

#### 6.
- 각 클래스는 "모듈" 기능의 집합..
- 응집도는 높을수록(비슷한 기능끼리 모여있으면 좋다.)
- 결합도는 낮을수록(각 클래스끼리의 결합도, 파이프라인이 적을수록. 통신을 최소화)
#### 7.

- Main
- App
- Controller (motivation, system)
- Service(motivation, system)
  - 핵심 로직 판단.
- DAO (motivation Repository, system Repository)
- DB

MVC 패턴

- 지금 프로젝트에서 service 구조를 하나 더 붙여서 재구성함.