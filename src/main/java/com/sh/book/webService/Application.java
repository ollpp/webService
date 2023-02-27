package com.sh.book.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication : 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정해준다.
// @SpringBootApplication 이 있는 위치부터 설정을 읽어나가기 때문에 항상 프로젝트의 최상단에 위치해야 한다!!
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /**
         * SpringApplication.run
         * 해당 코드를 통해 내장 WAS 를 실행한다.
         * 내장 WAS 를 사용하는 이유는 항상 서버에 톰캣을 설치할 필요가 없게 되고,
         * 버전을 맞춰줄 필요가 없이 언제 어디서든
         * 스프링 부트로 만들어진 Jar 파일로 실행하면 되기 때문이다.
         */
    }
}
