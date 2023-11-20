package ru.otus.ChatSessions.Grouped;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessagesGrouped implements Serializable {
    @JsonProperty("belong_number")
    private final String belongNumber;
    @JsonProperty("send_date")
    private final String sendDate;
    private final Date date;
    @JsonProperty("text")
    private final String text;

    @JsonCreator
    public MessagesGrouped(@JsonProperty("belong_number") String belongNumber,
                           @JsonProperty("send_date") String sendDate,
                           @JsonProperty("text") String text) {

        this.belongNumber = belongNumber;
        this.sendDate = sendDate;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try {
            this.date = df.parse(sendDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "belongNumber='" + belongNumber + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }
}
