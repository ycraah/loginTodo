package com.ycraah.springbootboard.repository;

import com.ycraah.springbootboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
