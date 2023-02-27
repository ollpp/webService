package com.sh.book.webService.Service.posts;


import com.sh.book.webService.domain.posts.PostsRepository;
import com.sh.book.webService.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    // @RequiredArgsConstructor 때문에 필드 주입이 아닌, 생성자 주입이다.
    // @RequiredArgsConsturctor : final 이 붙은 변수들을 생성자로 삽입
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}
