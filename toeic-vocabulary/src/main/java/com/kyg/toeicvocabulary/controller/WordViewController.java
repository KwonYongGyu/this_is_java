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
import com.kyg.toeicvocabulary.domain.Word;
import org.springframework.web.bind.annotation.PathVariable;


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

    // 수정 폼 화면
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Word word = wordService.findById(id);
        WordRequest wordRequest = new WordRequest();
        wordRequest.setVocabulary(word.getVocabulary());
        wordRequest.setMeaning(word.getMeaning());
        wordRequest.setExampleSentence(word.getExampleSentence());
        model.addAttribute("wordId", id);
        model.addAttribute("wordRequest", wordRequest);
        return "words/edit";
    }

    // 수정 처리
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       @Valid @ModelAttribute WordRequest wordRequest,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("wordId", id);
            return "words/edit";
        }
        Word updateData = Word.builder()
                .vocabulary(wordRequest.getVocabulary())
                .meaning(wordRequest.getMeaning())
                .exampleSentence(wordRequest.getExampleSentence())
                .build();
        wordService.update(id, updateData);
        return "redirect:/words";
    }

    // 삭제 처리
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        wordService.delete(id);
        return "redirect:/words";
    }

}
