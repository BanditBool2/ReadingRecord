package org.example.Ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Quiz5_2 {
    public static void main(String[] args) {
        //문제1
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> newNums = nums.stream().map(i -> i*i).collect(toList());
        System.out.println(newNums);

        System.out.println("\n 문제 2 ");
        //문제2 [{1,3}, {1,4}, {2,3}, {2,4} ...]
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);
        List<int[]> newNum2;
        newNum2 = nums1.stream()
                .flatMap(i -> nums2.stream()
                        .map( j-> new int[]{i, j} ) )
                .collect(toList());

        newNum2.forEach(i -> System.out.print(Arrays.toString(i)));

        System.out.println("\n\n 문제 3 ");
        //문제3 합이 3으로 나누어떨어지는 쌍만 반환
        newNum2 = newNum2.stream().filter(i -> Arrays.stream(i).sum() % 3 == 0).collect(toList());
        newNum2.forEach(i -> System.out.print(Arrays.toString(i)));
    }
}
