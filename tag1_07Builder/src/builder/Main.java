package builder;

public class Main {
    public static void main(String[] args) {

        Person p = Person.builder().vorname("Fritz").build();

        System.out.println(p);
    }
}