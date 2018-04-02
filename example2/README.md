## Spring Boot Tutorial 진행
> 프로젝트 진행하기에 앞서 기본 프로젝트를 진행한다. 각자 설치법에 대해서는 설명을 생략한다. 이 Tutorial은 아래 참조의 송영광님의 블로그에서 참조함을 미리 말한다. 이 튜토리얼에 대한 학습을 바탕으로 Bootstrap v4와 연계하여 프로젝트를 진행한다.

#### 개발 환경 Setting

- IntelliJ IDEA Ultimate 2017.3.5
- Maven 3.5.3
- Java 8+ / Java SDK 1.8+

#### index :
1. [Spring Boot 프로젝트 생성](#t1)
2. [File Structure](#t2)
3. [소스코드 및 설명](#t3)

#### Link :
1. [__기본 개념 다지기__](../README.md)

### Spring Boot 프로젝트 생성 <a name="t1"/>

1. IntelliJ 실행하고 New Project에서 __Spring Initializr__ 를 선택한다.(Project SDK에서 Java SDK Version __1.8__ 이상을 맞춘다.)
![Alt Text][start1]

2. 다음 내용들에 대한 설정을 진행한다.
    - __Group__ : Project Name
    - __Artifact__ : Package Name
    - __Type__ : Maven / Gradle (여기에서는 Maven Project로 진행)
    - __Packaging__ : jar / war (Default Setting)
    - __Java Version__ : 8 이상으로 설정
    - __Description__ : 프로젝트에 대한 설명(설정하지 않아도 무관)
    ![Alt Text][start2]
    
3. __Dependency__ 선택 : 프로젝트에서 사용할 기술들을 선택한다. 본 Tutorial에서는 __RESTful Web Service__ 를 사용할 것이기 때문에 Web에서 Web을 선택하고, Template Engines의 __Thymeleaf__ 를 사용할 것이기 때문에 Thymeleaf를 선택한다. Project를 진행하면서 본인의 사용 기술에 맞추어서 선택을 한다.
![Alt Text][start3]

4. Project Name 및 Location 설정 : 프로젝트의 이름과 위치를 지정한다. 개발자들의 기호에 맞게 설정을 진행하면 된다. 이로써 프로젝트 생성이 끝이난다.
![Alt Text][start4]

### File Structure <a name="t2"/>

```
~/example2
    +- .idea
        +- inspectionProfiles
            +- Project_Default.xml
        +- libraries
            +- ...
        +- compiler.xml
        ...
    +- .mvn
        +- wrapper
            +- maven-wrapper.jar : maven project를 압축한 ~.jar File
            +- maven-wrapper.properties : maven project의 속성
    +- src
        +- main
            +- java
                +- com
                    +- tutorial
                        +- example1
                            +- Example1Application.java : Example1 Project를 실행시켜주는 java File
            +- resources
                +- static : 정적 resource를 담고있는 Directory
                +- templates : 프로젝트 View를 담당하는 Directory
                +- application.properties
        +- test
            +- java
                +- com
                    +- tutorial
                        +- example1
                            +- Example1ApplicationTest.java
    +- .gitignore
    +- example1.iml
    +- mvnw
    +- mvnw.cmd
    +- pom.xml : Maven Project에서 미리 정의된 Dependency를 담고 있는 XML File
```

앞으로 File Structure에 대해서는 설명을 생략한다.

### 소스코드 및 설명 <a name="t3"/>

##### pom.xml

- File Path : example2/pom.xml

- 설명 : Maven Project의 Dependency를 담고 있다. 먄약에 다른 dependency를 추가하고 싶다면 이곳에서 추가를 진행한다. Tutorial에서는 Thymeleaf를 사용할 것이기 때문에 Dependency에 Thymeleaf를 추가하였다.

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.Tutorial</groupId>
	<artifactId>example1</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>example1</name>
	<description>This is Tutorial Example1.</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


</project>

```

##### __Post.java__

- File Path : example2/src/main/java/com/tutorial/example1/Post.java

- 설명 : 변수들만 선언해주는 Test를 위한 Post 객체이다. id, title, content, created_at, updated_at 변수들로 구성이 되어있고, getter와 setter를 만들어준다.

```java
package com.tutorial.example1;

import java.util.Date;

public class Post {
    //변수 선언
    private long id;
    private String title;
    private String content;
    private Date created_at;
    private Date updated_at;

    //Getter & Setter
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }
}

```

##### PostController.java

- File Path : 전과 동일/PostContoller.java

- 설명 : MVC Pattern의 개발을 위한 __Controller__ 를 생성한다. 

여기서 ```@EnableAutoConfiguration``` 어노테이션은 Spring Boot의 핵심 어노테이션 중 하나로 __자동 설정__ 을 담당하는 어노테이션이다. 이 어노테이션에는 ```exclude``` 와 ```excludeName``` 이라는 두 가지 속성이 존재한다. 자동 설정을 하고 싶지 않은 클래스가 있다면 이 두 속성을 사용하여 자동 설정에서 제외시킬 수도 있다.

```@RequestMapping``` 는 Class 레벨인지, Method 레벨인지에 따라서 조금 차이가 있는데 아래의 코드에는 Method 레벨의 어노테이션이다. Method 레벨의 @RequestMapping 은 Method가 __어떤 HTTP 요청을 처리할 것인지__ 명시하는 어노테이션이다. 사용법은 ```@RequestMapping('Path', 'Method', 'Consume', 'Produce')``` 형태로 사용한다. 여기서 __Path__ 는 HTTP URI가 해당 Path 인 것만 처리한다는 의미이다. __Method__ 는 명시한 요청 메소드만 처리한다는 의미이고, __Consume__ 과 __Produce__ 는 생략이 가능한 속성으로 Consume은 요청 헤더에 대한 처리,ㅌ Produce는 응답 헤더에 대한 처리를 뜻한다. 

아래의 코드에서 첫 번째 RequestMapping 어노테이션에서 Path는 __"/post/new"__ 이므로, HTTP URI에 해당 경로를 추가하면 __"new"라는 html 페이지를 return__ 한다. 즉, Controller 역할을 하는 Class에서 메소드는 __return 값이 html 파일명__ 이다. 예를 들어 ```localhost:8080/post/new``` 로 들어가면 아래 나오게 될 new.html이 나오게 되는 것이다. 그러면서 모델에서는 post라는 이름의 새로운 Post() 객체가 생성이 되는 것이다. 또한 해당 method는 GET 메소드를 처리한다.

두 번째 RequestMapping 어노테이션에서는 "/posts"라는 URI가 추가되면 show라는 html 페이지가 return이 된다. 또한 POST Method를 처리하는 method로 사용된다는 의미이다. 여기서 ```@ModelAttribute``` 어노테이션이 나오는데, 이는 해당 method가 생성한 객체가 __View에 전달__ 된다는 의미의 어노테이션이다. 즉, ```newPost``` 메소드에서 생성한 __post라는 POST 객체__ 가 ```new.html``` 에서 데이터를 담게되고, 그 담긴 객체가 ```createPost``` 에서 파라미터로 가져와서 __show.html에서 View에 추가__ 가 되는 것이다. createPost의 ```model.addAttribute()``` 에서 두 개의 post 중에서 __"post"__ 는 __View에서 post로 정의된 값과 매칭__ 을 하는 것이고, 그 뒤의 __post__ 는 어노테이션을 써서 파라미터로 가져온 __post 객체__ 를 뜻한다.

```java
package com.tutorial.example1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class PostController {
    @RequestMapping(value = "/posts/new", method = RequestMethod.GET)
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new";
    }
    
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post, Model model) {
        model.addAttribute("post", post);
        return "show";
    }
}
```

##### new.html

- File Path : example2/src/main/resources/templates/new.html

- 설명 : thymeleaf 템플릿 엔진을 사용하기 때문에 html 속성에 thymeleaf를 추가해준다. thymeleaf의 태그 속성에 대해서는 위에서 설명했기 때문에 아래의 코드를 통해서 사용법만 보고 설명은 생략한다.

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>RestTemplate Demo</title>
    <meta charset=utf-8”/>
</head>
<body>
<h1>New</h1>

<form action="#" th:action="@{/posts}" th:object="${post}" method="post">
    <p>title: <input type="text" th:field="*{title}" /></p>
    <p>content: </p>
    <p><textarea th:field="*{content}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>
```

