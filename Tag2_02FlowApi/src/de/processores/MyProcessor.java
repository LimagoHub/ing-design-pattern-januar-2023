package de.processores;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<String, Integer> {

    private Flow.Subscription subscription;
    private final Function<String, Integer> function;

    public MyProcessor(Function<String, Integer> function) {
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        try {
            int toSend = function.apply(item);
            submit(toSend);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        this.closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
    }
}
