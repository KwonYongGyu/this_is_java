package com.kyg.toeicvocabulary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class WordRequest {

    @NotBlank(message = "단어를 입력해주세요.")
    @Size(max = 100, message = "단어는 100자를 넘을 수 없습니다.")
    private String vocabulary;

    @NotBlank(message = "뜻을 입력해주세요.")
    @Size(max = 255, message = "뜻은 255자를 넘을 수 없습니다.")
    private String meaning;

    @NotBlank(message = "예문을 입력해주세요.")
    @Size(max = 500, message = "예문은 500자를 넘을 수 없습니다.")
    private String exampleSentence;
}
