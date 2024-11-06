package com.ycraah.springbootboard.repository.search;

import com.ycraah.springbootboard.domain.Board;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

  public BoardSearchImpl() {
    super(Board.class);
  }
}
