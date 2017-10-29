package java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterateDemo
{
    public static void main(String[] args)
    {
        Stream<Integer> limit = Stream.iterate(0, num -> {
            System.out.println("Num:" + num);
            return num + 1;
        })
        .filter(num -> num % 2 == 0)
        .limit(50);
        long itrCount = limit.collect(Collectors.counting());

        System.out.println("ItrCount: " + itrCount);

    }

}
