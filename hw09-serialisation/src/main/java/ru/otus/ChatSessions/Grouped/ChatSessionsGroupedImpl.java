package ru.otus.ChatSessions.Grouped;

import ru.otus.ChatSessions.Basic.ChatSessionBasic;
import ru.otus.ChatSessions.Basic.ChatSessionsBasicImpl;
import ru.otus.ChatSessions.Basic.MembersBasic;
import ru.otus.ChatSessions.Basic.MessagesBasic;
import ru.otus.ChatSessions.ChatSessions;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ChatSessionsGroupedImpl implements ChatSessions, Serializable {

    private ChatSessionsBasicImpl chatSessionsBasic;

    @JsonProperty("chat_sessions")
    private ArrayList<ChatSessionGrouped> chatSessions;

    @JsonCreator
    public ChatSessionsGroupedImpl(@JsonProperty("chat_sessions") ArrayList<ChatSessionGrouped> chatSessions) {
        this.chatSessions = chatSessions;
    }

    public ChatSessionsGroupedImpl(ChatSessionsBasicImpl chatSessionsBasic) {
        this.chatSessionsBasic = chatSessionsBasic;
        this.chatSessions = new ArrayList<>();
        for (ChatSessionBasic chatSessionBasic : chatSessionsBasic.getChatSessions()) {
            ArrayList<MembersGrouped> membersGrouped = new ArrayList<>();
            for (MembersBasic membersBasic : chatSessionBasic.getMembers()
            ) {
                membersGrouped.add(new MembersGrouped(membersBasic.getLast()));
            }
            ArrayList<MessagesGrouped> messagesGrouped = new ArrayList<>();
            for (MessagesBasic messagesBasic : chatSessionBasic.getMessages()
            ) {
                messagesGrouped.add(new MessagesGrouped(messagesBasic.getBelongNumber(), messagesBasic.getSendDate(), messagesBasic.getText()));
            }
            messagesGrouped = (ArrayList<MessagesGrouped>) messagesGrouped.stream().sorted(Comparator.comparing(MessagesGrouped::getDate).reversed()).collect(Collectors.toList());
            String chatIdentifier = chatSessionBasic.getChatIdentifier();
            ChatSessionGrouped chatSessionsFind = getChatSessionGroupedByChatIdentifier(chatIdentifier);
            if (chatSessionsFind == null) {
                chatSessionsFind = new ChatSessionGrouped(chatIdentifier, membersGrouped, messagesGrouped);
                chatSessions.add(chatSessionsFind);
            } else {
                chatSessionsFind.setMembersGrouped(membersGrouped);
                chatSessionsFind.setMessagesGrouped(messagesGrouped);
            }
        }
    }

    @Override
    public String toString() {
        return "ChatSessions{" + "chatSessions=" + chatSessions + "\n" + '}';
    }

    private ChatSessionGrouped getChatSessionGroupedByChatIdentifier(String chatIdentifier) {
        if (chatSessions == null) {
            return null;
        }
        for (ChatSessionGrouped chatSessionGrouped : chatSessions) {
            if (chatSessionGrouped.getChatIdentifier() == chatIdentifier) {
                return chatSessionGrouped;
            }
        }
        return null;
    }

}
