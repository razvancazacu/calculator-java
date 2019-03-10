package com.calculator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JPanel calculatorPanel;
    private JTextField textFieldResult;
    private JButton button1;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton button6;
    private JButton button9;
    private JButton buttonEqual;
    private JButton button3;
    private JButton buttonFactorial;
    private JButton buttonLn;
    private JButton buttonLog;
    private JButton buttonRad;
    private JButton buttonXPowY;
    private JButton buttonLeftPar;
    private JButton buttonRightPar;
    private JButton button7;
    private JButton button8;
    private JButton button4;
    private JButton button5;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonClear;
    private JButton buttonProc;
    private JButton button0;
    private JButton buttonDot;
    private JButton button2;
    private JRadioButton lockRadioButton;
    private JRadioButton unlockRadioButton;
    private JButton buttonDelete;
    private JLabel label1;

    double numb, answ;
    int calculation;

    public Calculator() {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "9");
            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText("");
                label1.setText("");
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numb = Double.parseDouble(textFieldResult.getText());
                calculation = 3;
                textFieldResult.setText("");
                label1.setText(numb + "*");
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numb = Double.parseDouble(textFieldResult.getText());
                calculation = 4;
                textFieldResult.setText("");
                label1.setText(numb + "÷");
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldResult.getText().length() > 0) {
                    numb = Double.parseDouble(textFieldResult.getText());
                    calculation = 2;
                    textFieldResult.setText("");
                    label1.setText(numb + "-");
                } else {
                    textFieldResult.setText("-");
                }
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + ".");
            }
        });
        /**
         * Making the radio buttons so that only one can be active.
         * If radio button "LOCK" is selected
         * Buttons cannot be pressed
         */
        lockRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unlockRadioButton.isSelected()) {
                    unlockRadioButton.setSelected(false);
                }
                lockRadioButton.setSelected(true);

                //Disable interactions with calculator
                disable();
            }
        });
        unlockRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lockRadioButton.isSelected()) {
                    lockRadioButton.setSelected(false);
                }
                unlockRadioButton.setSelected(true);

                //Enable interactions with calculator
                enable();
            }
        });
        buttonLeftPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + "(");

            }
        });
        buttonRightPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText(textFieldResult.getText() + ")");

            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int length = textFieldResult.getText().length();
                int number = textFieldResult.getText().length() - 1;
                String store;
                /**
                 * Creating empty string builder for storing strings.
                 * In this case storing in object "back" the text in "textFieldResult"
                 */
                if (length > 0) {
                    StringBuilder back = new StringBuilder(textFieldResult.getText());
                    back.deleteCharAt(number);
                    store = back.toString();
                    textFieldResult.setText(store);
                }
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numb = Double.parseDouble(textFieldResult.getText());
                calculation = 1;
                textFieldResult.setText("");
                label1.setText(numb + "+");
            }
        });
        unlockRadioButton.setEnabled(false);

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arithmeticOperation();
                label1.setText("");
                calculation = 0;
            }
        });
        buttonFactorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculation = 5;
                arithmeticOperation();
            }
        });
        buttonLn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculation = 6;
                arithmeticOperation();
            }
        });
        buttonRad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculation = 7;
                arithmeticOperation();
            }
        });
        buttonXPowY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numb = Double.parseDouble(textFieldResult.getText());
                calculation = 8;
                textFieldResult.setText("");
                label1.setText(numb + "^");
            }
        });
        buttonProc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numb = Double.parseDouble(textFieldResult.getText());
                calculation = 9;
                textFieldResult.setText("");
                label1.setText(numb + "%");
            }
        });
    }

    public void arithmeticOperation() {
        switch (calculation) {
            case 0: // No operation
                JOptionPane.showMessageDialog(null, "Please select an operation");
                break;
            case 1: // Addition
                answ = numb + Double.parseDouble(textFieldResult.getText());
                textFieldResult.setText(Double.toString(answ));
                break;
            case 2: // Sub
                answ = numb - Double.parseDouble(textFieldResult.getText());
                textFieldResult.setText(Double.toString(answ));
                break;
            case 3: //  Multiply
                answ = numb * Double.parseDouble(textFieldResult.getText());
                textFieldResult.setText(Double.toString(answ));
                break;
            case 4: //  Divide
                answ = numb / Double.parseDouble(textFieldResult.getText());
                textFieldResult.setText(Double.toString(answ));
                break;
            case 5: //  Factorial
                answ = 1;
                for (int i = 1; i <= Double.parseDouble(textFieldResult.getText()); i++) {
                    answ *= i;
                }
                textFieldResult.setText(Double.toString(answ));
                break;
            case 6: //  Natural Log
                answ = Math.log(Double.parseDouble(textFieldResult.getText()));
                textFieldResult.setText(Double.toString(answ));
                break;
            case 7: // Radical
                answ = Math.sqrt(Double.parseDouble(textFieldResult.getText()));
                textFieldResult.setText(Double.toString(answ));
                break;
            case 8: // Pow
                answ = Math.pow(numb, Double.parseDouble(textFieldResult.getText()));
                textFieldResult.setText(Double.toString(answ));
                break;
            case 9: // Proc
                answ = (numb * 100) / Double.parseDouble(textFieldResult.getText());
                textFieldResult.setText(Double.toString(answ));
        }
    }

    public void disable() {
        /**
         * Wanted to disable every button at a time,
         * but disabling every component by
         * main panel "getComponents()" it's faster and cleaner
         */
//        button0.setEnabled(false);
//        button1.setEnabled(false);
//        button2.setEnabled(false);
//        button3.setEnabled(false);
//        button4.setEnabled(false);
//        button5.setEnabled(false);
//        button6.setEnabled(false);
//        button7.setEnabled(false);
//        button8.setEnabled(false);
//        button9.setEnabled(false);

        Component[] component = calculatorPanel.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setEnabled(false);
            }
        }

        //  Additional buttons from the second panel
        buttonDelete.setEnabled(false);
        lockRadioButton.setEnabled(false);
        unlockRadioButton.setEnabled(true);
        textFieldResult.setEnabled(false);
    }

    public void enable() {
        Component[] component = calculatorPanel.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                button.setEnabled(true);
            }
        }

        //  Additional buttons from the second panel
        buttonDelete.setEnabled(true);
        lockRadioButton.setEnabled(true);
        unlockRadioButton.setEnabled(false);
        textFieldResult.setEnabled(true);
    }

    public static void main(String[] args) {

        //  Creating the frame and adding atributes
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculatorPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(750, 450, 700, 400);
        frame.setVisible(true);

//        Set the frame icon to an image loaded from a file.
//      frame.setIconImage(new ImageIcon(imgURL).getImage());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        calculatorPanel = new JPanel();
        calculatorPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 5, new Insets(5, 5, 5, 5), 0, 0));
        calculatorPanel.setBackground(new Color(-11895893));
        calculatorPanel.setEnabled(true);
        calculatorPanel.setMinimumSize(new Dimension(700, 400));
        calculatorPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-4473925)), null, TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
        button0 = new JButton();
        button0.setBackground(new Color(-5072434));
        button0.setText("0");
        calculatorPanel.add(button0, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button1 = new JButton();
        button1.setBackground(new Color(-5072434));
        button1.setText("1");
        calculatorPanel.add(button1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button4 = new JButton();
        button4.setBackground(new Color(-5072434));
        button4.setText("4");
        calculatorPanel.add(button4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button7 = new JButton();
        button7.setBackground(new Color(-5072434));
        button7.setText("7");
        calculatorPanel.add(button7, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button8 = new JButton();
        button8.setBackground(new Color(-5072434));
        button8.setText("8");
        calculatorPanel.add(button8, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonRightPar = new JButton();
        buttonRightPar.setBackground(new Color(-5072434));
        buttonRightPar.setText("cos");
        calculatorPanel.add(buttonRightPar, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button5 = new JButton();
        button5.setBackground(new Color(-5072434));
        button5.setText("5");
        calculatorPanel.add(button5, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button2 = new JButton();
        button2.setBackground(new Color(-5072434));
        button2.setText("2");
        calculatorPanel.add(button2, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonDot = new JButton();
        buttonDot.setBackground(new Color(-5072434));
        buttonDot.setText(".");
        calculatorPanel.add(buttonDot, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button3 = new JButton();
        button3.setBackground(new Color(-5072434));
        button3.setText("3");
        calculatorPanel.add(button3, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button6 = new JButton();
        button6.setBackground(new Color(-5072434));
        button6.setText("6");
        calculatorPanel.add(button6, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        button9 = new JButton();
        button9.setBackground(new Color(-5072434));
        button9.setText("9");
        calculatorPanel.add(button9, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonProc = new JButton();
        buttonProc.setBackground(new Color(-5072434));
        buttonProc.setText("%");
        calculatorPanel.add(buttonProc, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonEqual = new JButton();
        buttonEqual.setBackground(new Color(-5072434));
        buttonEqual.setText("=");
        calculatorPanel.add(buttonEqual, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonClear = new JButton();
        buttonClear.setBackground(new Color(-5072434));
        buttonClear.setText("CE");
        calculatorPanel.add(buttonClear, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonDivide = new JButton();
        buttonDivide.setBackground(new Color(-5072434));
        buttonDivide.setText("÷");
        calculatorPanel.add(buttonDivide, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonMultiply = new JButton();
        buttonMultiply.setBackground(new Color(-5072434));
        buttonMultiply.setText("x");
        calculatorPanel.add(buttonMultiply, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonMinus = new JButton();
        buttonMinus.setBackground(new Color(-5072434));
        buttonMinus.setText("-");
        calculatorPanel.add(buttonMinus, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonPlus = new JButton();
        buttonPlus.setBackground(new Color(-5072434));
        buttonPlus.setText("+");
        calculatorPanel.add(buttonPlus, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(20, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonXPowY = new JButton();
        buttonXPowY.setBackground(new Color(-5072434));
        buttonXPowY.setText("X^Y");
        calculatorPanel.add(buttonXPowY, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonRad = new JButton();
        buttonRad.setBackground(new Color(-5072434));
        buttonRad.setText(" √ ");
        calculatorPanel.add(buttonRad, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonLog = new JButton();
        buttonLog.setBackground(new Color(-5072434));
        buttonLog.setText("log");
        calculatorPanel.add(buttonLog, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-11895893));
        panel1.setForeground(new Color(-5072434));
        calculatorPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldResult = new JTextField();
        textFieldResult.setBackground(new Color(-5072434));
        Font textFieldResultFont = this.$$$getFont$$$(null, -1, 24, textFieldResult.getFont());
        if (textFieldResultFont != null) textFieldResult.setFont(textFieldResultFont);
        textFieldResult.setHorizontalAlignment(4);
        panel1.add(textFieldResult, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 9, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 50), null, 0, false));
        lockRadioButton = new JRadioButton();
        lockRadioButton.setBackground(new Color(-11895893));
        lockRadioButton.setHorizontalAlignment(10);
        lockRadioButton.setHorizontalTextPosition(11);
        lockRadioButton.setSelected(false);
        lockRadioButton.setText("Lock");
        panel1.add(lockRadioButton, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        unlockRadioButton = new JRadioButton();
        unlockRadioButton.setBackground(new Color(-11895893));
        unlockRadioButton.setEnabled(false);
        unlockRadioButton.setSelected(true);
        unlockRadioButton.setText("Unlock");
        unlockRadioButton.setVerticalAlignment(0);
        unlockRadioButton.setVerticalTextPosition(0);
        panel1.add(unlockRadioButton, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        buttonDelete = new JButton();
        buttonDelete.setBackground(new Color(-5072434));
        buttonDelete.setText("Delete");
        panel1.add(buttonDelete, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 3, false));
        label1 = new JLabel();
        label1.setText("");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonFactorial = new JButton();
        buttonFactorial.setBackground(new Color(-5072434));
        buttonFactorial.setText("x!");
        calculatorPanel.add(buttonFactorial, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonLn = new JButton();
        buttonLn.setBackground(new Color(-5072434));
        buttonLn.setText("ln");
        calculatorPanel.add(buttonLn, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
        buttonLeftPar = new JButton();
        buttonLeftPar.setBackground(new Color(-5072434));
        buttonLeftPar.setText("sin");
        calculatorPanel.add(buttonLeftPar, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(5, 40), new Dimension(0, 40), new Dimension(70, 40), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return calculatorPanel;
    }

}
