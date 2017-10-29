package dto;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    private int age;

    private String name;

    public Person( String name, int age)
    {
        this.age = age;
        this.name = name;
    }

    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Jack", 12));
        personList.add(new Person("Jack", 25));
        personList.add(new Person("Mohan", 45));
        personList.add(new Person("Kannan", 8));
        personList.add(new Person("Bala", 11));
        personList.add(new Person("Simple", 68));
        personList.add(new Person("Zomato", 18));

        return personList;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
