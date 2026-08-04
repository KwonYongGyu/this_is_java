package com.kyg.toeicvocabulary.controller;

import com.kyg.toeicvocabulary.dto.WordRequest;
import com.kyg.toeicvocabulary.service.WordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/words")
@RequiredArgsConstructor
public class WordViewController {

    private final WordService wordService;

    // 목록 화면
    @GetMapping
    public String list(Model model) {
        model.addAttribute("words", wordService.findAll());
        return "words/list";
    }

    // 등록 폼 화면
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("wordRequest", new WordRequest());
        return "words/form";
    }

    // 등록 처리
    @PostMapping
    public String create(@Valid @ModelAttribute WordRequest wordRequest,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "words/form"; // 검증 실패 시 다시 폼으로
        }
        wordService.save(wordRequest);
        return "redirect:/words"; // 성공 시 목록으로 리다이렉트
    }
}
