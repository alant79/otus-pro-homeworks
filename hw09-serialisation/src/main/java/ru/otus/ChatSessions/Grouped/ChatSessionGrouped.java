package ru.otus.ChatSessions.Grouped;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatSessionGrouped implements Serializable {

    @JsonProperty("chat_identifier")
    private String chatIdentifier;
    @JsonProperty("members")
    private ArrayList<MembersGrouped> membersGrouped;
    @JsonProperty("messages")
    private ArrayList<MessagesGrouped> messagesGrouped;

    @JsonCreator
    public ChatSessionGrouped(@JsonProperty("chat_identifier") String chatIdentifier,
                              @JsonProperty("members") ArrayList<MembersGrouped> membersGrouped,
                              @JsonProperty("messages") ArrayList<MessagesGrouped> messagesGrouped
    ) {
        this.chatIdentifier = chatIdentifier;
        this.membersGrouped = membersGrouped;
        this.messagesGrouped = messagesGrouped;
    }


    @Override
    public String toString() {
        return "ChatSessionGrouped{" +
                "chatIdentifier='" + chatIdentifier + '\'' +
                ", members='" + membersGrouped + '\'' +
                ", messages='" + messagesGrouped + '\'' +
                '}';
    }

    public String getChatIdentifier() {
        return chatIdentifier;
    }

    public void setMembersGrouped(ArrayList<MembersGrouped> membersGrouped) {
        this.membersGrouped = membersGrouped;
    }

    public void setMessagesGrouped(ArrayList<MessagesGrouped> messagesGrouped) {
        this.messagesGrouped = messagesGrouped;
    }
}
