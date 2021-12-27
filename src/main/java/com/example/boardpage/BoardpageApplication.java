package com.example.boardpage;

import com.example.boardpage.domain.Board;
import com.example.boardpage.domain.User;
import com.example.boardpage.domain.enums.BoardType;
import com.example.boardpage.repository.BoardRepository;
import com.example.boardpage.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.IntStream;

@EnableJpaAuditing
@SpringBootApplication
public class BoardpageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardpageApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception{
        return(args)->{
            User user = userRepository.save(User.builder()
                    .name("대경")
                    .password("1234")
                    .email("dkYang@naver.com")
                    .build());

            User user2 = userRepository.save(User.builder()
                    .name("은서")
                    .password("1234")
                    .email("esKim@naver.com")
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index -> boardRepository.save(Board.builder()
                    .title(String.format("제목%s", index))
                    .subTitle(String.format("부제목 %s", index))
                    .content(String.format("내용 %s", index))
                    .boardType(BoardType.free)
                    .user(user)
                    .build())
            );

        };
    }
}
