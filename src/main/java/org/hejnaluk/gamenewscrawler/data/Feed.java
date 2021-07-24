package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Feed {
    @JacksonXmlProperty(localName = "entry")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
