package com.example.choicemate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "comments")
public class Comments {

    @Id
    @SequenceGenerator(
            name = "comments_seq_e",        // JPA 사용 이름
            sequenceName = "comments_seq",  // DB 시퀀스 이름
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq_e")
    private Integer id;

    // FK: post_id
    @ManyToOne(fetch = FetchType.LAZY)               // 다대일 관계
    @JoinColumn(                                     // FK 설정
            name = "post_id", 
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_comment_post")
    )
    private Post post;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 300)
    private String password;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
}
