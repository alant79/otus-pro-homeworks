package ru.otus;
import ru.otus.ChatSessions.Basic.ChatSessionsBasicImpl;
import ru.otus.ChatSessions.Grouped.ChatSessionsGroupedImpl;
import ru.otus.ChatSessions.ChatSessions;
import ru.otus.Strategy.Strategy;
import ru.otus.Strategy.StrategyJson;
import ru.otus.Strategy.StrategyBinary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SerializationTest {

    private Strategy strategy;
    private ChatSessions chatSessions;
    private static String FILE_JSON_BASIC = "hw09-serialisation/src/main/resources/sms_basic.json";
    private static String FILE_JSON_GROUPED = "hw09-serialisation/src/main/resources/sms_grouped.json";
    private static String FILE_BINARY = "hw09-serialisation/src/main/resources/sms_grouped.ser";

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(SerializationTest.class);
        logger.info("FROM BASIC FILE JSON");
        SerializationTest serializationTest = new SerializationTest();
        serializationTest.setStrategy(new StrategyJson());
        serializationTest.chatSessions = serializationTest.strategy.upload(ChatSessionsBasicImpl.class, FILE_JSON_BASIC);
        logger.info(String.valueOf(serializationTest.chatSessions));

        logger.info("FROM GROOPED FILE JSON");
        serializationTest.chatSessions = new ChatSessionsGroupedImpl((ChatSessionsBasicImpl) serializationTest.chatSessions);
        serializationTest.strategy.unload(serializationTest.chatSessions, FILE_JSON_GROUPED);
        serializationTest.chatSessions = serializationTest.strategy.upload(ChatSessionsGroupedImpl.class, FILE_JSON_GROUPED);
        logger.info(String.valueOf(serializationTest.chatSessions));

        logger.info("FROM GROOPED FILE BINARY");
        serializationTest.setStrategy(new StrategyBinary());
        serializationTest.strategy.unload(serializationTest.chatSessions, FILE_BINARY);
        serializationTest.chatSessions = serializationTest.strategy.upload(ChatSessionsGroupedImpl.class, FILE_BINARY);
        logger.info(String.valueOf(serializationTest.chatSessions));
    }

    private void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
