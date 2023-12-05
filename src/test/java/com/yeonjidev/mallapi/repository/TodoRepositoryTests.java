package com.yeonjidev.mallapi.repository;

import com.yeonjidev.mallapi.domain.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1(){
        log.info("---------------------------");
        log.info(todoRepository);
    }

    @Test
    public void testInsert(){
        for(int i = 1; i <= 100; i++){
            Todo todo = Todo.builder()
                    .title("Title..." + i)
                    .dueDate(LocalDate.of(2023, 12, 31))
                    .writer("user00")
                    .build();

            todoRepository.save(todo);
        }
    }

    @Test
    public void testRead(){
        Long tno = 33L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElse(null);
        log.info(todo);
    }

    @Test
    public void testModify(){
        Long tno = 33L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElse(null);
        todo.changeTitle("Modified 33...");
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2023,10,10));

        todoRepository.save(todo);
    }

    @Test
    public void testDelete(){
        Long tno = 1L;
        todoRepository.deleteById(tno);
    }
}
