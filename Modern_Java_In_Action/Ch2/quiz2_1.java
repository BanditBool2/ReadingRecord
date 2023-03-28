package org.example.Ch2;

import java.util.Arrays;
import java.util.List;

public class quiz2_1 {
    public static void prettyPrintApple(List<Apple> inventory, ApplePredicate p){
        for(Apple apple: inventory){
            String output = p.print(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        ApplePredicate PrettyApplePredicate = new PrettyApplePredicate();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
        prettyPrintApple(inventory, PrettyApplePredicate);
    }
}

interface ApplePredicate{
    String print(Apple apple);
}
class PrettyApplePredicate implements ApplePredicate{

    @Override
    public String print(Apple apple) {
        return "Apple's weight is "+ apple.getWeight() ;
    }
}

class Apple {
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