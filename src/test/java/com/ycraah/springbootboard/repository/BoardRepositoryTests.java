package com.ycraah.springbootboard.repository;

import com.ycraah.springbootboard.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

  @Test
  public void deleteTest(){
    Long bno = 100L;
    boardRepository.deleteById(bno);
  }

  @Test
  public void pagingTest(){
    Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
    Page<Board> result = boardRepository.findAll(pageable);
    log.info("total count: " + result.getTotalElements());
    log.info("total pages: " + result.getTotalPages());
    log.info("page number: " + result.getNumber());
    log.info("page size: " + result.getSize());

    List<Board> todoList = result.getContent();
    todoList.forEach(board -> log.info(board));
  }
}
