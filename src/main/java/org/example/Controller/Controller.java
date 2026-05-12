package org.example.Controller;

import org.example.Model.Operatii;
import org.example.Model.Polinom;
import org.example.View.View;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Controller extends Component {
    private View graphicalUserInterface;

    public Controller(View gui) {
        this.graphicalUserInterface = gui;
        OperationsListeners();
    }

    public HashMap<Integer, Double> getPolinom(String polynom) {
        HashMap<Integer, Double> result = new HashMap<>();
        double coeficient;
        int putere;
        if (polynom == null) {
            result.put(0, 0.0);
        } else {
            String template = "([+-]?)(\\d*x\\^\\d+|\\d*x|\\d+|x)";
            Pattern pattern = Pattern.compile(template);
            Matcher matcher = pattern.matcher(polynom);
            while (matcher.find()) {
                coeficient = 1;
                if (matcher.group(1).equals("-")) {
                    coeficient = -1;
                }
                if (matcher.group(2).equals("x")) {
                    putere = 1;
                } else if (matcher.group(2).equals("x^")) {
                    putere = Integer.parseInt(matcher.group(3));
                } else if (matcher.group(2).matches("\\d+")) {
                    putere = 0;
                    coeficient *= Double.parseDouble(matcher.group(2));
                } else if (matcher.group(2).matches("\\d*x")) {
                    putere = 1;
                    coeficient *= Double.parseDouble(matcher.group(2).replace("x", ""));
                } else {
                    String coefStr = matcher.group(2).substring(0, matcher.group(2).indexOf("x"));
                    if (coefStr.isEmpty()) {
                        coeficient *= 1;
                    } else {
                        coeficient *= Double.parseDouble(coefStr);
                    }
                    putere = Integer.parseInt(matcher.group(2).substring(matcher.group(2).indexOf("^") + 1));
                }
                result.put(putere, coeficient);
            }
        }
        return result;
    }
    private void OperationsListeners()
    {
        graphicalUserInterface.getAddButton().addActionListener(e ->{

            Polinom polinom1 = new Polinom(this.getPolinom(graphicalUserInterface.getFirstPolynomField()));
            Polinom polinom2 = new Polinom(this.getPolinom(graphicalUserInterface.getSecondPolynomField()));
            System.out.println("Polinom1: ");
            System.out.println(polinom1);
            System.out.println("Polinom2: ");
            System.out.println(polinom2);
            Operatii operatii = new Operatii();
            Polinom result = operatii.Add(polinom1, polinom2);
            graphicalUserInterface.setResultPolynomField1(result.toString());
            graphicalUserInterface.setResultPolynomField2(null);
        });

        graphicalUserInterface.getSubtractButton().addActionListener(e ->{

            Polinom polinom1 = new Polinom(this.getPolinom(graphicalUserInterface.getFirstPolynomField()));
            Polinom polinom2 = new Polinom(this.getPolinom(graphicalUserInterface.getSecondPolynomField()));
            Operatii operatii = new Operatii();
            Polinom result = operatii.Subtract(polinom1, polinom2);
            graphicalUserInterface.setResultPolynomField1(result.toString());
            graphicalUserInterface.setResultPolynomField2(null);
        });

        graphicalUserInterface.getMultiplyButton().addActionListener(e ->{

            Polinom polinom1 = new Polinom(this.getPolinom(graphicalUserInterface.getFirstPolynomField()));
            Polinom polinom2 = new Polinom(this.getPolinom(graphicalUserInterface.getSecondPolynomField()));
            Operatii operatii = new Operatii();
            Polinom result = operatii.Multiply(polinom1, polinom2);
            graphicalUserInterface.setResultPolynomField1(result.toString());
            graphicalUserInterface.setResultPolynomField2(null);

        });

        graphicalUserInterface.getDiffButton().addActionListener(e ->{

            Polinom polinom1 = new Polinom(this.getPolinom(graphicalUserInterface.getFirstPolynomField()));
            Polinom polinom2 = new Polinom(this.getPolinom(graphicalUserInterface.getSecondPolynomField()));
            Operatii operatii = new Operatii();
            Polinom result = operatii.Derivate(polinom1);
            Operatii operatii2 = new Operatii();
            Polinom result2 = operatii2.Derivate(polinom2);
            graphicalUserInterface.setResultPolynomField1(result.toString());
            graphicalUserInterface.setResultPolynomField2(result2.toString());

        });

        graphicalUserInterface.getIntegrateButton().addActionListener(e ->{

            Polinom polinom1 = new Polinom(this.getPolinom(graphicalUserInterface.getFirstPolynomField()));
            Polinom polinom2 = new Polinom(this.getPolinom(graphicalUserInterface.getSecondPolynomField()));
            Operatii operatii = new Operatii();
            Polinom result = operatii.Integrate(polinom1);
            Operatii operatii2 = new Operatii();
            Polinom result2 = operatii2.Integrate(polinom2);
            graphicalUserInterface.setResultPolynomField1(result.toString());
            graphicalUserInterface.setResultPolynomField2(result2.toString());
        });


    }

    public View getGraphicalUserInterface() {
        return graphicalUserInterface;
    }

    public void setGraphicalUserInterface(View graphicalUserInterface) {
        this.graphicalUserInterface = graphicalUserInterface;
    }
}
