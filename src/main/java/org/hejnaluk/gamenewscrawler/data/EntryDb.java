package org.hejnaluk.gamenewscrawler.data;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Entry")
public class EntryDb {
    String id;
    String title;

    public EntryDb(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EntryJson toEntryJson() {
        return new EntryJson(id, title);
    }
}