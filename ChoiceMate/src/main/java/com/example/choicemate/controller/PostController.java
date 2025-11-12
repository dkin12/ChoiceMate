package com.example.choicemate.controller;

import com.example.choicemate.dto.PostDto;
import com.example.choicemate.entity.Post;
import com.example.choicemate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
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
        model.addAttribute("voted", false);
        return "index";
    }
    /*
        TODO 소령
        여기 true 가 투표 된 것
        기본 false로 하고, 나중에 투표하면 true로 바꿔서
        DB에서 개수 불러와서 보여주면됨
        ps) 선택한거 값 넘겨서 라디오에 표시도 해주면 좋고,,
     */

    @PostMapping("/vote")
    public String vote(@RequestParam int id, @RequestParam String voteOption, Model model) {
        // 투표
        PostDto dto = service.vote(id, voteOption);

        // DB에서 득표 수 불러오기
        int countA = dto.getVotesA();
        int countB = dto.getVotesB();

        // percentage 계산
        int total = countA + countB;
        double percentageA = (total == 0) ? 0: ((double)countA / (double)total)*100;
        double percentageB = (total == 0) ? 0: ((double)countB / (double)total)*100;

        model.addAttribute("post", service.getLatestPost());
        model.addAttribute("voted", true);
        model.addAttribute("countA", countA);
        model.addAttribute("countB", countB);
        model.addAttribute("percentageA", percentageA);
        model.addAttribute("percentageB", percentageB);


        return "index"; // 투표 후에도 index.html로 돌아감
    }
}
