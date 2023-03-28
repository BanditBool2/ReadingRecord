package org.example.Ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class FilteringApple {
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }


    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        filterApples(inventory, FilteringApple::isHeavyApple);
        filterApples(inventory, FilteringApple::isGreenApple);

        //익명함수로 메소드 정의 없이 구현
        //한번만 사용할 메소드라면 간결하게 사용가능
        //하지만 람다가 길어진다면, 코드가 수행하는 일을 잘 설명할 메서드를 정의하는게 낫다.
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
    }

    private static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }
    }
}