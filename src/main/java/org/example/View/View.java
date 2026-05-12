package org.example.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JPanel{

    private String name;
    private JFrame windowFrame;
    private JPanel titlePanel;
    private JTextField titleField;
    private JPanel inputPanel;
    private JTextField firstPolynom;
    private JTextField firstPolynomField;
    private JTextField secondPolynom;
    private JTextField secondPolynomField;
    private JPanel outputPanel;
    private JTextField resultField;
    private JPanel resultArea;
    private JTextField resultPolynomField1;
    private JTextField resultPolynomField2;
    private JPanel buttonsPanel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton diffButton;
    private JButton integrateButton;
    private JPanel originPanel1;
    private JPanel originPanel2;

    public View(String name)
    {
        this.name = name;

        //Window initialization area
        windowFrame = new JFrame("Calculator de polinoame");
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(new Dimension(400,400));
        windowFrame.setLocation(400,100);
        windowFrame.setResizable(false);
        windowFrame.getContentPane().setBackground(Color.lightGray);

        //Title area
        titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        titlePanel.setBackground(Color.lightGray);

        titleField = new JTextField("Calculator Polinoame");
        titleField.setFont(new Font("Serif", Font.BOLD, 24));
        titleField.setEditable(false);
        titleField.setBackground(Color.lightGray);

        titlePanel.add(titleField);

        //Input area
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBorder(new EmptyBorder(10, 30, 20, 30));
        inputPanel.setBackground(Color.lightGray);

        firstPolynom = new JTextField("Primul polinom");
        firstPolynom.setFont(new Font("Serif", Font.BOLD, 14));
        firstPolynom.setEditable(false);

        firstPolynomField = new JTextField();
        firstPolynomField.setFont(new Font("Serif",Font.PLAIN, 14));

        secondPolynom = new JTextField("Al doilea polinom");
        secondPolynom.setFont(new Font("Serif", Font.BOLD, 14));
        secondPolynom.setEditable(false);

        secondPolynomField = new JTextField();
        secondPolynomField.setFont(new Font("Serif", Font.PLAIN, 14));

        inputPanel.add(firstPolynom);
        inputPanel.add(firstPolynomField);
        inputPanel.add(secondPolynom);
        inputPanel.add(secondPolynomField);

        //Output area
        outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(1,1));
        outputPanel.setBackground(Color.lightGray);
        outputPanel.setBorder(new EmptyBorder(10, 30, 20, 30));

        resultField = new JTextField("Rezultat");
        resultField.setFont(new Font("Serif", Font.BOLD, 14));
        resultField.setEditable(false);

        resultArea = new JPanel();
        resultArea.setLayout(new GridLayout(2,1));
        resultArea.setBackground(Color.lightGray);

        resultPolynomField1 = new JTextField();
        resultPolynomField1.setFont(new Font("Serif", Font.PLAIN, 14));

        resultPolynomField2 = new JTextField();
        resultPolynomField2.setFont(new Font("Serif", Font.PLAIN, 14));

        resultArea.add(resultPolynomField1);
        resultArea.add(resultPolynomField2);

        outputPanel.add(resultField);
        outputPanel.add(resultArea);

        //Buttons area
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2,3));
        buttonsPanel.setBackground(Color.lightGray);
        buttonsPanel.setBorder(new EmptyBorder(10,30,20,30));

        addButton = new JButton("Add");
        addButton.setFont(new Font("Serif",Font.BOLD, 20));
        addButton.setBackground(Color.lightGray);

        subtractButton = new JButton("Subtract");
        subtractButton.setFont(new Font("Serif",Font.BOLD, 20));
        subtractButton.setBackground(Color.lightGray);

        multiplyButton = new JButton("Multiply");
        multiplyButton.setFont(new Font("Serif",Font.BOLD, 20));
        multiplyButton.setBackground(Color.lightGray);

        divideButton = new JButton("Divide");
        divideButton.setFont(new Font("Serif",Font.BOLD, 20));
        divideButton.setBackground(Color.lightGray);

        diffButton = new JButton("Derivata");
        diffButton.setFont(new Font("Serif",Font.BOLD, 20));
        diffButton.setBackground(Color.lightGray);

        integrateButton = new JButton("Integrare");
        integrateButton.setFont(new Font("Serif",Font.BOLD, 20));
        integrateButton.setBackground(Color.lightGray);

        buttonsPanel.add(addButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(multiplyButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(diffButton);
        buttonsPanel.add(integrateButton);

        //Command unit
        originPanel1 = new JPanel();
        originPanel1.setBackground(Color.darkGray);
        originPanel1.setLayout(new GridLayout(4, 1));
        originPanel1.add(titlePanel);
        originPanel1.add(inputPanel);
        originPanel1.add(outputPanel);
        originPanel1.add(buttonsPanel);

        originPanel2 = new JPanel();
        originPanel2.setBackground(Color.black);
        originPanel2.add(originPanel1);
        windowFrame.add(originPanel2);

        windowFrame.setVisible(true);
    }

    public JPanel getOriginPanel2() {
        return originPanel2;
    }

    public JFrame getWindowFrame() {
        return windowFrame;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JPanel getInputPanel() {
        return inputPanel;
    }

    public JTextField getFirstPolynom() {
        return firstPolynom;
    }

    public String getFirstPolynomField() {
        return firstPolynomField.getText();
    }


    public JTextField getSecondPolynom() {
        return secondPolynom;
    }

    public String getSecondPolynomField() {
        return secondPolynomField.getText();
    }

    public JPanel getOutputPanel() {
        return outputPanel;
    }

    public String getResultField() {
        return resultField.getText();
    }

    public JPanel getResultArea() {
        return resultArea;
    }

    public JTextField getResultPolynomField1() {
        return resultPolynomField1;
    }

    public void setResultPolynomField1(String result){
        resultPolynomField1.setText(result);
    }

    public JTextField getResultPolynomField2() {
        return resultPolynomField2;
    }

    public void setResultPolynomField2(String result){
        resultPolynomField2.setText(result);
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDiffButton() {
        return diffButton;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }

    public JPanel getOriginPanel1() {
        return originPanel1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
