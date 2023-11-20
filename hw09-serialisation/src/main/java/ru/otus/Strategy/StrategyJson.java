package ru.otus.Strategy;

import ru.otus.ChatSessions.ChatSessions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class StrategyJson implements Strategy {
    @Override
    public ChatSessions upload(Class<? extends ChatSessions> cls, String fileName) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        ChatSessions chatSessions = (ChatSessions) objectMapper.readValue(file, cls);
        return chatSessions;
    }

    @Override
    public void unload(ChatSessions chatSessions, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(chatSessions);
        Files.write(new File(fileName).toPath(), Arrays.asList(json), StandardOpenOption.WRITE);
    }
}
