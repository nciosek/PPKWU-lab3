package com.ppwku.lab3.controller;

import com.ppwku.lab3.service.Html2ICSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Html2ICSController {

    private Html2ICSService html2ICSService;

    @GetMapping("/html2ics/{link}")
    public String convert(@PathVariable String link){

        return "convert";
    }

}
