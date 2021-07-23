package org.hejnaluk.gamenewscrawler.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hejnaluk.gamenewscrawler.data.Entry;
import org.hejnaluk.gamenewscrawler.data.Feed;
import org.hejnaluk.gamenewscrawler.service.HttpRequestExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@RestController
public class DummyController {

    @GetMapping("/")
    public String test() throws IOException {
        URL url = new URL("https://indian-tv.cz/atom.xml");
        String value = new HttpRequestExecutor().call(url);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Feed feed = xmlMapper.readValue(value, Feed.class);

        for (Entry entry : feed.getEntries()) {
            System.out.println(entry.getId());
        }

        return "value";
    }

}
