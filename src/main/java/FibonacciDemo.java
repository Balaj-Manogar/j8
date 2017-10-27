import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FibonacciDemo
{
    private static Map<Integer, BigDecimal> cache = new HashMap<>();

    public static void main(String[] args)
    {
        System.out.println("Hello World");
        cache.put(0, new BigDecimal(1));
        cache.put(1, new BigDecimal(1));

        long start = System.nanoTime();
        System.out.println(fib(10));
        long end = System.nanoTime();
        System.out.println((end - start) / 1.0e9);
    }


    public static BigDecimal fib(int pos)
    {
        //pos = (pos > 1) ? (pos - 1) : pos;

        // we don't need to start from 0 and 1 since it is already computed
        IntStream.range(2, pos)
                .forEach(i -> cache.computeIfAbsent(i, ignore ->
                        cache.get(i - 1).add(cache.get(i - 2))));

        return cache.get(pos-1);
    }
}
