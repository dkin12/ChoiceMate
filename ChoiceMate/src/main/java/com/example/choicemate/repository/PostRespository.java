package com.example.choicemate.repository;

import com.example.choicemate.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRespository extends JpaRepository<Post, Integer> {

    /*
        글 등록 화면이 따로 없어서
        DB에 저장된 최신 데이터를 가져오도록 설정
        +
        댓글 같이 가져오도록
    */
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments WHERE p.id = (SELECT MAX(p2.id) FROM Post p2)")
    Optional<Post> findLatestPostWithComments();
}
