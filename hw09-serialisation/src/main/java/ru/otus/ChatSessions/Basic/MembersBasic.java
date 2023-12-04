package ru.otus.ChatSessions.Basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MembersBasic {
    @JsonProperty("first")
    private final String first;
    @JsonProperty("handle_id")
    private final int handleId;
    @JsonProperty("image_path")
    private final String imagePath;
    @JsonProperty("last")
    private final String last;
    @JsonProperty("middle")
    private final String middle;
    @JsonProperty("phone_number")
    private final String phoneNumber;
    @JsonProperty("service")
    private final String service;
    @JsonProperty("thumb_path")
    private final String thumbPath;

    @JsonCreator
    public MembersBasic(@JsonProperty("first") String first,
                        @JsonProperty("handle_id") int handleId,
                        @JsonProperty("image_path") String imagePath,
                        @JsonProperty("last") String last,
                        @JsonProperty("middle") String middle,
                        @JsonProperty("phone_number") String phoneNumber,
                        @JsonProperty("service") String service,
                        @JsonProperty("thumb_path") String thumbPath
    ) {
        this.first = first;
        this.handleId = handleId;
        this.imagePath = imagePath;
        this.last = last;
        this.middle = middle;
        this.phoneNumber = phoneNumber;
        this.service = service;
        this.thumbPath = thumbPath;

    }

    @Override
    public String toString() {
        return "Members{" +
                "first='" + first + '\'' +
                ", handleId=" + handleId +
                ", imagePath='" + imagePath + '\'' +
                ", last='" + last + '\'' +
                ", middle='" + middle + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", service='" + service + '\'' +
                ", thumbPath='" + thumbPath + '\'' +
                '}';
    }

    public String getLast() {
        return last;
    }
}
