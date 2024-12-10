package com.ai.translator.translator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationRequest {

    // TODO to & from should be enum to control the supported languages
    String to;
    String from;
    String request;

}
