package com.yeonjidev.mallapi.service;

import com.yeonjidev.mallapi.dto.PageRequestDTO;
import com.yeonjidev.mallapi.dto.PageResponseDTO;
import com.yeonjidev.mallapi.dto.TodoDTO;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

}
