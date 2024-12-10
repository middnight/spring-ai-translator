package com.ai.translator.translator.model;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.FileReader;

@Component
public class TemplatesProvider {

private final STGroup group= new STGroupFile("templates/Translations.stg");


public  ST getTemplate(String name){
    return group.getInstanceOf(name);
}


}

