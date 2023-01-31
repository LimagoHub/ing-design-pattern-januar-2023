package de.subscriber;

import java.util.concurrent.Flow;

public class EndSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) { // Feuert bei registrierung
        this.subscription = subscription;
        subscription.request(1); // Signalisiere bereitschaft zum Empfangen einer Nachricht
    }

    @Override
    public void onNext(T item) {
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Publisher kaputt");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Publisher hat fertig!!!");
    }
}
