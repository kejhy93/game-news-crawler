package org.hejnaluk.gamenewscrawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/")
    public String test() {
        return "Hello World";
    }

}
