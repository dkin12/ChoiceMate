package com.example.choicemate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {
    @GetMapping("/teamInto")
    public String teamPage() {
        return "teamInto";
    }




}