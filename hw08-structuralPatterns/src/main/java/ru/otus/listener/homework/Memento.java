package ru.otus.listener.homework;

import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

record Memento(Message message, LocalDateTime createdAt) {
    Memento(Message message, LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.message = message.toBuilder().field13(correctField13(message)).build();
    }

    private ObjectForMessage correctField13(Message message) {
        ObjectForMessage field13Copy = new ObjectForMessage();
        List<String> dataCopy = new ArrayList<>();
        for (String el:message.getField13().getData()
        ) {
            dataCopy.add(el);
        }
        field13Copy.setData(dataCopy);
        return  field13Copy;
    }
}
