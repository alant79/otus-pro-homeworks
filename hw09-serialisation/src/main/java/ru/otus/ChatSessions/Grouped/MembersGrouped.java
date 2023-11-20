package ru.otus.ChatSessions.Grouped;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MembersGrouped implements Serializable {
    @JsonProperty("last")
    private final String last;

    @JsonCreator
    public MembersGrouped(@JsonProperty("last") String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Members{" +
                "last='" + last + '\'' +
                '}';
    }

}
