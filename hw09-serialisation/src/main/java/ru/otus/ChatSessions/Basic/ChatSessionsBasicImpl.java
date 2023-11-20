package ru.otus.ChatSessions.Basic;

import ru.otus.ChatSessions.ChatSessions;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ChatSessionsBasicImpl implements ChatSessions {


    @JsonProperty("chat_sessions")
    private final ArrayList<ChatSessionBasic> chatSessions;

    @JsonCreator
    public ChatSessionsBasicImpl(@JsonProperty("chat_sessions") ArrayList<ChatSessionBasic> chatSessions) {
        this.chatSessions = chatSessions;
    }

    @Override
    public String toString() {
        return "ChatSessions{" +
                "chatSessions=" + chatSessions + "\n" +
                '}';
    }

    public ArrayList<ChatSessionBasic> getChatSessions() {
        return chatSessions;
    }
}
