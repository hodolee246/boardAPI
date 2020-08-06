package com.example.board.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String writer;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime modifyAt;

    @Column
    private int status;

}
