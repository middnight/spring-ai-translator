package com.ai.translator.translator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationResponse {

    String to;
    String from;
    String request;
    String response;


    public TranslationResponse(String response, TranslationRequest translationRequest){
        this.response= response;
        this.request=translationRequest.getRequest();
        this.to=translationRequest.getTo();
        this.from=translationRequest.getFrom();
    }
}
