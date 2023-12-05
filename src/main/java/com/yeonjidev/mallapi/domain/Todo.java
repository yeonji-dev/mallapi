package com.yeonjidev.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_todo")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 방식으로 생성
    private Long tno;

    private String title;

    private String writer;

    private boolean complete;

    private LocalDate dueDate;
}
