package com.sh.book.webService.web;

import com.sh.book.webService.web.dto.HelloResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Json을 반환해주는 컨트롤러 : @RestController
@RestController
@Slf4j
public class HelloController {

    // Http Method 인 Get 요청을 받을 수 있는 API를 만들어 준다.
    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){

//        return name+"-"+"여기까지 들어왔다";
        return new HelloResponseDto(name, amount);
    }

}
