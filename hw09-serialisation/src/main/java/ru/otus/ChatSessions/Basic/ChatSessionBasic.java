package ru.otus.ChatSessions.Basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ChatSessionBasic {
    @JsonProperty("chat_id")
    private final int chatId;
    @JsonProperty("chat_identifier")
    private final String chatIdentifier;
    @JsonProperty("display_name")
    private final String displayName;
    @JsonProperty("is_deleted")
    private final int isDeleted;
    @JsonProperty("members")
    private final ArrayList<MembersBasic> members;
    @JsonProperty("messages")
    private final ArrayList<MessagesBasic> messages;

    @JsonCreator
    public ChatSessionBasic(@JsonProperty("chat_id") int chatId,
                            @JsonProperty("chat_identifier") String chatIdentifier,
                            @JsonProperty("display_name") String displayName,
                            @JsonProperty("is_deleted") int isDeleted,
                            @JsonProperty("members") ArrayList<MembersBasic> members,
                            @JsonProperty("messages") ArrayList<MessagesBasic> messages
    ) {
        this.chatId = chatId;
        this.chatIdentifier = chatIdentifier;
        this.displayName = displayName;
        this.isDeleted = isDeleted;
        this.members = members;
        this.messages = messages;

    }

    @Override
    public String toString() {
        return "ChatSessionsBasic{" +
                "chatId=" + chatId +
                ", chatIdentifier='" + chatIdentifier + '\'' +
                ", displayName='" + displayName + '\'' +
                ", isDeleted=" + isDeleted + "\n" +
                ", members=" + members + "\n" +
                ", messages=" + messages +
                '}';
    }

    public String getChatIdentifier() {
        return chatIdentifier;
    }

    public ArrayList<MembersBasic> getMembers() {
        return members;
    }

    public ArrayList<MessagesBasic> getMessages() {
        return messages;
    }
}
