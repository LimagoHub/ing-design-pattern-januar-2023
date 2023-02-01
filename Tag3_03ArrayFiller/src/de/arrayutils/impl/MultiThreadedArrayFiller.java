package de.arrayutils.impl;

import de.arrayutils.ArrayFiller;
import de.generator.Generator;
import de.generator.GeneratorFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedArrayFiller <T> implements ArrayFiller<T> {

    private final GeneratorFactory<T> generatorFactory;
    private final int threadCount;
    private ExecutorService service;

    private T[] arryToFill;
    public MultiThreadedArrayFiller(GeneratorFactory<T> generatorFactory, int threadCount) {
        this.generatorFactory = generatorFactory;
        this.threadCount = threadCount;
    }

    @Override
    public void fill(T[] arryToFill) {
        this.arryToFill = arryToFill;
        startExecuterServiceToFillArray();
    }

    private void startExecuterServiceToFillArray() {
        try {
            service = Executors.newFixedThreadPool(threadCount);
            startWorker();
            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void startWorker() {
        for(int aktThread = 0; aktThread < threadCount; aktThread ++) {
            startSingleWorker(aktThread);
        }
    }

    private void startSingleWorker(final int aktThread) {
       final int segmentSize = arryToFill.length / threadCount;
       final int start = aktThread * segmentSize;
       final int end = start + segmentSize;

       service.execute(new FillArrayWorker(generatorFactory.create(), start, end));
    }

    class FillArrayWorker implements  Runnable {

        private final Generator<T> generator;
        private final int start;
        private final int end;

        public FillArrayWorker(Generator<T> generator, int start, int end) {
            this.generator = generator;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                arryToFill[i] = generator.next();
            }
        }
    }
}
