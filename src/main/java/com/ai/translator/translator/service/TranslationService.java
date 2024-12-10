package com.ai.translator.translator.service;

import com.ai.translator.translator.model.TranslationRequest;
import com.ai.translator.translator.model.TranslationResponse;

public interface TranslationService {
    TranslationResponse translate(TranslationRequest translationRequest);
}
