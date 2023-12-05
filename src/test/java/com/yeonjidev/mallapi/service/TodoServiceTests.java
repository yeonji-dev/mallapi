package com.yeonjidev.mallapi.service;

import com.yeonjidev.mallapi.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister(){
        TodoDTO todoDTO = TodoDTO.builder()
                .title("서비스 테스트")
                .writer("tester")
                .dueDate(LocalDate.of(2023, 10, 10))
                .build();

        Long tno = todoService.register(todoDTO);

        log.info("TNO: {}", tno);
    }

    @Test
    public void testGet(){
        Long tno = 101L;
        TodoDTO todoDTO = todoService.get(tno);
        log.info(todoDTO);
    }

    @Test
    public void testModify(){
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(101L)
                .title("서비스 테스트 수정")
                .dueDate(LocalDate.of(2023, 10, 12))
                .complete(false)
                .build();

        todoService.modify(todoDTO);
    }
}
