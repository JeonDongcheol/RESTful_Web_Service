## RESTful Web Service
> RESTful Web Service에 대해서 학습한 페이지입니다. 졸업 프로젝트 진행을 위한 스터디입니다.

#### Index :
1. [__What is REST?__](#i1)
2. [__Thymeleaf & Spring Boot__](#i2)
3. [__MVC Pattern__](#i5)
4. [__MongoDB__](#i3)

#### Link :
1. [__Tutorial__](./example2/README.md)
2. [__Graduation Project__](./graduation/graduation.md)

### 1. What is REST? <a name="i1"/>
> REST에 대한 기본 개념을 학습한다.

![Alt Text][rest_rogo]

REST란 __(REpresentational State Transfer)__ 의 약자이다. Network 상에서 Client와 Server 사이의 통신 방식인데, __URL__ 을 이용해서 데이터를 간단하게 요청하는 기능이다. 근래에 들어서 HTTP와 JSON을 함께 사용하여 OPEN API를 구현하는 방법으로 사용된다.

![Alt Text][rest_web_service]

대부분의 OPEN API는 REST 아키텍쳐를 기반으로 설계 및 구현이 되었는데, URI를 이용해서 제어할 자원을 명시하고, HTTP를 이용해서 제어 명령을 하게 된다. 이는 __ROA__ (Resource Oriented Architecture)를 따르는 Web Service Design의 표준이다.

__ROA 아키텍쳐의 특징__
1. __Performance__
2. __Scalability__ : 많은 수의 component로 이루어진 system에서 HTTP를 기반으로 하는 REST는 확장성 측면에서 강점을 드러낸다.
3. Interface의 __단순화__
4. __필요한 component만 수정 가능__ : APP 실행 중에도 가능하다.
5. Program Code와 Data의 컴포넌트화로 __높은 이식성__
6. __System Fail__ 에 대한 강한 저항성

__REST의 특징__

1. 잘 정의된 Cool URI로 Resource를 표현
2. Session을 사용하지 않음.
3. 4가지 속성을 지향하는 Web-Service Design 표준
    - __Addressability__ : 제공하는 정보는 모두 URI로 표시 가능해야 한다.
    - __Connectedness__ : 하나의 Resource는 서로 주변의 연관 Resource들고 연결되어 표현(Presentation)되어야 한다.
    - __Statelessness__ : 현재 Client의 상태를 절대로 Server에서 관리하지 않아야 한다.
    - __Homogeneous Interface__ : HTTP에서 제공하는 기본적인 4가지의 CRUD Method와 추가 2가지 Method를 이용해서 Resource의 모든 동작을 정의한다.


- REST 장단점

|장점|단점|
|---|---|
|Language, Platform에 __중립적__ (독립적)|__Point To Point__ 통신 모델을 가정|
|SOAP보다 개발하기 __쉽고, 단순__ |보안 표준이 __없음__|
|__개발 인프라__ 탄탄함|HTTP 통신 모델에 __높은 의존성__ |
|__간결하고 Web에 가까운 설계__ 가 가능|__CRUD__ 4가지 Method만 제공 - 다른 작업의 처리에서 모호|

__REST의 구성 요소__

1. __Resource__ : 유일한 ID를 가지는 Resource가 Server에 존재한다. Client는 각 Resource의 State를 Control하기 위해서 Request를 보낸다. 일반적으로 Resource는 명사형의 구분하기 쉬운 단어를 사용한다.

2. __Method__ : GET, DELETE 등과 같이 Resource를 조작할 수 있는 동사형 단어를 말한다. Client는 URI를 이용해서 Resource를 지정하고 해당 Resource를 조작하기 위해서 Method를 사용한다. Resource의 예로는 GET, POST, PUT, DELETE 등이 있다.

3. __Representation of Resource__ : Client가 Server로 Request를 보냈을 때, Server가 Response로 보내주는 Resource의 상태(Representation). REST에서 하나의 Resource는 XML, JSON, TEXT, RSS 등의 여러 형태의 Representation으로 나타내어 질 수 있다.

4. __URI 구성__ : 직관적으로 어떤 정보를 제공할 수 있는지 알 수 있는 단어들로 구성이 된다. URI Path가 계층적인 구조를 가지도록 구성하고, 상위 Path는 하위 Path의 집합을 의미하는 단어로 구성한다. CREATE, DESTROY, UPDATE, DELETE 등의 기본 CRUD 처리는 URI에 명시적으로 표현하도록 하여 URI를 보더라도 직관적으로 어떤 기능을 제공하는지 알 수 있도록 명명한다.

#### RESTful API

__HTTP와 URI 기반__ 으로 Resource에 접근할 수 있도록 제공하는 __Application Programming Interface__ 를 말하며, 기본적으로 개발자는 HTTP Method와 URI 만으로 Internet Resource들을 CRUD 가능

RESTful API 개발 원칙
1. __자원 식별이 가능__ 해야 함. URL 만으로 어떤 Resource을 control하려고 하는지를 알 수 있어야 하며, Resource 위치는 물론 종류까지 알 수 있어야 한다.

2. 행위는 __명시적__ 이어야 한다.

3. __자기 서술적__ 이어야 한다. 데이터에 대한 Meta Data만 가지고도 어떤 종류의 Data인지, 혹은 Data를 위해서 어떤 Application을 실행해야 하는지를 알 수 있어야 한다.

### 2. Tymeleaf & Spring Boot <a name="i2"/>
> REST 프로젝트 진행에서 사용할 Thymeleaf와 Spring Boot에 대한 간략한 설명

#### Thymeleaf

![Alt Text][thymeleaf_logo]

[Thymeleaf 홈페이지 바로가기](https://www.thymeleaf.org/index.html)

Thymeleaf는 새련된 Server-Side의 XML, XHTML, HTML5 문서를 생성하는 __Java Template Engine__ 이다. 기본적으로 XML Tag 와 속성 형태로 이루어져 있으며, Template을 신속하게 처리하고 Parsed Files의 Intelligent Caching을 통해서 작은 양의 I/O Operation을 가능하게 만들었다.

처음부터 XML 및 Web 표준을 염두해두고 만들어져서 Fully Validating Templates를 생성할 수 있고, 총 여섯 종류의 Template을 Processing할 수 있다.

1. SML
2. Valid XML
3. XHTML
4. Valid XHTML
5. HTML5
6. Legacy HTML5

__Thymeleaf의 장점__
1. Server 상에서 동작을 하지 않아도 된다.
2. 전체적인 Mark-Up 구조를 흐트리지 않는다.
3. Text-Editor를 통해서 작업을 하고 해당 내용을 브라우저로 바로 확인 가능 : HTML의 속성(Attribute)를 기반으로 작성되기 때문이다.

뒤에서 진행할 grad_project에서 사용하게될 템플릿 엔진으로 Spring Boot에서 사용이 권장되고 있다.

#### Spring Boot

![Alt Text][springboot_logo]

[Spring Boot 홈페이지 바로가기](https://projects.spring.io/spring-boot/)

Spring Boot는 Spring Framework를 기반으로 기존에 개발자가 직접 해야했던 설정들을 자동화 및 간편화 할 목적으로 만든 Framework이다. Spring Boot의 결과물은 기본적으로 Embedded Tomcat이 포함되어있는 *.jar 형태로 배포되는데, 별도의 Tomcat의 설치 및 설정 없이 실행시킬 수 있다.

Spring Boot의 특징은 다음과 같다.
1. Maven이나 Gradle 등의 __빌드 Tool__ 사용
2. 모든 Spring 개발 환경에 __빠르게 접근 가능__
3. 요구사항을 빠르게 처리할 수 있는 __기본 설정값__
4. 프로젝트 환경 구축에서 요구되는 기능 외적인 기능 제공
5. 시작을 위한 XML 기반 설정 및 별도의 코드 요구하지 않음.

__REST API__ 서버를 만들거나 __MVC__ 패턴 환경을 만들 때, 혹은 여기에 필요한 DB, View Template을 구성하는데 있어서 __자동 구성__ 을 지원한다. 필요한 Library 의존성을 안전성을 확인한 버전으로 조합해 미리 준비된 구성으로 제공하거나 ```spring-boot-starter``` 를 사용하여 의존성을 자동으로 추가하거나 필요한 기능 유형을 지정하게 된다.

Spring Boot로 개발을 진행하면서 __Annotation__ (어노테이션)이라는 것을 많이 사용하는데, Annotation이란 java 코드에서 주석처럼 사용해 특수한 의미를 부여하는 문법 요소이다. Compile 혹은 Run Time 시에 해석이 된다. _JEE5_ 부터 새롭게 추가되었다. Annotation을 사용하면 기존 Web Application에서는 프로그래밍을 위해서 매번 많은 설정 파일을 작성해야 했고, Domain의 데이터 처리정보가 Model 클래스, Service 클래스, XML 설정 파일에 분산이 되어있어서 처리 정보를 확인하기 위해 모든 설정 파일들을 뒤져야했었다. 하지만 Annotation을 사용함으로써 데이터에 대한 유효성 검사 조건을 Annotation 사용하여 Model 클래스에 직접 명시함으로써 데이터들에 대한 유효 조건을 쉽게 파악할 수 있고 코드의 양도 줄어들게 되었다.

- Annotation의 용도
    1. __문서화__ : 문법적으로 @기호를 사용하여 Package, Class, Properties, Variable 등에 명시할 수 있는데, 이러한 어노테이션이 붙은 소스를 Compile 시에 수집하여 API 문서화할 수 있다. 실질적으로 JavaDoc이라는 좋은 문서화 도구가 있기 때문에 이를 위해 사용하는 비중은 낮다.
    2. __코드 체크__ : Compile 시 에러를 발생시켜 개발자에게 경고를 해서 확인시켜주는 목적으로 사용된다.
    3.  __코드 분석(Meta Data)__ : JEE 설정과 유효성 검사 부분에서 데이터를 위한 데이터, 즉, 메타 데이터의 용도로써 사용된다. 가장 많은 목적으로 사용이 된다.

- Spring Boot 대표 Web MVC Annotation
    1. ```@Controller``` : Client로부터 전달되어진 데이터를 가공하기 위한 Controller 임을 명시한다.
    2. ```@Repository``` : 해당 Class가 DB에 접근하는 Class임을 명시하는 어노테이션
    3. ```@Entity``` / ```@Document``` : DB에 Table을 생성하거나 데이터를 가공하기 위한 Class 임을 명시한다.. Entity는 일반적인 DBMS, Document는 MongoDB와 같은 Table 단위가 아닌 Document Type의 DB를 지정한다.
    4. ```@Service``` : Repository를 통해 DB에서 데이터를 가져온 후 Controller에게 전달해주는 Class 임을 명시한다.
    
### 3. MVC Pattern <a name="i5"/>
> MVC 패턴에 대한 개념 학습

MVC Pattern이란 __Model-View-Controller__ 의 약자로 소프트웨어 디자인 패턴을 말한다. View(UI)로부터 Business Logic을 __분리__ 하여 서로 영향 없이 따로 쉽게 고칠 수 있는 패턴이다. MVC Pattern은 View와 Model 사이에 Controller라는 중간 과정을 두어 Dependency(의존성)을 분리하기 위해서 나타나게 되었다. MVC 패턴의 구성요소는 다음과 같다.

- __Model__ :  View와 Controller 사이에서 전달되는 Data만을 나타내는 단순한 __View Model__ 혹은 Data 및 Data에 대한 작업, 규칙을 가지고 있는 __Domain Model__ 일 수도 있다. Data 변경에 따른 내용을 View를 통해서 Update 한다.

- __View__ : 사용자 눈에 보여지는 부분을 말한다. 시각적인 __디자인__ , __UI__ (User Interface), 사용자의 요청에 따른 __결과물__ 이 표현된다. 화면에 표출되는 방식에 대한 Logic이 들어가야 하며, Model에 의해 Update 된다.

- __Controller__ : View와 Model을 __연결__ 시켜주며, 사용자의 입력을 받아 Model을 조작하는 등 __Data 흐름을 제어하는 역할__ 을 한다. 사용자에게 보여줄 적절한 뷰를 선택하기도 하지만, 직접 View를 Update 하지는 않는다.

MVC Pattern의 형태는 개발 방법이다 언어에 따라서 다를 수 있지만 대체적으로 다음과 같다.

![Alt Text][mvc_pattern]

### 4. MongoDB <a name="i3"/>
> NoSQL과 MongoDB에 대한 내용을 학습한다.

![Alt Text][mongo_logo]

#### NoSQL이란?

4차 산업혁명이 나타남에 따라서 대용량 데이터에 대한 처리 능력이 급격하게 요구되었다. 그러면서 기존의 RDBMS (관계형 데이터베이스)는 대용량의 데이터를 처리하는데 있어서 비용과 효율이 좋지가 않다는 것이 화제가 되었고, 이를 해결하기 위해서 등장한 것이 NoSQL이다. NoSQL은 __Not Only SQL__ 의 약자로써 Big Data와 실시간 Web Application 등에 많이 쓰이고 있는 데이터베이스이다.

- NoSQL의 특징

    - __분산 저장__ : 데이터와 트래픽이 증가함에 따라 기존의 수직적 확장이 아니라 장비의 수를 늘리는 __수평적 확장 방식__ 을 뜻한다. __Shard Key__ 를 기준으로 하나의 테이블을 수평 분할하여 서로 다른 클러스터에 분산 저장하고 질의할 수 있다.

    - __Schema-less__ : 데이터 구조를 미리 정의할 필요가 없고 시간이 지나더라도 언제든지 바꿀 수 있다. 데이터베이스가 스키마를 직접 관리하지 않는 것을 의미하지만, 암묵적인 스키마는 여전히 존재한다.

- NoSQL의 장단점

|장점|단점|
|---|---|
|특정 용도에 특화|각 솔루션에 대한 이해 필요|
|여러 서버에 데이터 분산 가능|운영 노하우가 적음|
|배열 형식의 데이터를 고속으로 처리 가능|버그가 상대적으로 많음|
|대용량의 모든 데이터 저장 가능|새로운 솔루션이 계속 나와서 지속적인 습득 필요|

- NoSQL Database의 유형

    1. __Document-Oriented Database__ (Document Store) : 테이블 스키마가 정적이지 않고 유동적인 DB. Record(레코드) 마다 다른 스키마를 가질 수 있다. 일반적으로 __JSON, XML__ 과 같은 Document를 이용해 레코드를 저장한다. 따라서 RDBMS와 다르게 Tree 구조를 저장하거나 찾는데 유용하다. __ex) MongoDB, Amazone DynamoDB, CouchBase__

    2. __Wide Column Store__ : 많은 수의 동적 열을 보유할 수 있는 DB. 레코드 Row마다 __Key-Value__ 를 가지고 있어서 레코드마다 다른 스키마를 가질 수 있다. 이런 점에서는 Document Store과 많이 유사하지만 기본적인 구현에서는 차이가 있다. 레코드 면에서는 RDBMS와 유사하지만 더 큰 분산처리에 용이하다는 특징이 있다. 그래서 많은 Column과 Data를 저장할 때 유용하지만 Data Scan에는 상대적으로 효율성이 떨어지는 편이다. __ex) Cassandra, HBase, Google Big Table__

    3. __Key-Value Store__ : __Key__ 와 __Value__ 로 이루어진 단순한 구조의 DB. 속도가 빠르고 분산 저장 환경이 용이하기 때문에 단순한 구조를 사용한다. 빠른 접근을 위해 메모리를 주로 사용한다. Wide Column과 마찬가지로 접근 속도는 빠르지만 Data Scan에는 약한 편이다. __ex) Redis, Memached, EhCache, Hazelcast__

#### Reference :

- [RESTful Web Service란 무엇인가?](http://kimseunghyun76.tistory.com/18)
- [Thymeleaf란 무엇인가?](http://krespo.net/152)
- [MVC Pattern 개념 정리](http://glorymind.tistory.com/entry/MVC-Pattern-%EA%B0%9C%EB%85%90)
- [Java Annotation - 로그의 노트](http://hiddenviewer.tistory.com/88)
- [SpringMVC - Annotation을 이용한 Controller, Domain, Service, Repository - 노랭이가](http://yellowh.tistory.com/109)
- [NoSQL 개념 정리 - 사이버이메지네이션](http://cyberx.tistory.com/163)
- [DATABASE & NOSQL의 종류 - DEV IMPERFECT](https://inyl.github.io/programming/2017/05/09/database.html)

[rest_rogo]:https://imgur.com/MdxQ1y7.png
[rest_web_service]:https://imgur.com/NFnX8bt.png
[thymeleaf_logo]:https://imgur.com/hT5H5WU.png
[springboot_logo]:https://imgur.com/raBai3u.png
[mvc_pattern]:https://imgur.com/r3EspuC.png
[mongo_logo]:https://imgur.com/bOAyRxL.png
