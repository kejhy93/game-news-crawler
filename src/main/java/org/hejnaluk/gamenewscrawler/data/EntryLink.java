package org.hejnaluk.gamenewscrawler.data;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class EntryLink {
    List<String> link = new ArrayList<>();

    @JsonCreator
    public EntryLink( @JsonProperty("link") List<String> link) {
        this.link = link;
    }

    @JsonAnyGetter
    public List<String> getLink() {
        return link;
    }

    @JsonAnySetter
    public void manyFoos(String key, String value) {
        link.add(value);
    }
}
