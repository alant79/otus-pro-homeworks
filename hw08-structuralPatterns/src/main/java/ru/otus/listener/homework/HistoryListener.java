package ru.otus.listener.homework;

import ru.otus.listener.Listener;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;

import java.util.*;

public class HistoryListener implements Listener, HistoryReader {
    private final Map<Long, Memento> map = new HashMap<>();
    private final DateTimeProvider dateTimeProvider;

    public HistoryListener(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    @Override
    public void onUpdated(Message msg) {
        map.put(msg.getId(), new Memento(msg, dateTimeProvider.getDate()));
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(map.get(id).message());
    }
}
