package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //these are Importing necessary packages for Swing components and event handling.

public class Calculator implements ActionListener,KeyListener { //ActionListener-->interface in Java Swing used for handling action events(buttons, menu items, or text fields)
                                                                //KeyListener   -->keyboard e button press korle ki hbe ta handle kore
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[26];
    JButton sqrtButton,addButton,subButton,mulButton,divButton,decButton,equButton,delButton,clrButton,negButton;
    JButton powButton,pieButton,factButton,logButton,sinButton,cosButton,tanButton,perButton,opbrButton,clbrButton,eButton,ansButton;
    JPanel panel;

    Font myFont=new Font("Times New Roman",Font.BOLD,25); //Georgia


    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){

        frame=new JFrame("CALCULATOR by ALTAF");   //calculator window er jonne
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(610,650);  //whole calc. frame size
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY); //background color

        textfield=new JTextField();
        textfield.setBounds(50,20,500,50); //screen
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.addKeyListener(this); //

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("AC");
        sqrtButton=new JButton("√");

        powButton=new JButton("^");
        pieButton=new JButton("π");
        factButton=new JButton("!");
        logButton=new JButton("log");
        sinButton=new JButton("sin");
        cosButton=new JButton("cos");
        tanButton=new JButton("tan");
        perButton=new JButton("%");
        opbrButton=new JButton("(");
        clbrButton=new JButton(")");
        eButton=new JButton("e");
        ansButton=new JButton("ans");
        negButton=new JButton("(-)");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=sqrtButton;

        functionButtons[9]=powButton;
        functionButtons[10]=pieButton;
        functionButtons[11]=factButton;
        functionButtons[12]=logButton;
        functionButtons[13]=sinButton;
        functionButtons[14]=cosButton;
        functionButtons[15]=tanButton;
        functionButtons[16]=perButton;
        functionButtons[17]=opbrButton;
        functionButtons[18]=clbrButton;
        functionButtons[19]=eButton;
        functionButtons[20]=ansButton;

        functionButtons[21]=negButton;
        functionButtons[22]=sqrtButton;
        functionButtons[23]=delButton;
        functionButtons[24]=clrButton;

        for(int i=0; i<24; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

       // sqrtButton.setBounds(50,450,90,50); //button gulor pos.
       // delButton.setBounds(150,450,90,50);
       // clrButton.setBounds(260,450,90,50);

        panel=new JPanel();
        panel.setBounds(50,100,500,500); //main button area
        panel.setLayout(new GridLayout(8,4,9,9)); //buttons
        panel.setBackground(Color.BLUE); //bg color

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        panel.add(powButton);
        panel.add(pieButton);
        panel.add(factButton);
        panel.add(perButton);

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);

        panel.add(opbrButton);
        panel.add(clbrButton);
        panel.add(eButton);
        panel.add(ansButton);

        panel.add(negButton);
        panel.add(sqrtButton);
        panel.add(delButton);
        panel.add(clrButton);

        frame.add(panel);
        //frame.add(sqrtButton);
        //frame.add(delButton);
        //frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
        textfield.requestFocus();

    }

    public static void main(String[] args) {

        Calculator calc=new Calculator();

    }

    public void actionPerformed(ActionEvent e) {
        // Check if a number button is pressed
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                return; // Exit
            }
        }


        if (e.getSource() == sqrtButton) {
            try {
                double value = Double.parseDouble(textfield.getText());
                if (value >= 0) {
                    double sqrtValue = Math.sqrt(value);

                    if (sqrtValue % 1 == 0) {   //res. jodi int hoi .0 jate na dekhayy
                        textfield.setText(String.valueOf((int) sqrtValue)); // Display as integer
                    }
                    else {
                        String formattedResult = String.format("%.16f", sqrtValue);
                        textfield.setText(String.valueOf(formattedResult));
                    }

                    //textfield.setText(String.valueOf(sqrtValue)); // Set the square root value in the text field
                } else {
                    textfield.setText("Invalid"); //if gets neg. value
                }
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }

        else if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        else if (e.getSource() == addButton || e.getSource() == subButton || e.getSource() == mulButton || e.getSource() == divButton) {
            textfield.setText(textfield.getText().concat(((JButton) e.getSource()).getText())); //(+, -, *, /) egulay press korle ki hbe
        }
        else if (e.getSource() == equButton) {
            String expression = textfield.getText();

            try {     //exception handling er jonne(sir ajk cls e poraise -_-)
                result = evaluateExpression(expression);
                if (result % 1 == 0) {   //res. jodi int hoi .0 jate na dekhayy
                    textfield.setText(String.valueOf((int) result)); // Display as integer
                }
                else {
                    String formattedResult = String.format("%.16f", result);
                    textfield.setText(String.valueOf(formattedResult));
                }
                //textfield.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                textfield.setText("Error");
            }
        }
        else if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        else if (e.getSource() == delButton) {
            String text = textfield.getText();
            if (!text.isEmpty()) {
                textfield.setText(text.substring(0, text.length() - 1));
            }
        }

        //new buttons:

        else if (e.getSource() == powButton) {
            textfield.setText(textfield.getText().concat("^"));
        }
        else if (e.getSource() == pieButton) {
           // double x=3.141565323;
            textfield.setText(textfield.getText().concat("π"));
        }
        else if (e.getSource() == factButton) {
            textfield.setText(textfield.getText().concat("!"));
            try {
                int number = Integer.parseInt(textfield.getText());
                //int factorial = calculateFactorial(number);
                //textfield.setText(String.valueOf(factorial));
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }
        else if (e.getSource() == logButton) {
            try {
                double value = Double.parseDouble(textfield.getText());
                double logValue = Math.log10(value);
                textfield.setText(String.valueOf(logValue));
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }
        else if (e.getSource() == sinButton) {
          //  textfield.setText(textfield.getText().concat("sin("));
            try {
                double value = Double.parseDouble(textfield.getText());
                //double sinValue = Math.sin(value);
                double sinValue = Math.sin(Math.toRadians(value));
                textfield.setText(String.valueOf(sinValue));
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }
        else if (e.getSource() == cosButton) {
            try {
                double value = Double.parseDouble(textfield.getText());
                //double cosValue = Math.cos(value);
                double cosValue = Math.sin(Math.toRadians(value));
                textfield.setText(String.valueOf(cosValue));
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }
        else if (e.getSource() == tanButton) {
            try {
                double value = Double.parseDouble(textfield.getText());
                //double tanValue = Math.tan(value);
                double tanValue = Math.sin(Math.toRadians(value));
                textfield.setText(String.valueOf(tanValue));
            } catch (NumberFormatException ex) {
                textfield.setText("Invalid");
            }
        }
        else if (e.getSource() == perButton) {
            // Handle percentage calculation here
        }
        else if (e.getSource() == opbrButton) {
            textfield.setText(textfield.getText().concat("("));
        }
        else if (e.getSource() == clbrButton) {
            textfield.setText(textfield.getText().concat(")"));
        }
        else if (e.getSource() == eButton) {
            textfield.setText(textfield.getText().concat("e"));
        }
        else if (e.getSource() == ansButton) {
            // Handle using previous result here if applicable
        }
        //else if(e.getSource()==negButton){
        //    if(!currentText.isEmpty()){
         //       double temp=Double.parseDoube(currentText);
        //    }
       // }

    }

    private double evaluateExpression(String expression) {
        String[] parts = expression.split("(?<=[-+*/^!()])|(?=[-+*/^!()])"); //neg value niye kaj korar jnne
        double result = 0;
        char operator = '+';
        for (String part : parts) {
            if (!part.isEmpty()) {
                char firstChar = part.charAt(0);
                if (Character.isDigit(firstChar) || firstChar == '.') {
                    // Parse numbers
                    double number = Double.parseDouble(part);
                    if (operator == '+') {
                        result += number;
                    } else if (operator == '-') {
                        result -= number;
                    } else if (operator == '*') {
                        result *= number;
                    } else if (operator == '/') {
                        result /= number;
                    }
                    else if(operator=='^'){
                        double operand2=number;
                        double operand1=result;
                      result=(Math.pow(operand1, operand2));
                   }

                    //factt
                    else if (operator=='!') {

                    }

                   /* else if(operator=='π'){
                        number=3.141562;
                    }*/

                } else {
                    // Update the operator
                    operator = firstChar;
                }
            }
        }
        return result;
    }

    //keyboard theke value neyar jnne :
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar)) {
            textfield.setText(textfield.getText().concat(String.valueOf(keyChar)));
        } else if (keyChar == '.') {
            textfield.setText(textfield.getText().concat("."));
        } else if (keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/') {
            textfield.setText(textfield.getText().concat(String.valueOf(keyChar)));
        } else if (keyChar == KeyEvent.VK_ENTER) { //enter mane =
            equButton.doClick();
        } else if (keyChar == KeyEvent.VK_BACK_SPACE) { //backspace holo dlt button
            delButton.doClick();
        } else if (keyChar == KeyEvent.VK_ESCAPE) { //esc chaple clr er kaj korbe
            clrButton.doClick();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

/*
 * this is a simple calculator app created with using JAVA Swing
 * Created by:
 * Altaf Hossain[2021831002]
 * Software Engineering,SUST [2021-22]
 */

