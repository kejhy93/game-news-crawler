package org.hejnaluk.gamenewscrawler.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hejnaluk.gamenewscrawler.data.*;
import org.hejnaluk.gamenewscrawler.service.HttpRequestExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DummyController {

    @Autowired
    XmlMapper mapper;

    @Autowired
    HttpRequestExecutor httpRequestExecutor;

    @Autowired
    EntryRepository entryRepository;

    Logger logger = LoggerFactory.getLogger(DummyController.class.getName());

    @GetMapping("/")
    public String test() throws IOException {
        URL url = new URL("https://indian-tv.cz/atom.xml");
        String value = httpRequestExecutor.call(url);

        Feed feed = mapper.readValue(value, Feed.class);

        for (EntryXml entryXml : feed.getEntries()) {
            logger.debug("Entry before saving title=" + entryXml.getTitle());
            entryRepository.save(entryXml.toEntryDb());
        }

        return "value";
    }

    @GetMapping(value="/all", produces={"application/json"})
    public List<EntryJson> getAllRecords() {
        List<EntryDb> entries = new ArrayList<>();
        entryRepository.findAll().forEach(entries::add);
        logger.debug("Length of the list=" + entries.size());
        for (EntryDb entryDb : entries) {
            logger.debug("Entry found title=" + entryDb.getTitle());
        }

        return entries.stream().map(EntryDb::toEntryJson).collect(Collectors.toList());
    }
}
