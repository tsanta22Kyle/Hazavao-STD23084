package com.hei.project.endpoint.rest.controller.health;


import com.hei.project.service.ChatGptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hazavao")@AllArgsConstructor
public class ChatGptController {

    private final ChatGptService chatGptService;


    @GetMapping
    public String getDefinition(@RequestParam("teny") String teny) {
        return chatGptService.definiteWord(teny);
    }

}
