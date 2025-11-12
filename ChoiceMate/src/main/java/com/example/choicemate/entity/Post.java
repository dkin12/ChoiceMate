package com.example.choicemate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
public class Post {

    // PK
    @Id
    @SequenceGenerator(
            name = "post_seq_e",        // JPA 사용 이름
            sequenceName = "post_seq",  // DB 시퀀스 이름
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_e")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(name = "option_a", nullable = false, length = 150)
    private String optionA;

    @Column(name = "option_b", nullable = false, length = 150)
    private String optionB;

    @Column(
            name = "votes_a",
            nullable = false,
            columnDefinition = "INT DEFAULT 0"
    )
    private int votesA;

    @Column(
            name = "votes_b",
            nullable = false,
            columnDefinition = "INT DEFAULT 0"
    )
    private int votesB;

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();

    // 게시글 삭제 시 연관 댓글 함께 삭제되도록 설정
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @Builder.Default
    private List<Comments> comments = new ArrayList<>();

    // -------------------- 투표 증가 메서드 ---------------------
    public void vote_A(){
        this.votesA++;
        this.updatedAt = LocalDateTime.now();
    }
    public void vote_B(){
        this.votesB++;
        this.updatedAt = LocalDateTime.now();
    }


}
