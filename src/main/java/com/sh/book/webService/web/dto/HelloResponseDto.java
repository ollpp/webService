package com.sh.book.webService.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@RequiredArgsConstructor
//@Repository
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
