import de.processores.MyProcessor;
import de.subscriber.EndSubscriber;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception{

        List<String> liste = List.of("1","2","drei","4","fuenf","1","2","drei","4","fuenf");

        EndSubscriber<Integer> endSubscriber = new EndSubscriber<>();
        MyProcessor processor = new MyProcessor(Integer::valueOf);

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        publisher.subscribe(processor);
        processor.subscribe(endSubscriber);

        liste.forEach(publisher::submit);

        publisher.close();

        ExecutorService service = (ExecutorService) publisher.getExecutor();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);


        System.out.println("Fertisch");
    }
}