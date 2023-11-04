package ru.otus.Strategy;

import ru.otus.ChatSessions.ChatSessions;

import java.io.*;

public class StrategyBinary implements Strategy {
    @Override
    public ChatSessions upload(Class<? extends ChatSessions> cls, String fileName) throws IOException {
        try
                (FileInputStream fileInputStream = new FileInputStream(fileName);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            ChatSessions chatSessions = (ChatSessions) objectInputStream.readObject();
            return chatSessions;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unload(ChatSessions chatSessions, String fileName) throws IOException {
        try
                (FileOutputStream outputStream = new FileOutputStream(fileName);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
            objectOutputStream.writeObject(chatSessions);
        }
    }
}
