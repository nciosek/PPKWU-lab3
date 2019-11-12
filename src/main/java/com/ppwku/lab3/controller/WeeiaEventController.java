package com.ppwku.lab3.controller;

import com.ppwku.lab3.WeeiaEvent;
import com.ppwku.lab3.service.WeeiaEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("weeiaCalendar")
public class WeeiaEventController {

    @Autowired
    WeeiaEventService weeiaEventService;

    @GetMapping("/{year}/{month}")
    public ResponseEntity generateDecemberCalendar(@PathVariable String year, @PathVariable String month) throws IOException {

        int yearInt;
        int monthInt;
        try{
            yearInt = Integer.parseInt(year);
            monthInt = Integer.parseInt(month);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new WeeiaEvent("400", "Bad request"));
        }
        Resource fileSystemResource = weeiaEventService.getResource(yearInt, monthInt);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/calendar"))
                .body(fileSystemResource);

    }

}
