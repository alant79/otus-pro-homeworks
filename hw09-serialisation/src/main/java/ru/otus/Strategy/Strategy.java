package ru.otus.Strategy;

import ru.otus.ChatSessions.ChatSessions;

import java.io.IOException;

public interface Strategy {
    ChatSessions upload(Class<? extends ChatSessions> cls, String fileName) throws IOException;

    void unload(ChatSessions chatSessions, String fileName) throws IOException;
}
