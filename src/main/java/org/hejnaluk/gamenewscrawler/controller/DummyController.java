package org.hejnaluk.gamenewscrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {

    @GetMapping("/")
    public void test() {

    }

}
