package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Feed {
    @JacksonXmlProperty(localName = "entry")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<EntryXml> entries;

    public List<EntryXml> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryXml> entries) {
        this.entries = entries;
    }
}
