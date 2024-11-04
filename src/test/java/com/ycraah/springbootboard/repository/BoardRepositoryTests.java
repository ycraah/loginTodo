package com.ycraah.springbootboard.repository;

import com.ycraah.springbootboard.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void insertTest(){
    IntStream.rangeClosed(1,100).forEach(i -> {
      Board board = Board.builder()
          .title("title..." + i)
          .content("content..." + i)
          .writer("user" + (i % 10))
          .build();

      Board result = boardRepository.save(board);
      log.info("BNO: " + result.getBno());
    });
  }

  @Test
  public void selectTest(){
    Long bno = 100L;
    Optional<Board> result = boardRepository.findById(bno);
    Board board = result.orElseThrow();
    log.info(board);
  }
}
