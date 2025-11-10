package com.example.choicemate.controller;

import com.example.choicemate.dto.PostDto;
import com.example.choicemate.entity.Post;
import com.example.choicemate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 게시글 컨트롤러 클래스
 */
@Controller
@RequestMapping("/choicemate")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    // 메인화면 호출
    @GetMapping
    public String showLatestPost(Model model) {
        PostDto latestPost = service.getLatestPost();
        model.addAttribute("post", latestPost);

        /*
         TODO 소령
         여기 true 가 투표 된 것
         기본 false로 하고, 나중에 투표하면 true로 바꿔서
         DB에서 개수 불러와서 보여주면됨
         ps) 선택한거 값 넘겨서 라디오에 표시도 해주면 좋고,,
        */
        model.addAttribute("voted", false);
        return "index";
    }
}
