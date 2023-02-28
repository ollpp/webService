package com.sh.book.webService.web.domain.posts;

import com.sh.book.webService.domain.posts.Posts;
import com.sh.book.webService.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // @After : Junit에서 제공하는 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    // 여러 테스트가 동시에 수행되면 테스트용 데이터 베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시 실패할 수 있다.
    @After
    public void cleanup() { postsRepository.deleteAll();}

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();


        System.out.println("::::::::::::::::::::::test_start:::::::::::::::::::::::");

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

        System.out.println("test end");


    }


    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);


        System.out.println(">>>>>>>>>>>> createDate = " + posts.getCreatedDate() + ", modifiedDate =" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);

    }


}
