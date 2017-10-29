package java8;

import java.util.List;

import dto.Person;

public class FindStreamDemo
{
    public static void main(String[] args) throws Exception
    {
        List<Person> personList = Person.getPersonList();

        System.out.println(personList);

        String[] name = new String[1];
        personList.stream()
                .filter(person -> person.getName().equals("Bob"))
                .findFirst()
                .ifPresent(person -> name[0] = person.getName());

        System.out.println(name[0]);

        Person p = personList.stream()
                .filter(person -> person.getName().equals("Bala"))
                .findFirst()// if finds Bala, return Bala
                .orElse(null); //else return null
        System.out.println(p);

        personList.stream()
                .filter(person -> person.getName().equals("Balaw"))
                .findFirst()// if finds Bala, return Bala
                .orElseThrow(() -> new Exception("Name not found")); //else throw exception


    }
}
