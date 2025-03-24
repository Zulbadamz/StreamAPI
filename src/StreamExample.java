import java.util.*;
import java.util.stream.*;

public class StreamExample {

    public static void main(String[] args) {
        // Task 2: Initialize a list of integers from 1 to 10
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Task 3: Intermediate Operations
        System.out.println("Even numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);

        System.out.println("Squares of numbers:");
        numbers.stream()
               .map(n -> n * n)
               .forEach(System.out::println);

        System.out.println("Cubes of odd numbers:");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .map(n -> n * n * n)
               .forEach(System.out::println);

        // Task 4: Terminal Operations
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even numbers collected: " + evenNumbers);

        // Task 5: Advanced Stream Operations
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        System.out.println("Flattened list:");
        listOfLists.stream()
                   .flatMap(List::stream)
                   .forEach(System.out::println);

        Map<String, List<Integer>> grouped = numbers.stream()
                                                    .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println("Grouped by even and odd: " + grouped);

        // Task 6: Stream with Custom Objects
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 22),
            new Person("Charlie", 28)
        );

        System.out.println("People older than 25:");
        people.stream()
              .filter(p -> p.getAge() > 25)
              .map(Person::getName)
              .forEach(System.out::println);

        Person oldestPerson = people.stream()
                                    .max(Comparator.comparingInt(Person::getAge))
                                    .orElseThrow(() -> new RuntimeException("No people in the list"));
        System.out.println("Oldest person: " + oldestPerson.getName());
    }
}
