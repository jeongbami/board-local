package com.project.boardproj.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //table임을 명시하는 어노테이션
@Data //board class의 query를 data로 받아들이는 anotation
public class Board {
    @Id // primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_index;

    private String board_title;

    private String board_content;

}
