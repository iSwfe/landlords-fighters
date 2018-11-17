package com.iswfe.games.landlords_fighters.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebSocketController {

    @GetMapping("/webSocket/test")
    @ResponseBody
    public String test() {
        System.out.println("port = ...");
        return "request finish";
    }
}
