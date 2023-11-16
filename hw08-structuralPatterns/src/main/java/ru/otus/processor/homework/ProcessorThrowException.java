package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;


public class ProcessorThrowException implements Processor {
    @Override
    public Message process(Message message) {
        setTimeout(() -> { throw new RuntimeException(); }, 2000);
        return null;
    }

    private static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

}
