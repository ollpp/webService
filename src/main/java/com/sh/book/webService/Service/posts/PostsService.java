package com.sh.book.webService.Service.posts;


import com.sh.book.webService.domain.posts.Posts;
import com.sh.book.webService.domain.posts.PostsRepository;
import com.sh.book.webService.web.dto.PostsListResponseDto;
import com.sh.book.webService.web.dto.PostsResponseDto;
import com.sh.book.webService.web.dto.PostsSaveRequestDto;
import com.sh.book.webService.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional(readOnly = true)
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID =" + id));

        return new PostsResponseDto(entity);
    }


    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        postsRepository.delete(posts);
    }



}
