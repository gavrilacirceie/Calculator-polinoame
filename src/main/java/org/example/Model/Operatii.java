package org.example.Model;

import java.util.HashMap;
import java.util.Map;

public class Operatii {

    public Polinom Add(Polinom a, Polinom b)
    {
        HashMap<Integer, Double> result = new HashMap<>();
        for(Map.Entry<Integer, Double> entry : a.polinom.entrySet()){
            int exponent = entry.getKey();
            double coefficent = entry.getValue();
            result.put(exponent, coefficent);
        }
        for(Map.Entry<Integer, Double> entry : b.polinom.entrySet()){
            int exponent = entry.getKey();
            double coefficent = entry.getValue();
            if(result.containsKey(exponent))
            {
                coefficent+=result.get(exponent);
            }
            result.put(exponent, coefficent);
        }
        return new Polinom(result);
    }
    public Polinom Subtract(Polinom a, Polinom b) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : a.polinom.entrySet()) {
            int exponent = entry.getKey();
            double coefficent = entry.getValue();
            result.put(exponent, coefficent);
        }
        for (Map.Entry<Integer, Double> entry : b.polinom.entrySet()) {
            int exponent = entry.getKey();
            double coefficent = entry.getValue();
            if (result.containsKey(exponent)) {
                coefficent -= result.get(exponent);
            }
            result.put(exponent, -coefficent);
        }
        return new Polinom(result);
    }
    public Polinom Multiply(Polinom a, Polinom b) {
        HashMap<Integer, Double> result = new HashMap<>();
        for(Map.Entry<Integer, Double> entryA : a.polinom.entrySet()){
            int exponentA = entryA.getKey();
            double coefficientA = entryA.getValue();
            for(Map.Entry<Integer, Double> entryB : b.polinom.entrySet()){
                int exponentB = entryB.getKey();
                double coefficientB = entryB.getValue();
                int exponentResult = exponentA + exponentB;
                double coefficientResult = coefficientA * coefficientB;
                if(result.containsKey(exponentResult)) {
                    coefficientResult += result.get(exponentResult);
                }
                result.put(exponentResult, coefficientResult);
            }
        }
        return new Polinom(result);
    }
    public Polinom Derivate(Polinom p) {
        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : p.polinom.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();
            if (exponent > 0) {
                result.put(exponent - 1, exponent * coefficient);
            }
        }
        return new Polinom(result);
    }
    public Polinom Integrate(Polinom p) {
        HashMap<Integer, Double> result = new HashMap<>();
        for(Map.Entry<Integer, Double> entry : p.polinom.entrySet()){
            int exponent = entry.getKey() + 1;
            double coefficent = entry.getValue() / exponent;
            result.put(exponent, coefficent);
        }

        return new Polinom(result);
    }




}
