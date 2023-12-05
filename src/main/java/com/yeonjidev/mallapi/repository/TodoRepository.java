package com.yeonjidev.mallapi.repository;

import com.yeonjidev.mallapi.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
