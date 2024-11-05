package com.ycraah.springbootboard.repository.search;

import com.ycraah.springbootboard.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
  Page<Board> search(Pageable pageable);
}
