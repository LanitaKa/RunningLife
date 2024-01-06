import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("A person was born:");
        System.out.println("Gender: " + person.gender);
        System.out.println("Budget: " + person.budget);
        System.out.println("IQ: " + person.iq);
        System.out.println("Life Expectancy: " + person.lifeExpectancy);

        person.runLife();
    }
}