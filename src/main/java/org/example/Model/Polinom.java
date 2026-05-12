package org.example.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Polinom {
    HashMap<Integer, Double> polinom;
    private int gradPolinom;

    public Polinom(HashMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        StringBuilder polinom = new StringBuilder();
        List<Integer> sortedExponents = new ArrayList<>(this.polinom.keySet());
        Collections.sort(sortedExponents, Collections.reverseOrder());
        for (int exponent : sortedExponents) {
            double coeficient = this.polinom.get(exponent);
            if (coeficient == 0) {
                continue;
            }
            if (coeficient < 0) {
                if (Math.abs(coeficient + 1.0 ) < 0.0001 && exponent != 0)
                    polinom.append("-");
                else if (Math.abs(coeficient + (int)coeficient) < 0.0001)
                    polinom.append((int)coeficient);
                else
                    polinom.append(new DecimalFormat("#.##").format(coeficient));
            } else if (Math.abs(coeficient - 1.0) < 0.0001 && exponent != 0)
                polinom.append("+");
            else if (Math.abs(coeficient - (int)coeficient) < 0.0001)
                polinom.append("+").append((int)coeficient);
            else
                polinom.append("+").append(new DecimalFormat("#.##").format(coeficient));
            if (exponent != 0) {
                if (exponent == 1)
                    polinom.append("x");
                else
                    polinom.append("x^").append(exponent);
            }
        }
        if (polinom.length() == 0) {
            polinom.append("0");
        }
        else if (polinom.charAt(0) == '+') {
            polinom.deleteCharAt(0);
        }
        return polinom.toString();
    }

}

