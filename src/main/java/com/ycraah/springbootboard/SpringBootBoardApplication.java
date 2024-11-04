package com.ycraah.springbootboard;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@Log4j2
@SpringBootApplication
public class SpringBootBoardApplication {
  public static void main(String[] args) {
    Properties properties = new Properties();
    log.info(properties);
    SpringApplication.run(SpringBootBoardApplication.class, args);
  }
}
