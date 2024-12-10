package com.ai.translator.translator.controller;

import com.ai.translator.translator.model.TranslationRequest;
import com.ai.translator.translator.model.TranslationResponse;
import com.ai.translator.translator.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translate")
@RequiredArgsConstructor
public class TranslatorController {

    private final TranslationService translationService;

    @PostMapping
    public ResponseEntity<TranslationResponse> translate(@RequestBody TranslationRequest request){
        TranslationResponse translationResponse= translationService.translate(request);

        return ResponseEntity.ok(translationResponse);
    }

}
