package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.data.redis.core.RedisHash;


@JacksonXmlRootElement(localName = "feed")
public class EntryXml {

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

    public EntryDb toEntryDb() {
        return new EntryDb(id, title);
    }
}
