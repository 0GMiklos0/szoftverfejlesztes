package ex1;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.printf("Usage: java %s <number> <number>%n", Main.class.getName());
            System.exit(1);
        }
        IntegerProperty number1 = new SimpleIntegerProperty(Integer.parseInt(args[0]));
        IntegerProperty number2 = new SimpleIntegerProperty(Integer.parseInt(args[1]));
        IntegerBinding sum = (IntegerBinding) Bindings.add(number1, number2);
        System.out.println(sum.get());
    }
}