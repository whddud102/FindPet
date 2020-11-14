## FindPet

#### 유기동물 API를 이용한 유기동물 조회 프로젝트

> 메인 화면에서는 오늘 구조된 유기 동물들을 간단히 확인할 수 있으며, 검색 조건을 통한 상세 검색도 제공한다

> URI : http://ec2-13-209-229-161.ap-northeast-2.compute.amazonaws.com:8080/findPet/home

---
## 메인 화면 1 
![Home.gif](/images/Home.gif)


--- 
## 메인 화면 2 - (오늘 구조된 유기동물이 없는 경우)
![noData.PNG](/images/noData.PNG)



---
## 검색 및 조회 화면
![searching.gif](/images/searching.gif)



---
## 모바일 화면 (반응형 웹 디자인)
![mobile.gif](/images/mobile.gif)



---
## 기술 스택
- AWS EC2
- Tomcat
- Java
- Spring Boot
- JavaScript
- jQuery
- BootStrap
- Thymeleaf
- Ajax

---
## 개발 기간
- 06.05 ~ 06.12 : 유기 동물 조회 및 검색 기능 개발
- 09.21 ~ 10.03 : 게시판 기능 추가

---
## 느낀 점
- 스프링 부트를 이용하니깐 확실히 개발 환경 구축에 드는 노력과 시간을 줄일 수 있었다.

- API의 응답 데이터가 XML 형태라서 파싱을 하는데 마샬링/언마샬링을 익히느라 애를 먹었다.

- 서버 쪽에서는 API를 요청 후 응답 데이터를 잘 가공해서 View에 전달해주거나 JSON 형태로 반환만 해주면 되기 때문에 어렵지 않았지만,
  오히려 View의 레이아웃을 배치하고, 디바이스의 화면 크기 별로 반응형으로 디자인하고, JavaScript, Ajax 등을 이용해서 동적인 화면을 보여주는 게
  더 오래 걸리고 지루한 작업이었다.
  
 - 템플릿 엔진으로 Thymeleaf를 사용하니깐 반복문, 조건문과 같은 기능을 이용해서 굉장히 편하게 View를 작성할 수 있었다.



