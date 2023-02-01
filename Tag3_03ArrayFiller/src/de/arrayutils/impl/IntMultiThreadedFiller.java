package de.arrayutils.impl;

import de.arrayutils.IntArrayFiller;
import de.generator.Generator;
import de.generator.GeneratorFactory;
import de.generator.IntGenerator;
import de.generator.IntGerneratorFactory;
import de.generator.impl.IntRandomNumberGeneratorFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IntMultiThreadedFiller implements IntArrayFiller {
    private final IntGerneratorFactory generatorFactory;
    private final int threadCount;
    private ExecutorService service;

    private int[] arryToFill;

    public IntMultiThreadedFiller(IntGerneratorFactory generatorFactory, int threadCount) {
        this.generatorFactory = generatorFactory;
        this.threadCount = threadCount;
    }

    @Override
    public void fill(int[] arryToFill) {
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
        System.out.println("SEgmentsize: " + segmentSize);
        service.execute(new FillArrayWorker(generatorFactory.create(), start, end));
    }

    class FillArrayWorker implements  Runnable {

        private final IntGenerator generator;
        private final int start;
        private final int end;

        public FillArrayWorker(IntGenerator generator, int start, int end) {
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
