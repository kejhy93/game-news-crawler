package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


public class EntryJson {

    @JsonProperty(value = "id")
    String id;

    @JsonProperty(value = "title")
    String title;

    @JsonCreator
    public EntryJson(@JsonProperty(value = "id") String id,
                     @JsonProperty(value = "title") String title) {
        this.id = id;
        this.title = title;
    }

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
