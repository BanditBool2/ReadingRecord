package org.example.Ch5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class p187_5_7_3_pythagorean {
    public static void main(String[] args) {
//        IntStream.rangeClosed(1,100).boxed()
//                .flatMap(a ->
//                        IntStream.rangeClosed(a,100)
//                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a+b*b)})
//                ).forEach(i-> System.out.println(Arrays.toString(i)));

        IntStream.rangeClosed(1,100)
                .boxed()
                .flatMap(a->IntStream.rangeClosed(a,100)
                    .mapToObj(b->new double[]{a, b, Math.sqrt(a*a + b*b)})
                        .filter(t -> t[2] % 1 == 0)
                        .map(int[].class::cast)
                )
                .forEach(i-> System.out.println(Arrays.toString(i)));
    }
}
