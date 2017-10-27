package java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import dto.Person;

public class ComparingDemo
{

    public static void main(String[] args)
    {
        List<Person> personList = Person.getPersonList();

        // using comparator to sort
        Comparator<Person> personAscendingComparator = Comparator.comparingInt(Person::getAge);
        Comparator<Person> personDescendingComparator = Comparator.comparingInt(Person::getAge).reversed();

        Comparator<Person> personNameAscendingComparator = Comparator.comparing(Person::getName);

        Function<Person, Integer> personIntegerAscendingFunctionMethod = Person::getAge;
        Function<Person, Integer> personIntegerAscendingFunction = p -> p.getAge();
        Comparator<Person> personIntegerDescendingFunction = Comparator.comparing(personIntegerAscendingFunction).reversed();

        System.out.println("\nComparing Ascending");
        personList.stream()
                .sorted(personAscendingComparator)
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));

        System.out.println("\nComparing Descending");
        personList.stream()
                .sorted(personDescendingComparator)
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));


        System.out.println("\nFunction and Comparing Ascending");
        personList.stream()
                .sorted(Comparator.comparing(personIntegerAscendingFunction))
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));

        System.out.println("\nFunction and Comparing Descending");
        personList.stream()
                .sorted(personIntegerDescendingFunction)
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));

        System.out.println("\nManual Comparison by 2 fields");
        personList.stream()
                .sorted(new Comparator<Person>()
                {

                    public int compare(Person o1, Person o2)
                    {

                        String x1 = o1.getName();
                        String x2 = o2.getName();
                        int sComp = x1.compareTo(x2);

                        if (sComp != 0)
                            return sComp;
                        else
                        {
                            Integer xx1 = o1.getAge();
                            Integer xx2 = o2.getAge();
                            return xx1.compareTo(xx2);
                        }
                    }
                })
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));

        System.out.println("\nStream Comparison by 2 fields");
        personList.stream()
                .sorted(personNameAscendingComparator.thenComparing(personAscendingComparator.reversed()))
                .forEach(p -> System.out.println(p.getName() + "  -- " + p.getAge()));

        

    }















    private static void order(List<Person> persons)
    {

        Collections.sort(persons, new Comparator()
        {

            public int compare(Object o1, Object o2)
            {

                String x1 = ((Person) o1).getName();
                String x2 = ((Person) o2).getName();
                int sComp = x1.compareTo(x2);

                if (sComp != 0)
                {
                    return sComp;
                }
                else
                {
                    Integer xx1 = ((Person) o1).getAge();
                    Integer xx2 = ((Person) o2).getAge();
                    return xx1.compareTo(xx2);
                }
            }
        });
    }
}
