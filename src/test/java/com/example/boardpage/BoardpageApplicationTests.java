package com.example.boardpage;

import com.example.boardpage.domain.Board;
import com.example.boardpage.domain.User;
import com.example.boardpage.domain.enums.BoardType;
import com.example.boardpage.repository.BoardRepository;
import com.example.boardpage.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardpageApplicationTests {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected BoardRepository boardRepository;

    private final String title = "제목";
    private final String email = "dkyang@google.com";

    @BeforeEach
    public void init(){
        User user = userRepository.save(User.builder()
                .name("DK")
                .password("1234")
                .email(email)
                .build());
        boardRepository.save(Board.builder()
                .title(title)
                .subTitle("부제목")
                .content("내용")
                .boardType(BoardType.free)
                .user(user)
                .build());
    }

    @Test
    void contextLoads() {

        User user = userRepository.findByEmail(email);
        Assertions.assertThat(user.getName()).isEqualTo("DK");
        Assertions.assertThat(user.getPassword()).isEqualTo("1234");
        Assertions.assertThat(user.getEmail()).isEqualTo(email);

        Board board = boardRepository.findByUser(user);
        Assertions.assertThat(board.getTitle()).isEqualTo(title);
        Assertions.assertThat(board.getSubTitle()).isEqualTo("부제목");
        Assertions.assertThat(board.getContent()).isEqualTo("내용");
        Assertions.assertThat(board.getBoardType()).isEqualTo(BoardType.free);
    }


}
