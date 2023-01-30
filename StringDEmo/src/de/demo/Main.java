package de.demo;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        StringBuilder s = new StringBuilder("");

        Instant start = Instant.now();
        for (int i = 0; i < 2_000_000; i++) {
            s.append( "a");
        }

        String erg = s.toString();
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(
                duration.toMillis()
        );


        System.out.println("Fertisch");
    }
}