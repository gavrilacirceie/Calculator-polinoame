package org.example;

import org.example.Controller.Controller;
import org.example.Model.Operatii;
import org.example.Model.Polinom;
import org.example.View.View;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        View view = new View("Calculatorul de polinoame");
        Controller controller = new Controller(view);
        HashMap<Integer, Double> p1 = new HashMap<>();
        p1.put(0, 2.0);
        p1.put(1, 1.0);
        p1.put(5, 2.0);
        Polinom a = new Polinom(p1);

        HashMap<Integer, Double> p2 = new HashMap<>();
        p2.put(1, 1.0);
        p2.put(2, 4.0);
        Polinom b = new Polinom(p2);
        System.out.println("Polinom a: " + a);
        System.out.println("Polinom b: " + b);
        Operatii operatii = new Operatii();
        Polinom c = operatii.Multiply(a, b);
        Polinom d = operatii.Add(a, b);
        Polinom e = operatii.Subtract(a,b);
        System.out.println("Rezultatul adunarii este: " + d.toString());
        System.out.println("Rezultatul scaderii este: " + e.toString());
        System.out.println("Rezultatul multiplicari este: " + c.toString());
        System.out.println("Rezultatul derivatei este: " + operatii.Derivate(a).toString());
        System.out.println("Rezultatul integralei este: " + operatii.Integrate(a).toString());


    }
}