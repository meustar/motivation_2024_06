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
