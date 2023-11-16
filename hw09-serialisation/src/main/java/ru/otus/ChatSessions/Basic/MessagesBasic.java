package ru.otus.ChatSessions.Basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessagesBasic {
    @JsonProperty("ROWID")
    private final int rowId;
    @JsonProperty("attributedBody")
    private final String attributedBody;
    @JsonProperty("belong_number")
    private final String belongNumber;
    @JsonProperty("date")
    private final long date;
    @JsonProperty("date_read")
    private final long dateRead;
    @JsonProperty("guid")
    private final String guid;
    @JsonProperty("handle_id")
    private final int handleId;
    @JsonProperty("has_dd_results")
    private final int hasDdResults;
    @JsonProperty("is_deleted")
    private final int isDeleted;
    @JsonProperty("is_from_me")
    private final int isFromMe;
    @JsonProperty("send_date")
    private final String sendDate;
    @JsonProperty("send_status")
    private final int sendStatus;
    @JsonProperty("service")
    private final String service;
    @JsonProperty("text")
    private final String text;

    @JsonCreator
    public MessagesBasic(@JsonProperty("ROWID") int rowId,
                         @JsonProperty("attributedBody") String attributedBody,
                         @JsonProperty("belong_number") String belongNumber,
                         @JsonProperty("date") long date,
                         @JsonProperty("date_read") long dateRead,
                         @JsonProperty("guid") String guid,
                         @JsonProperty("handle_id") int handleId,
                         @JsonProperty("has_dd_results") int hasDdResults,
                         @JsonProperty("is_deleted") int isDeleted,
                         @JsonProperty("is_from_me") int isFromMe,
                         @JsonProperty("send_date") String sendDate,
                         @JsonProperty("send_status") int sendStatus,
                         @JsonProperty("service") String service,
                         @JsonProperty("text") String text) {
        this.rowId = rowId;
        this.attributedBody = attributedBody;
        this.belongNumber = belongNumber;
        this.date = date;
        this.dateRead = dateRead;
        this.guid = guid;
        this.handleId = handleId;
        this.hasDdResults = hasDdResults;
        this.isDeleted = isDeleted;
        this.isFromMe = isFromMe;
        this.sendDate = sendDate;
        this.sendStatus = sendStatus;
        this.service = service;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "rowId=" + rowId +
                ", attributedBody='" + attributedBody + '\'' +
                ", belongNumber='" + belongNumber + '\'' +
                ", date=" + date +
                ", dateRead=" + dateRead +
                ", guid='" + guid + '\'' +
                ", handleId=" + handleId +
                ", hasDdResults=" + hasDdResults +
                ", isDeleted=" + isDeleted +
                ", isFromMe=" + isFromMe +
                ", sendDate='" + sendDate + '\'' +
                ", sendStatus=" + sendStatus +
                ", service='" + service + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getBelongNumber() {
        return belongNumber;
    }

    public String getSendDate() {
        return sendDate;
    }

    public String getText() {
        return text;
    }
}
