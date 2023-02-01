package app;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> liste = List.of("eins","zwei","drei");

        Iterator<String> it = liste.iterator();

        while(it.hasNext())
            System.out.println(it.next());

        it.forEachRemaining(System.out::println);

        System.out.println("Hello world!");
    }
}