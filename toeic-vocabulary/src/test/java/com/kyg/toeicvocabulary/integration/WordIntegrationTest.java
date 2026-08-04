package com.kyg.toeicvocabulary.integration;

import com.kyg.toeicvocabulary.domain.User;
import com.kyg.toeicvocabulary.domain.Word;
import com.kyg.toeicvocabulary.repository.UserRepository;
import com.kyg.toeicvocabulary.repository.WordRepository;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WordIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        if (userRepository.findByUsername("integrationTester").isEmpty()) {
            User user = User.builder()
                    .username("integrationTester")
                    .password(passwordEncoder.encode("pw1234"))
                    .build();
            userRepository.save(user);
        }
    }

    @AfterEach
    void tearDown() {
        wordRepository.deleteAll();
    }

    @Test
    void 로그인_없이_단어목록_접근시_로그인페이지로_리다이렉트된다() throws Exception {
        mockMvc.perform(get("/words"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    void 로그인_성공시_쿠키가_발급되고_단어목록에_접근할_수_있다() throws Exception {
        // 로그인
        var loginResult = mockMvc.perform(post("/login")
                        .param("username", "integrationTester")
                        .param("password", "pw1234"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"))
                .andReturn();

        Cookie sessionCookie = loginResult.getResponse().getCookie("SESSION_ID");
        org.assertj.core.api.Assertions.assertThat(sessionCookie).isNotNull();

        // 발급된 쿠키로 목록 접근
        mockMvc.perform(get("/words").cookie(sessionCookie))
                .andExpect(status().isOk())
                .andExpect(view().name("words/list"));
    }

    @Test
    void 로그인_실패시_에러메시지가_뜬다() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "integrationTester")
                        .param("password", "wrongPassword"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth/login"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    void 로그인후_단어를_등록하고_목록에서_확인한다() throws Exception {
        Cookie sessionCookie = login();

        mockMvc.perform(post("/words")
                        .cookie(sessionCookie)
                        .param("vocabulary", "integration")
                        .param("meaning", "통합의")
                        .param("exampleSentence", "This is an integration test."))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));

        mockMvc.perform(get("/words").cookie(sessionCookie))
                .andExpect(status().isOk())
                .andExpect(model().attribute("words",
                        org.hamcrest.Matchers.hasSize(1)));
    }

    @Test
    void 빈값으로_등록시_검증에러로_다시_폼이_렌더링된다() throws Exception {
        Cookie sessionCookie = login();

        mockMvc.perform(post("/words")
                        .cookie(sessionCookie)
                        .param("vocabulary", "")
                        .param("meaning", "")
                        .param("exampleSentence", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("words/form"));
    }

    @Test
    void 단어_수정과_삭제가_정상_동작한다() throws Exception {
        Cookie sessionCookie = login();

        Word word = wordRepository.save(Word.builder()
                .vocabulary("before")
                .meaning("수정 전")
                .exampleSentence("before sentence")
                .build());

        // 수정
        mockMvc.perform(post("/words/{id}/edit", word.getId())
                        .cookie(sessionCookie)
                        .param("vocabulary", "after")
                        .param("meaning", "수정 후")
                        .param("exampleSentence", "after sentence"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));

        Word updated = wordRepository.findById(word.getId()).orElseThrow();
        org.assertj.core.api.Assertions.assertThat(updated.getVocabulary()).isEqualTo("after");

        // 삭제
        mockMvc.perform(post("/words/{id}/delete", word.getId())
                        .cookie(sessionCookie))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/words"));

        org.assertj.core.api.Assertions.assertThat(wordRepository.findById(word.getId())).isEmpty();
    }

    @Test
    void 암기여부_토글이_정상_동작한다() throws Exception {
        Cookie sessionCookie = login();

        Word word = wordRepository.save(Word.builder()
                .vocabulary("toggleTest")
                .meaning("토글 테스트")
                .exampleSentence("toggle sentence")
                .build());

        org.assertj.core.api.Assertions.assertThat(word.isMemorized()).isFalse();

        mockMvc.perform(post("/words/{id}/toggle", word.getId())
                        .cookie(sessionCookie))
                .andExpect(status().is3xxRedirection());

        Word toggled = wordRepository.findById(word.getId()).orElseThrow();
        org.assertj.core.api.Assertions.assertThat(toggled.isMemorized()).isTrue();
    }

    @Test
    void 검색어로_필터링된_목록을_조회한다() throws Exception {
        Cookie sessionCookie = login();

        wordRepository.save(Word.builder().vocabulary("apple").meaning("사과").exampleSentence("I eat an apple.").build());
        wordRepository.save(Word.builder().vocabulary("banana").meaning("바나나").exampleSentence("I eat a banana.").build());

        mockMvc.perform(get("/words").cookie(sessionCookie).param("keyword", "apple"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("words", org.hamcrest.Matchers.hasSize(1)));
    }

    private Cookie login() throws Exception {
        var result = mockMvc.perform(post("/login")
                        .param("username", "integrationTester")
                        .param("password", "pw1234"))
                .andReturn();
        return result.getResponse().getCookie("SESSION_ID");
    }
}
