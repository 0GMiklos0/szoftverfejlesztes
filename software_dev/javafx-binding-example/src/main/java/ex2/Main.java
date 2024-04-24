package ex2;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Main {
    public static void main(String[] args){
        if(args.length != 3){
            System.err.printf("Usage: java %s <number> <number> <number>%n", Main.class.getName());
            System.exit(1);
        }
        IntegerProperty a = new SimpleIntegerProperty(Integer.parseInt(args[0]));
        IntegerProperty b = new SimpleIntegerProperty(Integer.parseInt(args[1]));
        IntegerProperty c = new SimpleIntegerProperty(Integer.parseInt(args[2]));
        BooleanBinding result = a.multiply(a).add(b.multiply(b)).isEqualTo(c.multiply(c));
        System.out.println(result.get());
    }
}
