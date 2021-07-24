package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "feed")
public class Entry {

    @JacksonXmlProperty(localName = "id")
    String id;

    @JacksonXmlProperty(localName = "title")
    String title;

    @JsonGetter("id")
    public String getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @JsonSetter("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
