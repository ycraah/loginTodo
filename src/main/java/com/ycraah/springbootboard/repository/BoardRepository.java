package com.ycraah.springbootboard.repository;

import com.ycraah.springbootboard.domain.Board;
import com.ycraah.springbootboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

}
