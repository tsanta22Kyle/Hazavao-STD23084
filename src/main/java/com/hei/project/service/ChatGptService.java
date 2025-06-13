package com.hei.project.service;


import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatGptService {

    private final OpenAiService openAiService;

    public ChatGptService(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String definiteWord(String mot) {
        ChatMessage systemMessage = new ChatMessage("system", "Mamorona famaritana tsotra amin'ny teny malagasy.");
        ChatMessage userMessage = new ChatMessage("user", "Hazavao ny teny: " + mot);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(systemMessage, userMessage))
                .temperature(0.7)
                .maxTokens(100)
                .build();

        ChatCompletionResult result = openAiService.createChatCompletion(request);
        return result.getChoices().get(0).getMessage().getContent().trim();
    }
}

