package java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysStreamDemo
{

    public static void main(String[] args)
    {
        String[] names = {"XYZ", "ABC", "JACK"};

        int[] age = {1, 12, 45};

        Arrays.stream(names).forEach(System.out::println);

        System.out.println("Sum: " + Arrays.stream(age).sum());
        System.out.println("Min: " + Arrays.stream(age).min());
        System.out.println("Average as Double: " + Arrays.stream(age).average().getAsDouble());

        System.out.println(IntStream.range(1,5).reduce((a,b) ->{
            System.out.println("a: " + a + "\t b: " + b);
            return a + b;
        }).getAsInt());


    }
}
