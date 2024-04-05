package com.tweets.api.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Controller {
    @GetMapping("/api/test")
    public String getString(){
        String url = "http://191.101.18.138:9200";
        WebClient.Builder builder = WebClient.builder();
        String response = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

}
