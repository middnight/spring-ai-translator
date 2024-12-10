package com.ai.translator.translator.service;

import com.ai.translator.translator.model.TemplatesProvider;
import com.ai.translator.translator.model.TranslationRequest;
import com.ai.translator.translator.model.TranslationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.autoconfigure.ollama.OllamaChatProperties;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;


@Service
@RequiredArgsConstructor
public class Llama3TranslationService implements TranslationService{

    private final OllamaChatModel chatModel;
    private final OllamaChatProperties chatProperties;
    private final TemplatesProvider templatesProvider;

    private static final String TEMPLATE_NAME ="llama3-translation";
    @Override
    public TranslationResponse translate(TranslationRequest translationRequest) {

        ST chat= templatesProvider.getTemplate(TEMPLATE_NAME);
        chat.add("to",translationRequest.getTo());
        chat.add("from",translationRequest.getFrom());
        chat.add("request",translationRequest.getRequest());

       ChatResponse chatResponse = chatModel.call(new Prompt(chat.render(), OllamaOptions.create()
                .withModel("llama3")
                .withTemperature(0.4f)));

       String response=chatResponse.getResult().getOutput().getContent();
       return new TranslationResponse(response,translationRequest);
    }
}
