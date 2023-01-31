package de.processors;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<Integer> implements Processor<String, Integer>{

	private Subscription subscription;
	private final Function<String, Integer> function;
	
	
	public MyProcessor(final Function<String,Integer> function) {
		this.function = function; 
	}
	
	

	@Override
	public void onSubscribe(Subscription subscription) {
		
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