##### show.html

- File Path : example2/src/main/resources/templates/show.html

- 설명 : new.html에서 작성한 내용을 thymeleaf의 태그 속성값을 이용해서 가져온다.(post.title, post.content) ```<a>``` 태그를 사용하여 HTTP URI에 "posts/new"를 붙여 이전 페이지로 이동을 할 수 있다.

```html
<!DOCTYPE HTML>  
<html xmlns:th="http://www.thymeleaf.org">  
<head>  
    <title>RestTemplate Demo</title>
    <meta charset="utf-8"/>
</head>  
<body>  
<h1>Post</h1>  
    <p th:text="'title: ' + ${post.title}" />
    <p th:text="'content: ' + ${post.content}" />
    <a href="/posts/new">새글 작성하기</a>
</body>  
</html> 
```

#### Reference :
- [송영광님의 블로그 : IntelliJ에서 SpringBoot 웹 프로젝트 생성하기](http://blog.saltfactory.net/creating-springboot-project-in-intellij/)
- [Spring Web MVC, @Controller Annotation 정리](http://jsonobject.tistory.com/257)

[start1]:https://imgur.com/Fekbhun.png
[start2]:https://imgur.com/I4h0pZp.png
[start3]:https://imgur.com/ilfaV3s.png
[start4]:https://imgur.com/tRIdmCq.png