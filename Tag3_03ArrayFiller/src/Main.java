import de.arrayutils.ArrayFiller;
import de.arrayutils.IntArrayFiller;
import de.arrayutils.impl.IntMultiThreadedFiller;
import de.arrayutils.impl.MultiThreadedArrayFiller;
import de.arrayutils.impl.SimpleArrayFiller;
import de.benchmark.BenchmarkProxy;
import de.generator.Generator;
import de.generator.GeneratorFactory;
import de.generator.IntGerneratorFactory;
import de.generator.impl.IntRandomNumberGeneratorFactory;
import de.generator.impl.RandomNumberGenerator;
import de.generator.impl.RandomNumberGeneratorFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    private final int feld[] = new int[Integer.MAX_VALUE/2];

    public static void main(String[] args) {

        new Main().run();
    }

    private void run() {
        var availableProcessors = Runtime.getRuntime().availableProcessors();

        for(int threadCount = 1; threadCount < availableProcessors + 1; threadCount ++) {
            IntGerneratorFactory generator = new IntRandomNumberGeneratorFactory();
            IntArrayFiller filler = new IntMultiThreadedFiller(generator, threadCount);
            filler = (IntArrayFiller) BenchmarkProxy.newInstance(filler);


            filler.fill(feld);
        }






    }
}